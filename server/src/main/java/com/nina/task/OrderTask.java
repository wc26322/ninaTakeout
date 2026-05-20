package com.nina.task;


import com.nina.entity.Orders;
import com.nina.mapper.OrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class OrderTask {

    @Autowired
    private OrderMapper orderMapper;


    /**
     * 每1分钟执行一次，处理超时订单
     */
    @Scheduled(cron = "0 * * * * ?")
    public void processTimeoutOrder(){
        log.info("处理超时订单：{}", LocalDateTime.now());

        LocalDateTime time = LocalDateTime.now().plusMinutes(-15);

        //查出订单状态为待支付且下单时间超过15分钟的订单
        List<Orders> orderList = orderMapper.getByStatusAndOrderTime(Orders.PENDING_PAYMENT,time);
        if(orderList != null && orderList.size() > 0){
            for (Orders orders : orderList) {
                //修改订单状态为已取消
                orders.setStatus(Orders.CANCELLED);
                orders.setCancelReason("订单超时未支付，自动取消");
                orders.setCancelTime(LocalDateTime.now());
                orderMapper.update(orders);

            }
        }
    }

    /**
     * 每天凌晨1点执行一次，处理配送订单
     */
    @Scheduled(cron = "0 0 1 * * ?")
    public void processDeliveryOrder(){
        log.info("处理配送订单：{}", LocalDateTime.now());

        LocalDateTime time = LocalDateTime.now().plusMinutes(-60);

        List<Orders> orderList = orderMapper.getByStatusAndOrderTime(Orders.DELIVERY_IN_PROGRESS,time);
        if(orderList != null && orderList.size() > 0){
            for (Orders orders : orderList) {
                //修改订单状态为已完成
                orders.setStatus(Orders.COMPLETED);
                orderMapper.update(orders);
            }
        }

    }
}

