package com.nixsolutions.data;

import com.nixsolutions.service.Planets;

import java.math.BigDecimal;

public class Earth extends BasePlanet {

    private final BigDecimal WEIGHT = new BigDecimal(5970000000000000000000000d);
    private final BigDecimal RADIUS = new BigDecimal(6370000);

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
