package pl.vm.javaguild.designpatterns.pattern.creational.factorymethod;

public abstract class Department {

    public abstract Employee createEmployee();

    public static Long id = 0L;

    void giveRise(Long id, int raise) {

    }

    void givePromotion(Long id, String position) {

    }

    void fire(Long id) {

    }

}
