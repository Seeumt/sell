package com.imooc.dto;

import com.imooc.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class OrderDTOTest {
    @Resource
    private OrderService orderService;
    @Test
    public void getOrderStatus() {
        OrderDTO one = orderService.findOne("1568204989304220665");
        one.getOrderStatusEnum();
    }

    @Test
    public void getPayStatus() {

    }
}