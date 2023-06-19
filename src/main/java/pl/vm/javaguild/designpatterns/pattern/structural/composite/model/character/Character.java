package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.character;

import lombok.AllArgsConstructor;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
abstract class Character implements Item {

    protected final String name;
    protected final Long power;
    protected final List<Item> equipment = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getPower() {
        return power + PowerUtility.calculatePower(equipment);
    }

    @Override
    public void add(Item item) {
        equipment.add(item);
    }

    @Override
    public void remove(Item item) {
        equipment.remove(item);
    }
}
