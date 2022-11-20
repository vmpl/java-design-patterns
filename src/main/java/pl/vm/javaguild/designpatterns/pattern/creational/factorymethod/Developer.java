package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod;

public class Developer implements Employee {

    protected String project;


    @Override
    public void doJob() {
        System.out.println("I have no idea what I'm doing!");
    }

    @Override
    public void takeBreak() {
        System.out.println("Let's play table football!");
    }

    Developer() {
        this.project = "Bench";
    }
}
