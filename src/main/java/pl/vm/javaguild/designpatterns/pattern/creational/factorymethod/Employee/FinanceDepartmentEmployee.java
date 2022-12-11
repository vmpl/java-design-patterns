package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee;

import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Section;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Seniority;

/**
 * FinanceDepartmentEmployee implementation
 */

public class FinanceDepartmentEmployee implements Employee {

    private Seniority seniority;
    private Section section;

    private final String financeEmployeeWork = "I am counting money!";
    private final String financeEmployeeBreak = "I am going for a coffee and back to work!";


    public FinanceDepartmentEmployee(Seniority seniority, Section section) {
        this.seniority = seniority;
        this.section = section;
    }

    @Override
    public String doJob() {

        return this.toString() +" " + financeEmployeeWork;
    }

    @Override
    public String takeBreak() {

        return this.toString() +" " + financeEmployeeBreak;
    }

    @Override
    public String toString() {
        return "FinanceDepartmentEmployee{" +
                "seniority=" + seniority +
                ", section=" + section +
                '}';
    }
}
