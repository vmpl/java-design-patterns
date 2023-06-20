package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment;

import lombok.Getter;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Diamond;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Emerald;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Ruby;

import java.util.List;

import static pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity.COMMON;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity.LEGENDARY;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity.RARE;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility.COMMON_POWER;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility.LEGENDARY_POWER;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility.RARE_POWER;

@Getter
public class EquipmentTestFactory {

    public static final Equipment ARMOR_WITHOUT_GEM;
    public static final Equipment SWORD_WITH_DIAMOND;
    public static final Equipment HELMET_WITH_RUBY_AND_EMERALD;

    static {
        ARMOR_WITHOUT_GEM = Armor.builder()
                .name("Breastplate of the Shadow Guardian")
                .power(RARE_POWER)
                .rarity(RARE)
                .gems(List.of())
                .build();
        SWORD_WITH_DIAMOND = Sword.builder()
                .name("Blade of the Fallen Kingdom")
                .power(LEGENDARY_POWER)
                .rarity(LEGENDARY)
                .gems(List.of(new Diamond()))
                .build();
        HELMET_WITH_RUBY_AND_EMERALD = Helmet.builder()
                .name("Stormcaller")
                .power(COMMON_POWER)
                .rarity(COMMON)
                .gems(List.of(new Ruby(), new Emerald()))
                .build();
    }

    public List<Item> getAll() {
        return List.of(ARMOR_WITHOUT_GEM, SWORD_WITH_DIAMOND, HELMET_WITH_RUBY_AND_EMERALD);
    }
}




