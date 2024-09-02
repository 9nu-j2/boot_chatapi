package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SalesGroupBy {
    private String category;
    private int cnt;
    private float price;
    private float amount;

    @Builder
    public SalesGroupBy(String category, int cnt, float price, float amount) {
        super();
        this.category = category;
        this.cnt = cnt;
        this.price = price;
        this.amount = amount;
    }
}
