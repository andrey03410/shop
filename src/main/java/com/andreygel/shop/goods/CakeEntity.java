package com.andreygel.shop.goods;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "CAKE")
public
class CakeEntity {

    @Setter(AccessLevel.NONE)
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Column(name = "name")
    private String name;

    private BigDecimal calories;

    private String image;

    private BigDecimal price;

    private BigDecimal weight;

    private String description;

    private BigDecimal shelfLife;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CakeEntity that = (CakeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
