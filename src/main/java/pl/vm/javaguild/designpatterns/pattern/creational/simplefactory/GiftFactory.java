package pl.vm.javaguild.designpatterns.pattern.creational.simplefactory;

import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.Gift;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.GiftType;

/**
 * Base factory definition for creating different types of {@link Gift}
 */
@FunctionalInterface
public interface GiftFactory {

    /**
     * Creates {@link Gift} based given {@link GiftType}
     *
     * @param giftType as a determiner of specific type
     * @return created gift
     */
    Gift create(GiftType giftType);
}
