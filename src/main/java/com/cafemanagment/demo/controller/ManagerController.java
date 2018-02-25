package com.cafemanagment.demo.controller;

import com.cafemanagment.demo.model.ProductEntity;
import com.cafemanagment.demo.model.Role;
import com.cafemanagment.demo.model.TableEntity;
import com.cafemanagment.demo.service.ProductService;
import com.cafemanagment.demo.service.TableService;
import com.cafemanagment.demo.service.UserService;
import com.cafemanagment.demo.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagerController {

    @Autowired
    UserService userService;
    @Autowired
    TableService tableService;
    @Autowired
    ProductService productService;



    @RequestMapping(value = "/manager/create/waiter")
    public String createWaiter() {
        return "createWaiter";
    }

    @RequestMapping(value = "/manager/waiter/add")
    public String addWaiter(@ModelAttribute UserEntity user) {
        user.setRole(Role.WAITER);
        userService.add(user);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/waiter/delete/{id}")
    public String deleteWaiter(@PathVariable(name = "id") long id){
        userService.deleteUserById(id);
        return ("redirect:/manager");
    }

    @RequestMapping(value = "/manager/create/table")
    public String createTable(ModelMap map) {
        map.addAttribute("waiters", userService.getWaiters());
        return "createTable";
    }

    @RequestMapping(value = "/manager/table/add")
    public String addTable(@RequestParam("name") String name) {
        TableEntity table = new TableEntity();
        UserEntity waiter = userService.getUserByName(name);
        table.setUser(waiter);
        tableService.add(table);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/update/table/{id}")
    public String update(@PathVariable(name = "id") long id,ModelMap map){
        map.addAttribute("table",tableService.getById(id));
        map.addAttribute("waiters", userService.getWaiters());
        return "updateTable";
    }

    @RequestMapping(value = "/manager/table/update/{id}")
    public String updateTable(@PathVariable(name = "id") long id, @RequestParam String name) {
        TableEntity table = tableService.getById(id);
        UserEntity waiter = userService.getUserByName(name);
        table.setUser(waiter);
        tableService.updateTable(table);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/product/add")
    public String addProduct(@ModelAttribute ProductEntity productEntity) {
        productService.add(productEntity);
        return "redirect:/manager";
    }

}
