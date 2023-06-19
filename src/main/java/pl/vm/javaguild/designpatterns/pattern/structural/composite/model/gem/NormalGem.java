package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem;

import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility;

public class NormalGem extends Gem {

    public NormalGem(String name) {
        super(name, PowerUtility.NORMAL_POWER, Rarity.NORMAL);
    }
}
