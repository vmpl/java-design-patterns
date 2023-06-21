package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.character;

import lombok.Getter;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment.EquipmentTestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class CharacterTestFactory {

    public static final String BARBARIAN_NAME = "Conan";
    public static final String DRUID_NAME = "Malfurion";
    public static final String NECROMANCER_NAME = "Kel'Thuzad";
    public static final String ROGUE_NAME = "Garona";
    public static final String SORCERER_NAME = "Gandalf";

    private final List<Item> characters = new ArrayList<>();

    public CharacterTestFactory(EquipmentTestFactory equipmentTestFactory) {
        characters.addAll(List.of(
                Barbarian.builder()
                        .name(BARBARIAN_NAME)
                        .power(100L)
                        .equipment(new ArrayList<>())
                        .build(),
                Druid.builder()
                        .name(DRUID_NAME)
                        .power(80L)
                        .equipment(new ArrayList<>(List.of(
                                equipmentTestFactory.getByName(EquipmentTestFactory.ARMOR_NAME)
                        )))
                        .build(),
                Necromancer.builder()
                        .name(NECROMANCER_NAME)
                        .power(50L)
                        .equipment(new ArrayList<>(List.of(
                                equipmentTestFactory.getByName(EquipmentTestFactory.SWORD_NAME),
                                equipmentTestFactory.getByName(EquipmentTestFactory.HELMET_NANE)
                        )))
                        .build(),
                Roque.builder()
                        .name(ROGUE_NAME)
                        .power(20L)
                        .equipment(new ArrayList<>(equipmentTestFactory.getAll()))
                        .build(),
                Sorcerer.builder()
                        .name(SORCERER_NAME)
                        .power(60L)
                        .equipment(new ArrayList<>())
                        .build()
        ));
    }

    public Item getByName(String name) {
        return characters.stream()
                .filter(character -> Objects.equals(character.getName(), name))
                .findFirst()
                .orElseThrow();
    }

    public List<Item> getAll() {
        return characters;
    }
}




