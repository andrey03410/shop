package com.andreygel.shop.orders;

import com.andreygel.shop.goods.CakeEntity;
import com.andreygel.shop.rest.dto.Order;
import com.andreygel.shop.rest.dto.Purchase;

import java.util.List;

public interface PurchaseService {

    void addPurchase(OrderEntity orderEntity, CakeEntity cakeEntity,Integer number);

}
