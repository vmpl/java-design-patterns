package pl.vm.javaguild.designpatterns.pattern.structural.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.Engine;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.OrderVehicleCommand;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.Vehicle;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.engine.BoxerEngine;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.engine.CylinderConfiguration;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.engine.EngineFactory;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.vehicle.Manufacturer;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.vehicle.Porsza911;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.vehicle.VehicleFactory;
import pl.vm.javaguild.designpatterns.pattern.structural.bridge.service.CarDealership;

import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Nested
    @DisplayName("Testing of 'CarDealership'")
    class CarDealershipTest {

        private final CarDealership carDealership = new CarDealership(
                new VehicleFactory(
                        new EngineFactory()
                ),
                new EngineFactory()
        );

        @Test
        void should_return_vehicle_with_existing_engine_and_existing_manufacturer() {
            // given
            OrderVehicleCommand command = OrderVehicleCommand.builder()
                    .manufacturer(Manufacturer.PORSZA)
                    .horsepower(300)
                    .torque(280)
                    .cylinderConfiguration(CylinderConfiguration.FLAT)
                    .build();

            // when
            Vehicle vehicle = carDealership.orderBy(command);

            // then
            assertThat(vehicle).isExactlyInstanceOf(Porsza911.class);
            assertThat(vehicle.getManufacturer()).isEqualTo(Manufacturer.PORSZA);
            assertThat(vehicle.getPrice()).isEqualTo(BigDecimal.valueOf(1680));
            assertThat(vehicle.getEngine()).satisfies(engine -> {
                assertThat(engine.getHorsepower()).isEqualTo(300);
                assertThat(engine.getTorque()).isEqualTo(280);
                assertThat(engine.getCylinderConfiguration()).isEqualTo(CylinderConfiguration.FLAT);
                assertThat(engine).isExactlyInstanceOf(BoxerEngine.class);
            });
        }

        @Test
        void should_return_vehicle_with_custom_engine_and_existing_manufacturer() {
            // given
            OrderVehicleCommand command = OrderVehicleCommand.builder()
                    .manufacturer(Manufacturer.PORSZA)
                    .horsepower(500)
                    .torque(340)
                    .cylinderConfiguration(CylinderConfiguration.V_SHAPED)
                    .build();

            // when
            Vehicle vehicle = carDealership.orderBy(command);

            // then
            assertTrue(vehicle.getClass().isAnonymousClass());
            assertThat(vehicle.getManufacturer()).isEqualTo(Manufacturer.PORSZA);
            assertThat(vehicle.getPrice()).isEqualTo(BigDecimal.valueOf(3400));
            assertThat(vehicle.getEngine()).satisfies(engine -> {
                assertThat(engine.getHorsepower()).isEqualTo(500);
                assertThat(engine.getTorque()).isEqualTo(340);
                assertThat(engine.getCylinderConfiguration()).isEqualTo(CylinderConfiguration.V_SHAPED);
                assertTrue(engine.getClass().isAnonymousClass());
            });
        }
    }
}
