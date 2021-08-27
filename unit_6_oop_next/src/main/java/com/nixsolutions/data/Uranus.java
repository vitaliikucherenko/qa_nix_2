package com.nixsolutions.data;

import com.nixsolutions.service.Planets;

import java.math.BigDecimal;

public class Uranus extends BasePlanet {

    private final BigDecimal WEIGHT = new BigDecimal(8.68E25);
    private final BigDecimal RADIUS = new BigDecimal(2.53E7);

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
