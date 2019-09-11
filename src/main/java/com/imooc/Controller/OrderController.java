package com.imooc.Controller;

import com.imooc.dto.OrderDTO;
import com.imooc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController("order")
@RequestMapping("/order")
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
