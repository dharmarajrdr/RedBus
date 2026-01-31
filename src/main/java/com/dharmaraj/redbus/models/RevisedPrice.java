package com.dharmaraj.redbus.models;

import lombok.Getter;

@Getter
public class RevisedPrice {

    private final Integer oldPrice;

    private final Integer newPrice;

    public RevisedPrice(Integer oldPrice, Integer newPrice) {
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
    }

    public RevisedPrice(Integer price) {
        this.oldPrice = price;
        this.newPrice = price;
    }
}
