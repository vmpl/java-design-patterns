package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.ComfortDriving;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.EconomicDriving;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.ForbiddenDriving;

@Slf4j
@SuperBuilder
public class Truck extends Vehicle {

	public void drive(DriveMode driveMode){
		switch(driveMode){
			case ECO -> context.setStrategy(new EconomicDriving());
			case COMFORT -> context.setStrategy(new ComfortDriving());
			case SPORT -> context.setStrategy(new ForbiddenDriving());
		}

		context.executeStrategy();
	};

	public String engineInfo() {
		return getEngine() + " truck ";
	}
}