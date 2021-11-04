package com.andreygel.shop.goods;

import org.springframework.data.jpa.repository.JpaRepository;

interface CakeRepository extends JpaRepository<CakeEntity,Long> {

    boolean existsByName(String name);

}