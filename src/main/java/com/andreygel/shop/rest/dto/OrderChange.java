package com.andreygel.shop.rest.dto;

import com.andreygel.shop.orders.OrderStatus;
import lombok.Data;

@Data
public class OrderChange {
    private OrderStatus status;
}
