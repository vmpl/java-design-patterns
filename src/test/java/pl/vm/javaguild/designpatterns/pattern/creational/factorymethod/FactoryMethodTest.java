package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod;

import org.junit.jupiter.api.Test;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.model.Department;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.model.Enums.Section;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.model.Enums.Seniority;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.model.Enums.TechStack;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.model.FinancialDepartment;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.model.ItDepartment;
import pl.vm.javaguild.designpatterns.pattern.creational.factorymethod.model.Interfaces.Employee;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryMethodTest {

    @Test
    void createJuniorBackendDeveloper() {

        Department department = new ItDepartment(Seniority.JUNIOR, TechStack.BACKEND);
        Employee juniorBackendDev = department.createEmployee();

        assertThat(juniorBackendDev.toString()).isEqualTo("Developer{seniority = JUNIOR, techStack = BACKEND}");
    }

    @Test
    void createSeniorAccountant() {

        Department department = new FinancialDepartment(Seniority.SENIOR, Section.ACCOUNTANT);
        Employee seniorFinancialAccountant = department.createEmployee();

        assertThat(seniorFinancialAccountant.toString()).isEqualTo("FinanceDepartmentEmployee{seniority = SENIOR, section = ACCOUNTANT}");

    }

    @Test
    void developerWorks() {

        Department department = new ItDepartment(Seniority.SENIOR, TechStack.FRONTEND);
        assertThat(department.work()).isEqualTo("Developer{seniority = SENIOR, techStack = FRONTEND} I have no idea what I'm doing!");
    }

    @Test
    void developerRest() {
        Department department = new ItDepartment(Seniority.REGULAR, TechStack.TEST_ENGINEER);
        assertThat(department.rest()).isEqualTo("Developer{seniority = REGULAR, techStack = TEST_ENGINEER} Let's play table football!");
    }

    @Test
    void financialDepartmentEmployeeWorks() {
        Department department = new FinancialDepartment(Seniority.REGULAR, Section.CREDIT_RISK_ANALYST);
        assertThat(department.work()).isEqualTo("FinanceDepartmentEmployee{seniority = REGULAR, section = CREDIT_RISK_ANALYST} I am counting money!");
    }

    @Test
    void financialDepartmentEmployeeRest() {
        Department department = new FinancialDepartment(Seniority.TEAM_LEADER, Section.PRICING_SPECIALIST);
        assertThat(department.rest()).isEqualTo("FinanceDepartmentEmployee{seniority = TEAM_LEADER, section = PRICING_SPECIALIST} I am going for a coffee and back to work!");

    }
}
