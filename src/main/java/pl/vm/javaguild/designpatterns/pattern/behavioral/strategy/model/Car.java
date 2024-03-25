package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model;

import lombok.experimental.SuperBuilder;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.AggressiveDriving;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.ComfortDriving;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.EconomicDriving;

@SuperBuilder
public class Car extends Vehicle {
	public void drive(DriveMode driveMode){
		switch(driveMode){
			case ECO -> context.setStrategy(new EconomicDriving());
			case COMFORT -> context.setStrategy(new ComfortDriving());
			case SPORT -> context.setStrategy(new AggressiveDriving());
		}

		context.executeStrategy();
	};

	public String engineInfo() {
		return getEngine() + " car ";
	}
}