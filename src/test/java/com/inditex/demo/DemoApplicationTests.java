package com.inditex.demo;

import com.inditex.demo.adapters.primary.rest.controller.PriceController;
import com.inditex.demo.ports.primary.dto.PriceResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;

@SpringBootTest
class DemoApplicationTests{

    private static final OffsetDateTime REQUEST_FARE_ID_ONE = OffsetDateTime.parse("2020-06-14T10:00:00+00:00");
    private static final OffsetDateTime REQUEST_FARE_ID_TWO = OffsetDateTime.parse("2020-06-14T16:00:00+00:00");
    private static final OffsetDateTime REQUEST_FARE_ID_ONE_ANOTHER = OffsetDateTime.parse("2020-06-14T21:00:00+00:00");
    private static final OffsetDateTime REQUEST_FARE_ID_THREE = OffsetDateTime.parse("2020-06-15T10:00:00+00:00");
    private static final OffsetDateTime REQUEST_FARE_ID_FOUR = OffsetDateTime.parse("2020-06-16T21:00:00+00:00");
    private static final int FARE_ID_ONE = 1;
    private static final int FARE_ID_TWO = 2;
    private static final int FARE_ID_THREE = 3;
    private static final int FARE_ID_FOUR = 4;
    private static final int ZARA_BRAND_ID = 1;
    private static final int ZARA_PRODUCT_ID = 35455;

    @Autowired
    private PriceController priceController;

    @Test
    public void shouldReturnFareIdOne(){
        ResponseEntity<PriceResponse> response = priceController.getPriceByProduct(ZARA_BRAND_ID, ZARA_PRODUCT_ID,
                REQUEST_FARE_ID_ONE);
        checkAsserts(response.getBody(), FARE_ID_ONE);

    }

    @Test
    public void shouldReturnFareIdOneAnother(){
        ResponseEntity<PriceResponse> response = priceController.getPriceByProduct(ZARA_BRAND_ID, ZARA_PRODUCT_ID,
                REQUEST_FARE_ID_ONE_ANOTHER);
        checkAsserts(response.getBody(), FARE_ID_ONE);

    }

    @Test
    public void shouldReturnFareIdTwo(){
        ResponseEntity<PriceResponse> response = priceController.getPriceByProduct(ZARA_BRAND_ID, ZARA_PRODUCT_ID,
                REQUEST_FARE_ID_TWO);
        checkAsserts(response.getBody(), FARE_ID_TWO);

    }

    @Test
    public void shouldReturnFareIdThree(){
        ResponseEntity<PriceResponse> response = priceController.getPriceByProduct(ZARA_BRAND_ID, ZARA_PRODUCT_ID,
                REQUEST_FARE_ID_THREE);
        checkAsserts(response.getBody(), FARE_ID_THREE);

    }

    @Test
    public void shouldReturnFareIdFour(){
        ResponseEntity<PriceResponse> response = priceController.getPriceByProduct(ZARA_BRAND_ID, ZARA_PRODUCT_ID,
                REQUEST_FARE_ID_FOUR);
        checkAsserts(response.getBody(), FARE_ID_FOUR);
    }

    private void checkAsserts(PriceResponse responseBody, int validFareId){
        Assertions.assertNotNull(responseBody);
        Assertions.assertEquals(responseBody.getFareId(), validFareId);
    }
}
