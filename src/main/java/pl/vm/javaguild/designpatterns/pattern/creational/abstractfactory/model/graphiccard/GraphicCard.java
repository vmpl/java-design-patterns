package pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.graphiccard;

import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.Laptop;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.enums.QualityLevel;

/**
 * Interface GraphicCard is a component that Laptop consists of
 *
 * @author Wojciech Dudziak
 * @since 06-12-2022
 * @see Laptop
 */
public interface GraphicCard {

    QualityLevel getQualityLevel();
    String getName();
    String getDescription();
}
