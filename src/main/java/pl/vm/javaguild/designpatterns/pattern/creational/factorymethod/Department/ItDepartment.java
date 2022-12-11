package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department;

import lombok.RequiredArgsConstructor;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Developer;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Employee;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Seniority;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Stack;

/**
 * ItDepartment will produce developers
 */
@RequiredArgsConstructor
public class ItDepartment extends Department {

    private Seniority seniority;
    private Stack stack;

    public ItDepartment(Seniority seniority, Stack stack){

        this.seniority = seniority;
        this.stack = stack;
    }
    @Override
    public Employee createEmployee() {
        return new Developer(seniority, stack);
    }

}
