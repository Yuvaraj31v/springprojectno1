package com.ideas2it.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.ideas2it.dao.UserDao;

import javax.sql.DataSource;
import com.ideas2it.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EnableTransactionManagement
@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    DataSource datasource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void register(User user) {

       Session session = sessionFactory.getCurrentSession();
       session.save(user);
    }

    public void update(User user) {
        String sql = "update users set firstname = ?,lastname = ?,email = ?,address = ?,phone = ? where username = ?";

        jdbcTemplate.update(sql, user.getFirstname(),
                user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone(),user.getUsername());
    }

    @Transactional
    public List<User> getEmployees(){
        Session session = sessionFactory.getCurrentSession();
        List<User> user  = session.createQuery("from User").list();
        return user;

    }

    public User getEmpById(String username){
        String sql="select * from users where username =?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username},new BeanPropertyRowMapper<User>(User.class));
    }
}

class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int arg1) throws SQLException {
        User user = new User();

        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFirstname(rs.getString("firstname"));
        user.setLastname(rs.getString("lastname"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setPhone(rs.getLong("phone"));

        return user;
    }
}
