package com.nixsolutions.data;

import com.nixsolutions.service.Planets;

import java.math.BigDecimal;

public class Mercury extends BasePlanet {

    private final BigDecimal WEIGHT = new BigDecimal(3.33E23);
    private final BigDecimal RADIUS = new BigDecimal(2.44E6);

    public BigDecimal getWeight() {
        return WEIGHT;
    }

    public BigDecimal getRadius() {
        return RADIUS;
    }

    public BigDecimal calcAccelerationOfGravity() {
        Planets res = new Planets();
        BigDecimal calcAccelerationOfGravity = res.calcAccelerationOfGravity(this.getWeight(), this.getRadius());
        return calcAccelerationOfGravity;
    }
}
