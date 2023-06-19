package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem;

import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GemTestFactory {

    private final List<Gem> gems = new ArrayList<>();

    public GemTestFactory() {
        gems.add(new Ruby());
        gems.add(new Emerald());
        gems.add(new Diamond());
        gems.add(new Sapphire());
    }

    public Optional<? extends Item> getGemsByRarity(Rarity rarity) {
        return gems.stream()
                .filter(gem -> gem.getRarity() == rarity)
                .findFirst();
    }
}




