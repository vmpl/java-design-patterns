package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem;

import lombok.RequiredArgsConstructor;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;

@RequiredArgsConstructor
abstract class Gem implements Item {

    protected final String name;
    protected final Long power;
    protected final Rarity rarity;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getPower() {
        return power;
    }

    @Override
    public void add(Item item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Item item) {
        throw new UnsupportedOperationException();
    }

    public Rarity getRarity() {
        return rarity;
    }
}

