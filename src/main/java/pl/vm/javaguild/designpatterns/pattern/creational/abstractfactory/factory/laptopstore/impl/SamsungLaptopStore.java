package pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore.impl;

import lombok.extern.slf4j.Slf4j;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.componentfactory.LaptopComponentFactory;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore.LaptopStore;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.Laptop;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.enums.QualityLevel;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.SamsungLaptop;

import static pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.factorycreators.ComponentFactoryCreator.getComponentFactory;

@Slf4j
public class SamsungLaptopStore extends LaptopStore {

    @Override
    protected Laptop createLaptop(QualityLevel qualityLevel) {
        log.info("Building laptop in SamsungLaptopStore of " + qualityLevel + " quality.");
        LaptopComponentFactory componentFactory = getComponentFactory(qualityLevel);
        return new SamsungLaptop(componentFactory);
    }
}