package com.imooc.Controller;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController


public class OrderController {
    @Resource
    private OrderService orderService;
    @PostMapping("/order")
    public OrderDTO findOne(String id) {
        OrderDTO one = orderService.findOne(id);
        return one;
    }
}
