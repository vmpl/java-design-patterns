package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem;

import lombok.Getter;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GemTestFactory {

    private final List<Gem> gems = new ArrayList<>();

    public GemTestFactory() {
        gems.addAll(List.of(
                new Ruby(),
                new Emerald(),
                new Diamond(),
                new Sapphire()
        ));
    }

    public Item getByRarity(Rarity rarity) {
        return gems.stream()
                .filter(gem -> gem.getRarity() == rarity)
                .findFirst().orElseThrow();
    }
}




