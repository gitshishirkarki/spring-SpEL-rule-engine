package com.shishir.expression.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component(value = "FourWheelerLatestPurchase")
public class FourWheelerLatestPurchase {
    public void performAction(){
        log.info("FourWheelerLatestPurchase bean called.");
    }
}
