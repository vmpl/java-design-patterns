package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model;

import lombok.Getter;
import lombok.Setter;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.VehicleBehavior;

@Setter
@Getter
public class Context {

	private int numberOfpassengers;
	private VehicleBehavior strategy;
	private Vehicle vehicle;

	public Context(Vehicle vehicle){
		this.vehicle = vehicle;
	}
	public void executeStrategy(){
		System.out.print(vehicle.engineInfo());
		strategy.perform(vehicle);
	}

}
