package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department;

import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Employee;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.FinanceDepartmentEmployee;

/**
 *  FinancialDepartment will produce financial department employees
 */

public class FinancialDepartment extends Department {

    @Override
    public Employee createEmployee() {
        System.out.println("Created new Financial department employee");
        return new FinanceDepartmentEmployee();
    }
}
