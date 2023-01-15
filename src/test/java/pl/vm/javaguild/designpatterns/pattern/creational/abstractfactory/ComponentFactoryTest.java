package pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.componentfactory.LaptopComponentFactory;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.componentfactory.impl.LaptopHighComponentFactory;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.componentfactory.impl.LaptopLowComponentFactory;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.componentfactory.impl.LaptopMediumComponentFactory;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.factoryprovider.ComponentFactoryProvider;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.factoryprovider.LaptopStoreProvider;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore.LaptopStore;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore.impl.DellLaptopStore;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore.impl.LenovoLaptopStore;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore.impl.SamsungLaptopStore;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.Producer;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.QualityLevel;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.graphiccard.GraphicCard;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.graphiccard.impl.PowerfulGraphicCard;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.graphiccard.impl.RegularGraphicCard;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.graphiccard.impl.WeakGraphicCard;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.DellLaptop;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.Laptop;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.LenovoLaptop;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.SamsungLaptop;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.motherboard.Motherboard;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.motherboard.impl.PowerfulMotherboard;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.motherboard.impl.RegularMotherboard;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.motherboard.impl.WeakMotherboard;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.processor.Processor;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.processor.impl.PowerfulProcessor;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.processor.impl.RegularProcessor;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.processor.impl.WeakProcessor;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.Producer.*;
import static pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.QualityLevel.*;

@DisplayName("Abstract Factory functionality Test")
public class ComponentFactoryTest {

    @Nested
    @DisplayName("Tests of LaptopStoreProvider")
    class LaptopStoreProviderTest {

        @ParameterizedTest(name = "{index}: Producer: {0} ")
        @EnumSource(value = Producer.class)
        @DisplayName("LaptopStoreProvider return abstract LaptopStore for all enum types")
        void should_provide_proper_laptop_store_based_on_laptop_producer(Producer producer) {
            // given
            // when
            LaptopStore laptopStore = LaptopStoreProvider.getLaptopStore(producer);

            // then
            assertThat(laptopStore)
                    .isNotNull()
                    .isInstanceOf(LaptopStore.class);
        }

        @Test
        void should_throw_npe_when_given_null_as_get_laptop_store_argument() {
            // given
            // when
            // then
            assertThrows(
                    NullPointerException.class,
                    () -> LaptopStoreProvider.getLaptopStore(null)
            );
        }

        @ParameterizedTest
        @MethodSource("provideParametersLaptopStores")
        void should_return_concrete_implementations_of_laptop_store(Producer producer, Class<LaptopStore> classOfStore) {
            // given
            // when
            LaptopStore laptopStore = LaptopStoreProvider.getLaptopStore(producer);

            // then
            assertThat(laptopStore)
                    .isNotNull()
                    .isInstanceOf(classOfStore);
        }

        private static Stream<Arguments> provideParametersLaptopStores() {
            return Stream.of(
                    Arguments.of(DELL, DellLaptopStore.class),
                    Arguments.of(LENOVO, LenovoLaptopStore.class),
                    Arguments.of(SAMSUNG, SamsungLaptopStore.class)
            );
        }
    }

    @Nested
    @DisplayName("Tests of ComponentFactoryProvider")
    class ComponentFactoryProviderTest {

        @ParameterizedTest(name = "{index}: QualityLevel: {0} ")
        @EnumSource(value = QualityLevel.class)
        @DisplayName("ComponentFactoryProvider returns abstract ComponentFactory for all enum types")
        void should_provide_proper_component_factory_based_on_given_quality_level(QualityLevel qualityLevel) {
            // given
            // when
            LaptopComponentFactory componentFactory = ComponentFactoryProvider.getComponentFactory(qualityLevel);

            // then
            assertThat(componentFactory)
                    .isNotNull()
                    .isInstanceOf(LaptopComponentFactory.class);
        }

        @Test
        void should_throw_npe_when_given_null_as_get_component_factory_provider_argument() {
            // given
            // when
            // then
            assertThrows(
                    NullPointerException.class,
                    () -> ComponentFactoryProvider.getComponentFactory(null)
            );
        }

        @ParameterizedTest
        @MethodSource("provideParametersComponentFactory")
        void should_return_concrete_implementations_of_component_factory(QualityLevel quality, Class<LaptopStore> classOfComponentFactory) {
            // given
            // when
            LaptopComponentFactory componentFactory = ComponentFactoryProvider.getComponentFactory(quality);

            // then
            assertThat(componentFactory)
                    .isNotNull()
                    .isInstanceOf(classOfComponentFactory);
        }

        private static Stream<Arguments> provideParametersComponentFactory() {
            return Stream.of(
                    Arguments.of(LOW, LaptopLowComponentFactory.class),
                    Arguments.of(MEDIUM, LaptopMediumComponentFactory.class),
                    Arguments.of(HIGH, LaptopHighComponentFactory.class)
            );
        }
    }

    @Nested
    @DisplayName("Tests of all implementations of LaptopStore")
    class LaptopStoreTest {

        @ParameterizedTest
        @MethodSource("provideStoreWithCorrespondingLaptop")
        void should_return_concrete_laptops_for_concrete_laptop_stores(LaptopStore store, Class<Laptop> laptopClass) {
            // given
            // when
            Laptop concreteLaptop = store.orderLaptop(LOW);

            // then
            assertThat(concreteLaptop)
                    .isNotNull()
                    .isInstanceOf(laptopClass);
        }

        private static Stream<Arguments> provideStoreWithCorrespondingLaptop() {
            return Stream.of(
                    Arguments.of(new DellLaptopStore(), DellLaptop.class),
                    Arguments.of(new LenovoLaptopStore(), LenovoLaptop.class),
                    Arguments.of(new SamsungLaptopStore(), SamsungLaptop.class)
            );
        }
    }

    @Nested
    @DisplayName("Tests of all implementations of ComponentFactories products")
    class LaptopComponentFactoryTest {

        @Test
        void should_return_low_component_family_for_low_component_factory() {
            // given
            LaptopComponentFactory lowFactory = ComponentFactoryProvider.getComponentFactory(LOW);

            // when
            GraphicCard graphicCard = lowFactory.createGraphicCard();
            Processor processor = lowFactory.createProcessor();
            Motherboard motherBoard = lowFactory.createMotherBoard();

            // then
            assertThat(graphicCard).isInstanceOf(WeakGraphicCard.class);
            assertThat(processor).isInstanceOf(WeakProcessor.class);
            assertThat(motherBoard).isInstanceOf(WeakMotherboard.class);
        }

        @Test
        void should_return_medium_component_for_family_medium_component_factory() {
            // given
            LaptopComponentFactory lowFactory = ComponentFactoryProvider.getComponentFactory(MEDIUM);

            // when
            GraphicCard graphicCard = lowFactory.createGraphicCard();
            Processor processor = lowFactory.createProcessor();
            Motherboard motherBoard = lowFactory.createMotherBoard();

            // then
            assertThat(graphicCard).isInstanceOf(RegularGraphicCard.class);
            assertThat(processor).isInstanceOf(RegularProcessor.class);
            assertThat(motherBoard).isInstanceOf(RegularMotherboard.class);
        }

        @Test
        void should_return_powerful_component_family_for_high_component_factory() {
            // given
            LaptopComponentFactory lowFactory = ComponentFactoryProvider.getComponentFactory(HIGH);

            // when
            GraphicCard graphicCard = lowFactory.createGraphicCard();
            Processor processor = lowFactory.createProcessor();
            Motherboard motherBoard = lowFactory.createMotherBoard();

            // then
            assertThat(graphicCard).isInstanceOf(PowerfulGraphicCard.class);
            assertThat(processor).isInstanceOf(PowerfulProcessor.class);
            assertThat(motherBoard).isInstanceOf(PowerfulMotherboard.class);
        }
    }
}
