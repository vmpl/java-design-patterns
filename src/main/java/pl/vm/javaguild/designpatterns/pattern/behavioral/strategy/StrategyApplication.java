package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy;

import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.factory.VehicleFactory;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.DriveMode;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Vehicle;

public class StrategyApplication {

	public static void main(String[] args) {
		Vehicle truck = VehicleFactory.getVehicle("truck");
		truck.drive(DriveMode.COMFORT);

		Vehicle car = VehicleFactory.getVehicle("car");
		car.drive(DriveMode.SPORT);

		Vehicle bus = VehicleFactory.getVehicle("bus");
		bus.getContext().setNumberOfpassengers(40);
		bus.drive(DriveMode.SPORT);

        bus.getContext().setNumberOfpassengers(1);
        bus.drive(DriveMode.SPORT);
	}
}