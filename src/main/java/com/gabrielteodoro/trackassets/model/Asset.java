package com.gabrielteodoro.trackassets.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String symbol;
    private BigDecimal price;

    public Asset(String symbol, BigDecimal price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asset asset)) return false;

        return id != null && id.equals(asset.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
