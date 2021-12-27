package com.andreygel.shop.rest.dto;

import com.andreygel.shop.orders.Delivery;
import com.andreygel.shop.orders.OrderStatus;
import com.andreygel.shop.orders.Payment;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema
public class OrderModel {
    private Long id;
    private String name;
    private String number;
    private Delivery delivery;
    private String deliveryAddress;
    private LocalDateTime deliveryTime;
    private Payment payment;
    private List<PurchaseModel> PurchaseList;
    private OrderStatus orderStatus;
}
