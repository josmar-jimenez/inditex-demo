package com.inditex.demo.ports.primary;

import com.inditex.demo.adapters.secondary.db.repository.PriceRepository;
import com.inditex.demo.domain.Price;
import com.inditex.demo.ports.primary.dto.PriceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PriceCommand{

    @Autowired
    PriceRepository priceRepository;

    public Price getPriceByProduct(PriceRequest request){
        List<Price> response = priceRepository.findActualPriceByBrandIdAndProductId(
                request.getBrandId(), request.getProductId(), request.getApplicationDate());
        if(CollectionUtils.isEmpty(response))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not found");
        return response.get(0);
    }

}
