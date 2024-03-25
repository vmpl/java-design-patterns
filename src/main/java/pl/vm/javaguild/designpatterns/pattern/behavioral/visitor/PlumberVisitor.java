package pl.vm.javaguild.designpatterns.pattern.behavioral.visitor;

import lombok.extern.slf4j.Slf4j;
import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.Bathroom;
import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.House;
import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.Kitchen;
import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.LivingRoom;

@Slf4j
public class PlumberVisitor implements BuildingPartVisitor {

	@Override
	public void visit(Kitchen kitchen) {
		log.info("Checking for any plumbing issues in the kitchen, such as leaks or clogged drains.");
	}

	@Override
	public void visit(LivingRoom livingRoom) {
		log.info("Inspecting heating systems and any water pipes running through the living room.");
	}

	@Override
	public void visit(Bathroom bathroom) {
		log.info("Inspecting bathroom plumbing, including toilets, showers, and sinks for any issues.");
	}

	@Override
	public void visit(House house) {
		log.info("Checking the house's overall water supply and sewage systems.");
	}
}