package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment;

import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;

public class Armor extends Equipment {

    public Armor(String name, Long power, Rarity rarity) {
        super(name, power, rarity);
    }
}
