package pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model;

import java.math.BigDecimal;

public class BleuDeChannel extends Gift {

    private static final BigDecimal DEFAULT_PRICE = BigDecimal.valueOf(200);
    private static final String DESCRIPTION = "BLEU DE CHANEL asserts an accomplished character through a timeless and unexpected scent..";

    public BleuDeChannel() {
        super(DEFAULT_PRICE, DESCRIPTION);
    }
}
