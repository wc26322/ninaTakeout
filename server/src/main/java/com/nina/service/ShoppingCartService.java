package com.nina.service;

import com.nina.dto.ShoppingCartDTO;
import com.nina.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {


    /**
     * 添加购物车
     * @param shoppingCartDTO
     */
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);


    /**
     * 查询购物车列表
     * @return
     */
    List<ShoppingCart> showShoppingCart();


    /**
     * 清空购物车
     */
    void clean();

    /**
     * 减少购物车
     */
    void sub(ShoppingCartDTO shoppingCartDTO);
}
