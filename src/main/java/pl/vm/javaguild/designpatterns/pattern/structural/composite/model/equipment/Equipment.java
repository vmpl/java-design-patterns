package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment;

import lombok.AllArgsConstructor;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
abstract class Equipment implements Item {

    protected final String name;
    protected final Long power;
    protected final Rarity rarity;
    protected final List<Item> sockets = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getPower() {
        return power + PowerUtility.calculatePower(sockets);
    }

    @Override
    public void add(Item item) {
        sockets.add(item);
    }

    @Override
    public void remove(Item item) {
        sockets.remove(item);
    }

    public Rarity getRarity() {
        return rarity;
    }
}
