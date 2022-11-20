package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod;

public class FinanceDepartmentEmployee implements Employee {

    @Override
    public void doJob() {
        System.out.println("I am counting money!");
    }

    @Override
    public void takeBreak() {
        System.out.println("I go for a coffee and back to work!");
    }
}
