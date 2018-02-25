package com.cafemanagment.demo.controller;

import com.cafemanagment.demo.model.*;
import com.cafemanagment.demo.service.*;
import com.cafemanagment.demo.service.serviceImpl.CurrentUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class WaiterController {

    @Autowired
    OrderService orderService;
    @Autowired
    ProductInOrderService productInOrderService;
    @Autowired
    TableService tableService;
    @Autowired
    ProductService productService;
    @Autowired
    CurrentUserDetailsService currentUserDetailsService;

    @RequestMapping(value = "/waiter")
    public String waiter(ModelMap map) {
        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = currentUser.getUserEntity();
        map.addAttribute("waiter", userEntity);
        List<TableEntity> waiterTables = tableService.getTablesByUserId(userEntity.getId());
        Set<OrderEntity> tableOrders = new HashSet<>();
        Set<ProductInOrderEntity> productInOrderEntities = new HashSet<>();

        for (TableEntity table : waiterTables) {
            tableOrders.addAll(orderService.getByTableId(table.getId()));
        }
        for (OrderEntity orderEntity : tableOrders) {
            productInOrderEntities.addAll(productInOrderService.getByOrderId(orderEntity.getId()));
        }
        map.addAttribute("tables", waiterTables);
        map.addAttribute("orders", tableOrders);
        map.addAttribute("orderedProducts", productInOrderEntities);

        return "waiter";
    }

    @RequestMapping(value = "waiter/order/add/{id}")
    public String addOrder(@PathVariable long id, ModelMap map) {
        if (orderService.getByTableId(id).size() != 0) {
            map.addAttribute("message", "An active order exists");
            return "redirect:/waiter";
        }
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTable(tableService.getById(id));
        orderEntity.setStatus(OrderStatus.OPEN);
        orderService.add(orderEntity);
        return "redirect:/waiter";
    }

    @RequestMapping(value = "/waiter/add/product/{id}")
    public String addProduct(@PathVariable long id, ModelMap map) {
        ProductInOrderEntity productInOrderEntity = productInOrderService.getById(id);
        OrderEntity orderEntity = orderService.getById(id);
        map.addAttribute("product", productInOrderEntity);
        map.addAttribute("order", orderEntity);
        map.addAttribute("products", productService.getAll());
        return "addProduct";
    }

    @RequestMapping(value = "/waiter/add/productInorder")
    public String addProduct(@ModelAttribute ProductEntity productEntity, @RequestParam(name = "count") long count, @RequestParam(name = "id") long id) {
        ProductInOrderEntity productInOrderEntity = new ProductInOrderEntity();
        productInOrderEntity.setProductEntity(productEntity);
        productInOrderEntity.setOrderEntity(orderService.getById(id));
        productInOrderEntity.setAmount(count);
        productInOrderService.add(productInOrderEntity);
        return "addProduct";
    }


}
