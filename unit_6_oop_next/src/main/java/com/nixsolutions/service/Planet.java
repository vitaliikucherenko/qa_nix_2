package com.nixsolutions.service;

import java.math.BigDecimal;

public interface Planet {

    BigDecimal calcAccelerationOfGravity(BigDecimal weight, BigDecimal radius);
}
