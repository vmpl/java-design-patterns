package pl.vm.javaguild.designpatterns.pattern.structural.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.Engine;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.Vehicle;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.engine.CylinderConfiguration;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.engine.EngineFactory;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.vehicle.Manufacturer;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.vehicle.VehicleFactory;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Structural pattern: Bridge - Test")
public class BridgeTest {

    @Nested
    @DisplayName("Testing of 'Engine'")
    class EngineTest {

        private final EngineFactory engineFactory = new EngineFactory();

        @ParameterizedTest
        @EnumSource(CylinderConfiguration.class)
        void should_find_engine_by_existing_cylinder_configuration(CylinderConfiguration cylinderConfiguration) {
            // given && when
            Optional<Engine> engine = engineFactory.findBy(cylinderConfiguration);

            // then
            assertThat(engine).isPresent();
        }

        @Test
        void should_not_find_engine_by_not_existing_cylinder_configuration() {
            // given
            CylinderConfiguration notExistingCylinderConfiguration = null;

            // when
            Optional<Engine> engine = engineFactory.findBy(notExistingCylinderConfiguration);

            // then
            assertThat(engine).isNotPresent();
        }
    }

    @Nested
    @DisplayName("Testing of 'Vehicle'")
    class VehicleTest {

        private final VehicleFactory vehicleFactory = new VehicleFactory(
                new EngineFactory()
        );

        @ParameterizedTest
        @EnumSource(Manufacturer.class)
        void should_find_vehicle_by_existing_manufacturer(Manufacturer manufacturer) {
            // given && when
            Optional<Vehicle> vehicle = vehicleFactory.findBy(manufacturer);

            // then
            assertThat(vehicle).isPresent();
        }

        @Test
        void should_not_find_vehicle_by_existing_manufacturer() {
            // given
            Manufacturer notExistingManufacturer = null;

            // when
            Optional<Vehicle> vehicle = vehicleFactory.findBy(notExistingManufacturer);

            // then
            assertThat(vehicle).isNotPresent();
        }
    }
}
