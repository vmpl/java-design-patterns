package pl.vm.javaguild.designpatterns.pattern.behavioral.visitor;

import pl.vm.javaguild.designpatterns.pattern.behavioral.visitor.model.House;

public class VisitorApplication {

    public static void main(String[] args) {
        House house = new House();

        BuildingInspector inspector = new BuildingInspector();
        house.accept(inspector);

        ElectricianVisitor electrician = new ElectricianVisitor();
        house.accept(electrician);

        PlumberVisitor plumber = new PlumberVisitor();
        house.accept(plumber);

    }
}