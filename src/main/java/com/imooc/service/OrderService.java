package com.imooc.service;

import com.imooc.dataobject.OrderMaster;
import com.imooc.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {

    /*
    创建订单
     */
    OrderDTO create(OrderDTO orderDTO);

    /*
    查询单个订单
     */
    OrderDTO findOne(String orderId);

    /*
    查询某个用户的订单列表
     */
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    /*
    取消订单
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /*
    完结订单
     */
    OrderDTO finish(OrderDTO orderDTO);

    /*
    支付订单
     */
    OrderDTO paid(OrderDTO orderDTO);

    /*
   查询出数据库中所有订单列表
    */
    Page<OrderDTO> findList(Pageable pageable);


}
