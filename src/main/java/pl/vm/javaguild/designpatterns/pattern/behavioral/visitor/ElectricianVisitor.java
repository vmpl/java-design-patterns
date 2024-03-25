package pl.vm.javaguild.designpatterns.pattern.behavioral.visitor;

import lombok.extern.slf4j.Slf4j;
import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.Bathroom;
import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.House;
import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.Kitchen;
import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.LivingRoom;

@Slf4j
public class ElectricianVisitor implements BuildingPartVisitor {

	@Override
	public void visit(Kitchen kitchen) {
		log.info("Inspecting electrical appliances, outlets, and wiring in the kitchen for safety.");
	}

	@Override
	public void visit(LivingRoom livingRoom) {
		log.info("Checking the living room for proper electrical wiring, outlets, and light fixtures.");
	}

	@Override
	public void visit(Bathroom bathroom) {
		log.info("Ensuring that all bathroom electrical fixtures are safe and comply with regulations.");
	}

	@Override
	public void visit(House house) {
		log.info("Performing a comprehensive safety inspection of the house's electrical system.");
	}
}