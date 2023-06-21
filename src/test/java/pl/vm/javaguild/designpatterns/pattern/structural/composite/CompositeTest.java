package pl.vm.javaguild.designpatterns.pattern.structural.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.factory.CompositeTestFactory;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment.Armor;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment.EquipmentTestFactory;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.equipment.Helmet;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Diamond;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Ruby;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.Sapphire;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity.COMMON;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity.RARE;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility.COMMON_POWER;
import static pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility.RARE_POWER;

@DisplayName("Structural pattern: Composite Test")
public class CompositeTest {

    private CompositeTestFactory testFactory;

    @BeforeEach
    void setUp() {
        testFactory = new CompositeTestFactory();
    }

    @Nested
    @DisplayName("Testing of 'Gem'")
    class GemTest {

        @ParameterizedTest
        @CsvSource({
                "COMMON, 10",
                "RARE, 50",
                "UNIQUE, 75",
                "LEGENDARY, 100"
        })
        void should_return_power_of_gem(Rarity rarity, long expectedValue) {
            // given
            Item item = testFactory.getGemTestFactory().getByRarity(rarity);

            // when
            Long power = item.getPower();

            // then
            assertThat(power).isEqualTo(expectedValue);
        }

        @ParameterizedTest
        @EnumSource(value = Rarity.class)
        void should_throw_exception_when_trying_to_add_item(Rarity rarity) {
            // given
            Item item = testFactory.getGemTestFactory().getByRarity(rarity);

            // when & then
            assertThatThrownBy(
                    () -> item.add(new Ruby())
            ).isInstanceOf(UnsupportedOperationException.class);
        }

        @ParameterizedTest
        @EnumSource(value = Rarity.class)
        void should_throw_exception_when_trying_to_remove_item(Rarity rarity) {
            // given
            Item item = testFactory.getGemTestFactory().getByRarity(rarity);

            // when & then
            assertThatThrownBy(
                    () -> item.remove(new Ruby())
            ).isInstanceOf(UnsupportedOperationException.class);
        }
    }

    @Nested
    @DisplayName("Testing of 'Equipment'")
    class EquipmentTest {

        private static Stream<Object[]> equipmentProvider() {
            return Stream.of(
                    new Object[]{
                            "Test case 1: Armor without any gems",
                            EquipmentTestFactory.ARMOR_WITHOUT_GEM,
                            50L
                    },
                    new Object[]{
                            "Test case 2: Sword with one Diamond",
                            EquipmentTestFactory.SWORD_WITH_DIAMOND,
                            175L
                    },
                    new Object[]{
                            "Test case 3: Helmet with Ruby and Emerald",
                            EquipmentTestFactory.HELMET_WITH_RUBY_AND_EMERALD,
                            70L
                    }
            );
        }

        @ParameterizedTest(name = "{0}")
        @MethodSource("equipmentProvider")
        void should_return_power_of_equipment(String description, Item testItem, long expectedResul) {
            // given & when
            Long power = testItem.getPower();

            // then
            assertThat(power).isEqualTo(expectedResul);
        }

        @Test
        void should_add_gem_to_equipment() {
            // given
            Item gem = new Sapphire();
            Item equipment = Armor.builder()
                    .name("Breastplate of the Shadow Guardian")
                    .power(RARE_POWER)
                    .rarity(RARE)
                    .gems(new ArrayList<>())
                    .build();
            Long powerBefore = equipment.getPower();

            // when
            equipment.add(gem);
            Long powerAfter = equipment.getPower();

            // then
            assertThat(powerBefore).isLessThan(powerAfter);
            assertThat(powerBefore).isEqualTo(50L);
            assertThat(powerAfter).isEqualTo(150L);
        }

        @Test
        void should_remove_gem_from_equipment() {
            // given
            Item gem = new Diamond();
            Item equipment = Helmet.builder()
                    .name("Stormcaller")
                    .power(COMMON_POWER)
                    .rarity(COMMON)
                    .gems(new ArrayList<>(List.of(gem)))
                    .build();
            Long powerBefore = equipment.getPower();

            // when
            equipment.remove(gem);
            Long powerAfter = equipment.getPower();

            // then
            assertThat(powerBefore).isGreaterThan(powerAfter);
            assertThat(powerBefore).isEqualTo(85L);
            assertThat(powerAfter).isEqualTo(10L);
        }
    }
}
