package com.andreygel.shop.orders;

import org.springframework.data.jpa.repository.JpaRepository;

interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {
}
