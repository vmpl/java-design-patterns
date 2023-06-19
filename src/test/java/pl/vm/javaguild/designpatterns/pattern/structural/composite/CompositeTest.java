package pl.vm.javaguild.designpatterns.pattern.structural.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.factory.CompositeTestFactory;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.Rarity;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.utility.PowerUtility;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Structural pattern: Composite Test")
public class CompositeTest {

    private CompositeTestFactory testFactory;

    @BeforeEach
    void setUp() {
        testFactory = new CompositeTestFactory();
    }

    @Nested
    @DisplayName("Testing of Gem")
    class GemTest {

        private static Stream<Object[]> gemProvider() {
            return Stream.of(
                    new Object[]{Rarity.COMMON, PowerUtility.COMMON_POWER},
                    new Object[]{Rarity.RARE, PowerUtility.RARE_POWER},
                    new Object[]{Rarity.UNIQUE, PowerUtility.UNIQUE_POWER},
                    new Object[]{Rarity.LEGENDARY, PowerUtility.LEGENDARY_POWER}
            );
        }

        @ParameterizedTest
        @MethodSource("gemProvider")
        void should_return_power_of_gem(Rarity rarity, long expectedValue) {
            // given
            Item item = testFactory.getGemTestFactory().getGemsByRarity(rarity).orElseThrow();

            // when
            Long power = item.getPower();

            // then
            assertThat(power).isEqualTo(expectedValue);
        }
    }
}
