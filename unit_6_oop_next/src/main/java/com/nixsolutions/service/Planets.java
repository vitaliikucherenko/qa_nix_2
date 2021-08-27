package com.nixsolutions.service;

import java.math.BigDecimal;

public class Planets implements Planet {

    private final BigDecimal GCONSTANT = new BigDecimal(0.0000000000667);

    public BigDecimal calcAccelerationOfGravity(BigDecimal weight, BigDecimal radius) {

        BigDecimal calcAccelerationOfGravity = GCONSTANT.multiply(weight.divide(radius.pow(2), 6)).setScale(2, BigDecimal.ROUND_CEILING);
        return calcAccelerationOfGravity;
    }
}
