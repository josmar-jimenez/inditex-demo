package com.inditex.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class PricePK implements Serializable{

    private Integer brandId;
    private Integer productId;
    private Integer fareId;
}