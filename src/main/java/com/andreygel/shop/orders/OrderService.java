package com.andreygel.shop.orders;

import com.andreygel.shop.rest.dto.Order;
import com.andreygel.shop.rest.dto.OrderModel;
import com.andreygel.shop.users.UserEntity;

import java.util.List;

public interface OrderService {

     void addOrder(Order order);
     void changeOrderStatus(Long id, OrderStatus status);
     void deleteOrder(Long id);
     List<OrderModel> getOrders();
     OrderModel getOrder(Long id);
}
