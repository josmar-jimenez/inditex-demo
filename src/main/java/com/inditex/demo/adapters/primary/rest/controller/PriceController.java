package com.inditex.demo.adapters.primary.rest.controller;

import com.inditex.demo.ports.primary.PriceCommand;
import com.inditex.demo.ports.primary.dto.PriceRequest;
import com.inditex.demo.ports.primary.dto.PriceResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.time.OffsetDateTime;

@RestController
@RequestMapping("/v1")
public class PriceController{

    @Autowired
    PriceCommand priceCommand;
    @Autowired
    ModelMapper modelMapper;

    @GetMapping(value = "/price/{brandId}/{productId}/{date}")
    public ResponseEntity<PriceResponse> getPriceByProduct(@PathVariable("brandId") @Min(1) int brandId,
            @PathVariable("productId") @Min(1) int productId,
            @PathVariable("date") @Valid OffsetDateTime applicationDate){

        final PriceRequest request = new PriceRequest(brandId, productId, applicationDate);
        final PriceResponse priceResponse = modelMapper.map(priceCommand.getPriceByProduct(request),
                PriceResponse.class);
        return new ResponseEntity<>(priceResponse, HttpStatus.OK);
    }
}
