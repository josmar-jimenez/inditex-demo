package com.inditex.demo.ports.primary.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PriceResponse{

    private int brandId;
    private int fareId;
    private int productId;
    private String currency;
    private BigDecimal price;
    private String startDate;
    private String endDate;
}
