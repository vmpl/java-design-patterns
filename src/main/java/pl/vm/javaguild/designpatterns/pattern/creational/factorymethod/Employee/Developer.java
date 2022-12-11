package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee;

import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Seniority;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Stack;

/**
 * Developer implementation
 */

public class Developer implements Employee {

    private Seniority seniority;
    private Stack stack;

    private final String devWork = "I have no idea what I'm doing!";
    private final String devBreak = "Let's play table football!";

    public Developer(Seniority seniority, Stack stack) {

        this.seniority = seniority;
        this.stack = stack;

    }

    @Override
    public String doJob() {
        return this.toString() + " " + devWork;
    }

    @Override
    public String takeBreak() {
        return this.toString() + " " + devBreak;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "seniority=" + seniority +
                ", stack=" + stack +
                '}';
    }
}
