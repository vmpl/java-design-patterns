package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod;

import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Department;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.FinancialDepartment;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.ItDepartment;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Employee;

/**
 * Demo class. Example of factory-method pattern working.
 */

public class DemoApp {

    private static Department department;

    public void runDemoApp() {

        int n = 3;

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ". iteration");
            initDepartments(i);
            runLogic();
            System.out.println();
        }
    }

    /**
     * The accurate department is created
     * @param n number to differentiate employee to create
     */

    private static void initDepartments(int n) {

        if (n % 2 == 0) {
            department = new ItDepartment();
        } else {
            department = new FinancialDepartment();
        }

    }

    /**
     * Method with business logic.
     * The client doesn't care which factory is in use.
     */

    private static void runLogic() {

        Employee employee = department.createEmployee();

        employee.doJob();
        employee.takeBreak();
    }
}
