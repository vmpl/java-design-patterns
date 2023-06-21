package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment;

import lombok.Getter;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Diamond;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Emerald;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Ruby;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity.COMMON;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity.LEGENDARY;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity.RARE;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility.COMMON_POWER;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility.LEGENDARY_POWER;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility.RARE_POWER;

@Getter
public class EquipmentTestFactory {

    public static final Item ARMOR_WITHOUT_GEM;
    public static final Item SWORD_WITH_DIAMOND;
    public static final Item HELMET_WITH_RUBY_AND_EMERALD;

    public static final String ARMOR_NAME = "Breastplate of the Shadow Guardian";
    public static final String SWORD_NAME = "Blade of the Fallen Kingdom";
    public static final String HELMET_NANE = "Stormcaller";

    static {
        ARMOR_WITHOUT_GEM = Armor.builder()
                .name(ARMOR_NAME)
                .power(RARE_POWER)
                .rarity(RARE)
                .gems(List.of())
                .build();
        SWORD_WITH_DIAMOND = Sword.builder()
                .name(SWORD_NAME)
                .power(LEGENDARY_POWER)
                .rarity(LEGENDARY)
                .gems(List.of(new Diamond()))
                .build();
        HELMET_WITH_RUBY_AND_EMERALD = Helmet.builder()
                .name(HELMET_NANE)
                .power(COMMON_POWER)
                .rarity(COMMON)
                .gems(List.of(new Ruby(), new Emerald()))
                .build();
    }

    private final List<Item> equipment = new ArrayList<>();

    public EquipmentTestFactory() {
        equipment.addAll(List.of(
                Armor.builder()
                        .name(ARMOR_NAME)
                        .power(RARE_POWER)
                        .rarity(RARE)
                        .gems(List.of())
                        .build(),
                Sword.builder()
                        .name(SWORD_NAME)
                        .power(LEGENDARY_POWER)
                        .rarity(LEGENDARY)
                        .gems(List.of(new Diamond()))
                        .build(),
                Helmet.builder()
                        .name(HELMET_NANE)
                        .power(COMMON_POWER)
                        .rarity(COMMON)
                        .gems(List.of(new Ruby(), new Emerald()))
                        .build()
        ));
    }

    public Item getByName(String name) {
        return getAll().stream()
                .filter(item -> Objects.equals(item.getName(), name))
                .findFirst().orElseThrow();
    }

    public List<Item> getAll() {
        return equipment;
    }
}




