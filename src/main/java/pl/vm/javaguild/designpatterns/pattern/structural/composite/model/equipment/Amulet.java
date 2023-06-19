package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment;

import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;

public class Amulet extends Equipment {

    public Amulet(String name, Long power, Rarity rarity) {
        super(name, power, rarity);
    }
}
