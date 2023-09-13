package com.inditex.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "prices")
@IdClass(PricePK.class)
public class Price implements Serializable{
    @Id
    @Column
    private Integer brandId;
    @Id
    @Column
    private Integer productId;
    @Id
    @Column
    private Integer fareId;
    @Column
    private Integer priority;
    @Column
    private BigDecimal price;
    @Column
    private String currency;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime startDate;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime endDate;
}

