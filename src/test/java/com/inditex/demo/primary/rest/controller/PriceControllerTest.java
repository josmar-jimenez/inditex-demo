package com.inditex.demo.primary.rest.controller;

import com.inditex.demo.adapters.primary.rest.controller.PriceController;
import com.inditex.demo.domain.Price;
import com.inditex.demo.ports.primary.PriceCommand;
import com.inditex.demo.ports.primary.dto.PriceResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceControllerTest{

    @InjectMocks
    PriceController priceController;
    @Mock
    PriceCommand priceCommand;
    @Mock
    ModelMapper modelMapper;
    private static final OffsetDateTime REQUEST_FARE_ID_ONE = OffsetDateTime.parse("2020-06-14T10:00:00+00:00");
    private static final int ZARA_BRAND_ID = 1;
    private static final int ZARA_PRODUCT_ID = 35455;

    @Test
    public void getPriceByProductTest(){
        //Given
        Price price = mock(com.inditex.demo.domain.Price.class);
        when(priceCommand.getPriceByProduct(any())).thenReturn(price);
        //When
        priceController.getPriceByProduct(ZARA_BRAND_ID, ZARA_PRODUCT_ID, REQUEST_FARE_ID_ONE);
        //Then
        verify(priceCommand, times(1)).getPriceByProduct(any());
        verify(modelMapper, times(1)).map(any(), eq(PriceResponse.class));
    }
}
