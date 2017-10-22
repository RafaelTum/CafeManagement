package com.cafemanagment.demo.controller;

import com.cafemanagment.demo.service.TableService;
import com.cafemanagment.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    private UserService userService;
    @Autowired
    private TableService tableService;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/manager")
    public String manager(ModelMap map) {
        map.addAttribute("waiters", userService.getWaiters());
        map.addAttribute("tables", tableService.getAll());
        return "manager";
    }


    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }
}
