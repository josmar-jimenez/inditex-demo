package com.inditex.demo.ports.primary;

import com.inditex.demo.adapters.secondary.db.repository.PriceRepository;
import com.inditex.demo.domain.Price;
import com.inditex.demo.ports.primary.dto.PriceRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;
import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PriceCommandTest{

    @Mock
    PriceRepository priceRepository;

    @InjectMocks
    PriceCommand priceCommand;

    private static final int ZARA_BRAND_ID = 1;
    private static final int ZARA_PRODUCT_ID = 35455;
    private static final OffsetDateTime DATE_TIME = OffsetDateTime.now();

    @Test
    public void getPriceByProductTestShouldReturnResponse(){
        //given
        PriceRequest request = new PriceRequest(ZARA_BRAND_ID, ZARA_PRODUCT_ID, DATE_TIME);
        //when
        when(priceRepository.findActualPriceByBrandIdAndProductId(ZARA_BRAND_ID, ZARA_PRODUCT_ID,
                DATE_TIME)).thenReturn(Collections.singletonList(mock(Price.class)));
        priceCommand.getPriceByProduct(request);
        //then
        verify(priceRepository, times(1)).findActualPriceByBrandIdAndProductId(ZARA_BRAND_ID, ZARA_PRODUCT_ID,
                DATE_TIME);
    }

    @Test
    public void getPriceByProductTestShouldReturnNotFound(){
        //given
        PriceRequest request = new PriceRequest(ZARA_BRAND_ID, ZARA_PRODUCT_ID, DATE_TIME);
        //when
        when(priceRepository.findActualPriceByBrandIdAndProductId(ZARA_BRAND_ID, ZARA_PRODUCT_ID,
                DATE_TIME)).thenReturn(null);
        try{
            priceCommand.getPriceByProduct(request);
        }catch(ResponseStatusException e){
            //then
            Assertions.assertEquals(e.getStatusCode(), HttpStatus.BAD_REQUEST);
        }
    }
}
