package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.VehicleBehavior;

@SuperBuilder
@Getter
public abstract class Vehicle {
	private int wheels;
	private int seats;
	private String engine;
	public Context context;

	public abstract void drive (DriveMode driveMode);
	public abstract String engineInfo ();

	public void setContext(Context context){
		this.context = context;
	}
}