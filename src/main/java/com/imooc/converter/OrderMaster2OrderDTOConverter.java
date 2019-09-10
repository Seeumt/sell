//package com.imooc.converter;
//
//import com.imooc.dataobject.OrderDetail;
//import com.imooc.dataobject.OrderMaster;
//import com.imooc.dto.OrderDTO;
//import com.imooc.repository.OrderDetailRepository;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//@Service
//public class OrderMaster2OrderDTOConverter {
//
//    @Autowired
//    public static OrderDetailRepository orderDetailRepository;
//    public static OrderDTO convert(OrderMaster orderMaster) {
//        OrderDTO orderDTO = new OrderDTO();
//        BeanUtils.copyProperties(orderMaster, orderDTO);
//        return orderDTO;
//    }
//
//    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
//        List<OrderDTO> orderDTOList = new ArrayList<>();
//        OrderDTO orderDTO = new OrderDTO();
//        for (OrderMaster orderMaster : orderMasterList) {
//            BeanUtils.copyProperties(orderMaster,orderDTO);
//            List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderMaster.getOrderId());
//            orderDTO.setOrderDetailList(orderDetailList);
//            orderDTOList.add(orderDTO);
//        }
//        return orderDTOList;
//    }
//}
