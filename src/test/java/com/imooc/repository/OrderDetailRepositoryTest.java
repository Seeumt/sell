package com.imooc.repository;

import com.imooc.dataobject.OrderDetail;
import org.hibernate.criterion.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.swing.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Test
    public void test1() {
        List<OrderDetail> all = orderDetailRepository.findByOrderId("1568204989304220665");
        for (OrderDetail orderDetail : all) {
            System.out.println(orderDetail);
        }
    }

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail("159753", "2", "2", "xx?", new BigDecimal(66), 6, "xxxx.ss");
        orderDetailRepository.save(orderDetail);
    }

}