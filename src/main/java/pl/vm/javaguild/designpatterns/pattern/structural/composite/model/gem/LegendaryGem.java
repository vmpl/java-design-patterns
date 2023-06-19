package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem;

import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility;

public class LegendaryGem extends Gem {

    public LegendaryGem(String name) {
        super(name, PowerUtility.LEGENDARY_POWER, Rarity.LEGENDARY);
    }
}
