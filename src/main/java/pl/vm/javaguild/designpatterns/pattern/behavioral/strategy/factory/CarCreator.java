package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.factory;

import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Car;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Context;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Vehicle;

class CarCreator implements VehicleCreator {
	public Vehicle buildVehicle() {

		Vehicle vehicle = Car.builder().seats(5).wheels(4).engine("2.0L R4 petrol").build();
		vehicle.setContext(new Context(vehicle));
		return vehicle;
	}
}
