package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

public interface OrderService {

    public OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);
}
