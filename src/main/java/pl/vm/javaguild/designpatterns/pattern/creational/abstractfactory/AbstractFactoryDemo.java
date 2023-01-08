package pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory;

import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore.LaptopStore;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.factorycreator.LaptopStoreCreator;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.Producer;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.QualityLevel;

public class AbstractFactoryDemo {

    public static void main(String[] args) {

        // client wants to order Dell laptop of the highest quality
        LaptopStore dellLaptopStore = LaptopStoreCreator.getLaptopStore(Producer.DELL);

        dellLaptopStore.orderLaptop(QualityLevel.HIGH);
    }
}