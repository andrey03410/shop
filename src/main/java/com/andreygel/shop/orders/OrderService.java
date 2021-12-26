package com.andreygel.shop.orders;

import com.andreygel.shop.rest.dto.Order;
import com.andreygel.shop.users.UserEntity;

public interface OrderService {

     void addOrder(Order order);
}
