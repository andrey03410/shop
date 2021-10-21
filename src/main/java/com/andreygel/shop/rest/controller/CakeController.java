package com.andreygel.shop.rest.controller;

import com.andreygel.shop.dto.Cake;
import com.andreygel.shop.dto.Cakes;
import com.andreygel.shop.exception.CakeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@Validated
//@RequestMapping ("v1/cakes")
public class CakeController {
    private final Cakes cakeList = new Cakes();
    private static long idCounter = 1;

    public CakeController() {
        Cake cake1 = new Cake();
        cake1.setId(1L);
        cake1.setName("Napoleon");
        cake1.setPrice(new BigDecimal(100));
        cake1.setWeight(new BigDecimal(100));
        cake1.setImage("cake1.jpg");
        cake1.setCalories(new BigDecimal(100));
        Cake cake2 = new Cake();
        cake2.setId(2L);
        cake2.setName("Rose");
        cake2.setPrice(new BigDecimal(200));
        cake2.setWeight(new BigDecimal(200));
        cake2.setImage("cake1.jpg");
        cake2.setCalories(new BigDecimal(200));
        List<Cake> tmp = new ArrayList<Cake>();
        tmp.add(cake1);
        tmp.add(cake2);
        cakeList.setCakeList(tmp);
        idCounter +=2;
    }

    @GetMapping(value = "cakes", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cakes cakes() {
        return cakeList;
    }

    @GetMapping(value = "cake/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cake getCakeById(@PathVariable Long id) {
        return cakeList.getCakeList().stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new CakeNotFoundException("No such cake"));
    }

    @PostMapping(path = "cakes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cake> createCake(@RequestBody Cake newCake) {
        if (newCake.isCompleted()) {
            newCake.setId(idCounter);
            idCounter++;
            cakeList.getCakeList().add(newCake);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}