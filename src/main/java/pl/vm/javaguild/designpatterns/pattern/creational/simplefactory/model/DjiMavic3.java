package pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model;

import java.math.BigDecimal;

public class DjiMavic3 extends Gift {

    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(2000);
    private static final String DESCRIPTION = "One of the most capable small drones on the market.";

    public DjiMavic3() {
        super(DEFAULT_PRICE, DESCRIPTION);
    }
}
