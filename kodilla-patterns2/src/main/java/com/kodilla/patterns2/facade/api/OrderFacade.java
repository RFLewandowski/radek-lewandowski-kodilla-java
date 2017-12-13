package com.kodilla.patterns2.facade.api;

import com.kodilla.patterns2.facade.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderFacade {
    @Autowired
    private ShopService shopService;

    public void processOrder(final OrderDto order, final Long userId){
        //TODO implement facade pattern
    }
}