package pl.vm.javaguild.designpatterns.pattern.structural.composite.model.character;

import lombok.Getter;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.Item;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment.EquipmentTestFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class CharacterTestFactory {

    public static final String CONAN = "Conan";
    public static final String MALFURION = "Malfurion";
    public static final String KEL_THUZAD = "Kel'Thuzad";
    public static final String GARONA = "Garona";
    public static final String GANDALF = "Gandalf";

    private final List<Character> characters = new ArrayList<>();

    public CharacterTestFactory() {
        characters.addAll(List.of(
                Barbarian.builder()
                        .name(CONAN)
                        .power(100L)
                        .equipment(new ArrayList<>())
                        .build(),
                Druid.builder()
                        .name(MALFURION)
                        .power(80L)
                        .equipment(List.of(
                                EquipmentTestFactory.SWORD_WITH_DIAMOND
                        ))
                        .build(),
                Necromancer.builder()
                        .name(KEL_THUZAD)
                        .power(50L)
                        .equipment(List.of(
                                EquipmentTestFactory.SWORD_WITH_DIAMOND,
                                EquipmentTestFactory.HELMET_WITH_RUBY_AND_EMERALD
                        ))
                        .build(),
                Roque.builder()
                        .name(GARONA)
                        .power(20L)
                        .equipment(EquipmentTestFactory.getAll())
                        .build(),
                Sorcerer.builder()
                        .name(GANDALF)
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

    public List<? extends Item> getAll() {
        return characters;
    }
}




