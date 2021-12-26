package com.andreygel.shop.orders;

import com.andreygel.shop.goods.CakeRepository;
import com.andreygel.shop.rest.dto.Order;
import com.andreygel.shop.users.UserRepository;
import com.andreygel.shop.users.UserService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;
    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final CakeRepository cakeRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, PurchaseRepository purchaseRepository, UserService userService, UserRepository userRepository, CakeRepository cakeRepository) {
        this.orderRepository = orderRepository;
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.cakeRepository = cakeRepository;
    }


    @Override
    public void addOrder(Order order) {

        OrderEntity orderEntity = new OrderEntity();


        orderEntity.setDelivery(order.getDelivery());
        orderEntity.setDeliveryAddress(order.getDeliveryAddress());
        orderEntity.setDeliveryTime(order.getDeliveryTime());
        orderEntity.setPayment(order.getPayment());
        orderEntity.setStatus(order.getOrderStatus());
        orderEntity.setPurchases(order.getPurchases().stream()
                .map(purchase -> {
                    PurchaseEntity purchaseEntity = new PurchaseEntity();
                    purchaseEntity.setNumber(purchase.getNumber());
                    purchaseEntity.setOrder(orderEntity);
                    purchaseEntity.setCake(cakeRepository.findById(purchase.getId()).orElseThrow(RuntimeException::new));
                    return purchaseEntity;
                }).collect(Collectors.toList()));
        orderEntity.setUser(userRepository.findUserEntityByNumber(order.getUser().getNumber()));
        orderRepository.saveAndFlush(orderEntity);
    }
}
