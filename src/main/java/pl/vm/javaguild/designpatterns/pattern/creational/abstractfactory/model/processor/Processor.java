package pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.processor;

import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.Laptop;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.enums.QualityLevel;

/**
 * Interface Processor is a component that Laptop consists of
 * @see Laptop
 */
public interface Processor {

    QualityLevel getQualityLevel();
    String getName();
    String getDescription();
}