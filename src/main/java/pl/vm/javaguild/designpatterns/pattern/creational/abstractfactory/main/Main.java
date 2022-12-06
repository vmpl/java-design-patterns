package pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.main;

import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore.LaptopStore;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.factorycreators.LaptopStoreCreator;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.enums.Producer;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.enums.QualityLevel;

public class Main {

    public static void main(String[] args) {

        // client wants to order Dell laptop of the highest quality
        LaptopStore dellLaptopStore = LaptopStoreCreator.getLaptopStore(Producer.DELL);

        dellLaptopStore.orderLaptop(QualityLevel.HIGH);
    }
}