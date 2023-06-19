package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem;

import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility;

public class UniqueGem extends Gem {

    public UniqueGem(String name) {
        super(name, PowerUtility.UNIQUE_POWER.longValue(), Rarity.NORMAL);
    }
}
