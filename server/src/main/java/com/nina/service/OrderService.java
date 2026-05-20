package com.nina.service;

import com.nina.dto.OrdersPaymentDTO;
import com.nina.dto.OrdersSubmitDTO;
import com.nina.vo.OrderPaymentVO;
import com.nina.vo.OrderSubmitVO;

public interface OrderService {

    /**
     * 提交订单
     * @param ordersSubmitDTO
     * @return
     */
    OrderSubmitVO submitOrder(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 订单支付
     * @param ordersPaymentDTO
     * @return
     */
    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO) throws Exception;

    /**
     * 支付成功，修改订单状态
     * @param outTradeNo
     */
    void paySuccess(String outTradeNo);

    /**
     * 客户催单
     */
    void reminder(Long id);
}
