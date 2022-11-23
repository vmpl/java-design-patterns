package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department;

import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Developer;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Employee;

/**
 * ItDepartment will produce developers
 */
public class ItDepartment extends Department {

    @Override
    public Employee createEmployee() {
        return new Developer();
    }

}
