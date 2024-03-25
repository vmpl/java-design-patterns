package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.factory;

import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Bus;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Context;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Vehicle;

public class BusCreator implements VehicleCreator {
	public Vehicle buildVehicle() {
		Vehicle vehicle = Bus.builder().seats(50).wheels(6).engine("6.0L V6 diesel").build();
		vehicle.setContext(new Context(vehicle));
		return vehicle;
	}
}
