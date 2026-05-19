package com.gabrielteodoro.trackassets.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "portfolios")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Long userId;

    @ManyToOne
    private Asset asset;

    public Portfolio(Long userId, Asset asset) {
        this.userId = userId;
        this.asset = asset;
    }
}
