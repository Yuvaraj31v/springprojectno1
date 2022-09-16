<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

      <table border="2" width="70%">
      <tr><th>Firstname</th><th>lastname</th><th>email</th><th>PhoneNumber</th><th>address</th></tr>
   <c:forEach var="user" items="${list}" >
   <tr>
    <td>${user.firstname}</td><br>
    <td>${user.lastname}</td><br>
    <td>${user.email}</td><br>
    <td>${user.phone}</td><br>
    <td>${user.address}</td><br>
   </tr>
   </c:forEach>
    </table>
    <a href="index.jsp">Home</a>


