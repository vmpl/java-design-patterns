package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department;

import lombok.RequiredArgsConstructor;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Employee;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Section;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Seniority;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.FinanceDepartmentEmployee;

/**
 * FinancialDepartment will produce financial department employees
 */
@RequiredArgsConstructor
public class FinancialDepartment extends Department {

    private Seniority seniority;
    private Section section;

    public FinancialDepartment(Seniority seniority, Section section) {
        this.seniority = seniority;
        this.section = section;
    }

    @Override
    public Employee createEmployee() {
        return new FinanceDepartmentEmployee(seniority, section);
    }

}
