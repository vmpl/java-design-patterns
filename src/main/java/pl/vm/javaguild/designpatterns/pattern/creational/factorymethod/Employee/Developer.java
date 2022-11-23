package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee;

/**
 * Developer implementation
 */
public class Developer implements Employee {

    protected String project;

    public Developer() {
        this.project = "Bench";
        System.out.println("Created new developer!");
    }

    @Override
    public void doJob() {
        System.out.println("Work: I have no idea what I'm doing!");
    }

    @Override
    public void takeBreak() {
        System.out.println("Break: Let's play table football!");
    }


}
