package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment;

import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;

public class Helmet extends Equipment {

    public Helmet(String name, Long power, Rarity rarity) {
        super(name, power, rarity);
    }
}
