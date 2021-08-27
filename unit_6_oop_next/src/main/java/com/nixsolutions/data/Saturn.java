package com.nixsolutions.data;

import com.nixsolutions.service.Planets;

import java.math.BigDecimal;

public class Saturn extends BasePlanet {

    private final BigDecimal WEIGHT = new BigDecimal(5.68E26);
    private final BigDecimal RADIUS = new BigDecimal(5.73E7);

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
