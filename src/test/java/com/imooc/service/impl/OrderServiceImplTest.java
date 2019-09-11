package com.imooc.service.impl;

import com.imooc.dataobject.OrderDetail;
import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Resource
    private OrderService orderService;

    private final String BUYER_OPENID = "666wx";


    @Test
    public void createTest() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("Hod");
        orderDTO.setBuyerAddress("Haikou");
        orderDTO.setBuyerPhone("18222222222");
        orderDTO.setBuyerOpenid("HNHod");

        //购物车?
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("2");
        o1.setProductQuantity(1000);


        OrderDetail o2 = new OrderDetail();
        o2.setProductId("4");
        o2.setProductQuantity(1000);

        OrderDetail o3 = new OrderDetail();
        o3.setProductId("2");
        o3.setProductQuantity(1000);

        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDetailList.add(o3);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}",result);
    }

    @Test
    public void findOne() {

    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1568107162038333046");

        orderService.cancel(orderDTO);
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1568082108612944259");
        orderService.finish(orderDTO);


    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1568085098800317228");
        orderService.paid(orderDTO);
    }


}