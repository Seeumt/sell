package com.imooc.controller;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController("order")
//@RequestMapping("/order")
//@Api(tags = "默认是xxx-controller --> order",description = "默认是 Xxx Controller，--> 订单描述 (已过时)")
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/findOrder")
    public OrderDTO findOne(String id) {
        OrderDTO one = orderService.findOne(id);
        return one;
    }


    @PostMapping("/allOrders")
    public Page<OrderDTO> findOne(String buyerOpenid, int page, int size) {
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(buyerOpenid, pageRequest);
        return orderDTOPage;
    }

    @PostMapping("/AllOrders")
    public Page<OrderDTO> findOne(int page, int size) {
        PageRequest pageRequest = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        return orderDTOPage;
    }

}
