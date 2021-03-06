package com.usermanagement.demo.controllers;

import com.usermanagement.demo.dao.models.User;
import com.usermanagement.demo.dto.UserDTO;
import com.usermanagement.demo.services.UserServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserServiceimpl userService;

    @GetMapping(value = "/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        mav.addObject("user", new UserDTO());
        return mav;
    }
    @PostMapping(value = "/login-process")
        public ModelAndView loginProcess(UserDTO userDTO, HttpSession session){
            System.out.println(userDTO);
            session.setAttribute("user", userDTO);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("redirect:/");
            return mav;
    }
    @GetMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("user", new UserDTO());
        return mav;
    }
    @PostMapping(value = "/register-process")
    public ModelAndView registerProcess(User user, HttpSession session){
        System.out.println(user);
        session.setAttribute("user", user);
        userService.postUser(user);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:/login");
        return mav;
    }
}
