package pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model;

import java.math.BigDecimal;

public class MillenniumFalcon extends Gift {

    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(850);
    private static final String DESCRIPTION = "Construct one of the biggest LEGO® sets ever made.";

    public MillenniumFalcon() {
        super(DEFAULT_PRICE, DESCRIPTION);
    }
}
