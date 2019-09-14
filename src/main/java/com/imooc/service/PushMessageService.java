package com.imooc.service;

import com.imooc.dto.OrderDTO;

public interface PushMessageService {
    /*
    订单状态变更消息
     */
    void orederStatus(OrderDTO orderDTO);
}
