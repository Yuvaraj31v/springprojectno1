package com.ideas2it.controller;

import com.ideas2it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ideas2it.model.User;

import java.util.List;

@Controller
public class AddController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("user",new User());
        return mav;
    }

    @RequestMapping(value = "/viewId",method = RequestMethod.GET)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("viewById");
        mav.addObject("user",new User());
        return mav;
    }
    @RequestMapping(value = "/updateForm")
    public ModelAndView  getId(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") User user) {
        ModelAndView mav = new ModelAndView();
        userService.update(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value = "/registerProcess",method =RequestMethod.POST)
    public ModelAndView get(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user")User user) {
        userService.register(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping(value="/view")
    public String viewemp(Model user){
        List<User> list=userService.getEmployees();
        user.addAttribute("list",list);
        return "viewemp";
    }
}
