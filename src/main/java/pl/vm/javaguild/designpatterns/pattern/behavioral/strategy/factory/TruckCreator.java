package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.factory;

import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Context;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Truck;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model.Vehicle;

class TruckCreator implements VehicleCreator {
	public Vehicle buildVehicle() {
		Vehicle vehicle = Truck.builder().seats(3).wheels(6).engine("24.0L V12 diesel").build();
		vehicle.setContext(new Context(vehicle));
		return vehicle;
	}
}