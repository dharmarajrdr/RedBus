package com.dharmaraj.redbus.models;

import com.dharmaraj.redbus.enums.CurrencyCode;
import lombok.Getter;

@Getter
public class RevisedPrice {

    private final Integer oldPrice;

    private final Integer newPrice;

    private final CurrencyCode currencyCode;

    public RevisedPrice(Integer oldPrice, Integer newPrice, CurrencyCode currencyCode) {
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.currencyCode = currencyCode;
    }

    public RevisedPrice(Integer price, CurrencyCode currencyCode) {
        this.oldPrice = price;
        this.newPrice = price;
        this.currencyCode = currencyCode;
    }
}
