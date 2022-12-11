package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod;

import lombok.extern.slf4j.Slf4j;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Department;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Seniority;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Stack;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.ItDepartment;

/**
 * Demo class. Example of factory-method pattern working.
 */

@Slf4j
public class Main {

    public static void main(String[] args) {

        // The company has to hire Senior Full-Stack dev
        Department department = new ItDepartment(Seniority.SENIOR, Stack.FULL_STACK);
        log.info(department.work());


    }
}