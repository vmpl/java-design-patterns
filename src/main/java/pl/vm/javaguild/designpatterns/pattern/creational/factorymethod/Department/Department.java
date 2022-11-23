package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department;

import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Employee;

/**
 * The fundamental factory class.
 */

public abstract class Department {

    /**
     * Subclasses will override this method in order to create specific Employee
     * objects.
     */
    public abstract Employee createEmployee();

}
