package com.nixsolutions.data;

import com.nixsolutions.service.Planets;

import java.math.BigDecimal;

public class Mars extends BasePlanet {

    private final BigDecimal WEIGHT = new BigDecimal(6.41E23);
    private final BigDecimal RADIUS = new BigDecimal(3.39E6);

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
