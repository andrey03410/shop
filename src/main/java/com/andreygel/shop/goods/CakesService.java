package com.andreygel.shop.goods;

import com.andreygel.shop.rest.dto.CakeDetail;
import com.andreygel.shop.rest.dto.Cakes;

public interface CakesService {
     Cakes getCakes();
     CakeDetail getCake(Long id);
     CakeEntity getCakeEntity(Long id);
     void addCake(CakeDetail cake);
}
