package pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model;

import java.math.BigDecimal;

public class WalkingPadC1 extends Gift {

    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(2000);
    private static final String DESCRIPTION = "Walkingpad C1 is a cost-effective walking treadmill for people who work from home.";

    public WalkingPadC1() {
        super(DEFAULT_PRICE, DESCRIPTION);
    }
}
