package com.inditex.demo.ports.primary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class PriceRequest{

    private int brandId;
    private int productId;
    private OffsetDateTime applicationDate;
}

