package com.andreygel.shop.rest.controller;

import com.andreygel.shop.exception.UserExistException;
import com.andreygel.shop.goods.CakesService;
import com.andreygel.shop.orders.OrderService;
import com.andreygel.shop.orders.PurchaseService;
import com.andreygel.shop.rest.dto.Cake;
import com.andreygel.shop.rest.dto.CakeDetail;
import com.andreygel.shop.rest.dto.Cakes;
import com.andreygel.shop.rest.dto.Order;
import com.andreygel.shop.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated
public class UserController {
    private final UserService userService;
    private final CakesService cakesService;
    private final PurchaseService purchaseService;
    private final OrderService orderService;


    @Autowired
    public UserController(UserService userService, CakesService cakesService, PurchaseService purchaseService, OrderService orderService) {
        this.cakesService = cakesService;
        this.userService = userService;
        this.purchaseService = purchaseService;
        this.orderService = orderService;
    }

    @GetMapping(value = "cakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes cakes() {
        return cakesService.getCakes();
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CakeDetail getCakeById(@PathVariable Long id) {
        return cakesService.getCake(id);
    }

    @PostMapping(path = "addCake", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> createCake(@RequestBody @Valid CakeDetail newCake) {
        cakesService.addCake(newCake);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(path = "addOrder", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createOrder(@RequestBody @Valid Order newOrder) {
        try {
            userService.addUser(newOrder.getUser());
        }
        catch (UserExistException ignored){
        }
        orderService.addOrder(newOrder);
    }
}
