package pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.factory.laptopstore;

import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.laptop.Laptop;
import pl.vm.javaguild.designpatterns.pattern.creational.abstractfactory.model.enums.QualityLevel;

/**
 * Class representing Factory Class, simulates ordering laptop of different quality
 */
public abstract class LaptopStore {

    /**
     * Subclasses will override this method in order to create specific Laptop objects
     * example of factory method
     * @return Laptop
     */
    protected abstract Laptop createLaptop(QualityLevel qualityLevel);

    public Laptop orderLaptop(QualityLevel qualityLevel) {
        Laptop laptop = createLaptop(qualityLevel); // Usage of Template pattern
        laptop.mountComponents();
        laptop.box();
        laptop.deliver();

        return laptop;
    }
}