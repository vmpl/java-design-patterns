package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod;

public class ItDepartment extends Department{

    @Override
    public Employee createEmployee() {
        return new Developer();
    }

}
