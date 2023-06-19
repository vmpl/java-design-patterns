package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.alliance;

import lombok.AllArgsConstructor;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
class Alliance implements Item {

    protected final String name;
    protected final List<Item> characters = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getPower() {
        return PowerUtility.calculatePower(characters);
    }

    @Override
    public void add(Item item) {
        characters.add(item);
    }

    @Override
    public void remove(Item item) {
        characters.remove(item);
    }
}
