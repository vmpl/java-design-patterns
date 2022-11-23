package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee;

/**
 * FinanceDepartmentEmployee implementation
 */
public class FinanceDepartmentEmployee implements Employee {

    @Override
    public void doJob() {
        System.out.println("Work: I am counting money!");
    }

    @Override
    public void takeBreak() {
        System.out.println("Break: I go for a coffee and back to work!");
    }


}
