package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem;

import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility;

public class RareGem extends Gem {

    public RareGem(String name) {
        super(name, PowerUtility.RARE_POWER, Rarity.RARE);
    }
}
