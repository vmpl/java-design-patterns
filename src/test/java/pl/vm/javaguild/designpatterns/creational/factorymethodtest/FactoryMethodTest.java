package pl.vm.javaguild.designpatterns.creational.factorymethodtest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Department;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Section;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Seniority;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.Enums.Stack;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.FinancialDepartment;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Department.ItDepartment;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.Employee.Employee;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class FactoryMethodTest {

    @Test
    void createJuniorBackendDeveloper() {

        Department department = new ItDepartment(Seniority.JUNIOR, Stack.BACKEND);
        Employee juniorBackendDev = department.createEmployee();

        assertThat(juniorBackendDev.toString()).isEqualTo("Developer{seniority=JUNIOR, stack=BACKEND}");
    }

    @Test
    void createSeniorAccountant() {

        Department department = new FinancialDepartment(Seniority.SENIOR, Section.ACCOUNTANT);
        Employee seniorFinancialAccountant = department.createEmployee();

        assertThat(seniorFinancialAccountant.toString()).isEqualTo("FinanceDepartmentEmployee{seniority=SENIOR, section=ACCOUNTANT}");

    }

    @Test
    void developerWorks() {

        Department department = new ItDepartment(Seniority.SENIOR, Stack.FRONTEND);
        assertThat(department.work()).isEqualTo("Developer{seniority=SENIOR, stack=FRONTEND} I have no idea what I'm doing!");
    }

    @Test
    void developerRest() {
        Department department = new ItDepartment(Seniority.REGULAR, Stack.TEST_ENGINEER);
        assertThat(department.rest()).isEqualTo("Developer{seniority=REGULAR, stack=TEST_ENGINEER} Let's play table football!");
    }

    @Test
    void financialDepartmentEmployeeWorks() {
        Department department = new FinancialDepartment(Seniority.REGULAR, Section.CREDIT_RISK_ANALYST);
        assertThat(department.work()).isEqualTo("FinanceDepartmentEmployee{seniority=REGULAR, section=CREDIT_RISK_ANALYST} I am counting money!");
    }

    @Test
    void financialDepartmentEmployeeRest() {
        Department department = new FinancialDepartment(Seniority.TEAM_LEADER, Section.PRICING_SPECIALIST);
        assertThat(department.rest()).isEqualTo("FinanceDepartmentEmployee{seniority=TEAM_LEADER, section=PRICING_SPECIALIST} I am going for a coffee and back to work!");

    }
}
