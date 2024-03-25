package pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.model;

import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.AggressiveDriving;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.EconomicDriving;
import pl.vm.javaguild.designpatterns.pattern.behavioral.strategy.ForbiddenDriving;

@Slf4j
@SuperBuilder
public class Bus extends Vehicle {

	public void drive(DriveMode driveMode){
		switch(driveMode){
			case ECO -> context.setStrategy(new AggressiveDriving());
			case COMFORT -> context.setStrategy(new EconomicDriving());
			case SPORT -> {
				if (context.getNumberOfpassengers() > 1) {
					context.setStrategy(new ForbiddenDriving());
				} else {
					context.setStrategy(new AggressiveDriving());
				}
			}
		}

		context.executeStrategy();
	};

	public String engineInfo() {
		return getEngine() + " bus ";
	}
}