package pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop;

import lombok.extern.slf4j.Slf4j;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.componentfactory.LaptopComponentFactory;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.enums.Producer;

@Slf4j
public class SamsungLaptop extends Laptop {

    public SamsungLaptop(LaptopComponentFactory componentFactory) {
        this.producer = Producer.SAMSUNG;
        this.motherboard = componentFactory.createMotherBoard();
        this.graphicCard = componentFactory.createGraphicCard();
        this.processor = componentFactory.createProcessor();
        this.modelName = processor.getQualityLevel().toString() + " Samsung laptop model";
    }
}