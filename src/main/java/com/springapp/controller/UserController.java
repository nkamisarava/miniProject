package com.springapp.controller;

import com.springapp.entity.User;
import com.springapp.entity.enums.UserRoles;
import com.springapp.service.UserService;
import com.springapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
	model.addAttribute("message", "Hello world!");
	return "hello";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registrationForm(Model model) {
	model.addAttribute(new User());
	return "registration";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
	return "login";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(User user) {
	userService.addUser(user);
	return "redirect:/";
    }
}

