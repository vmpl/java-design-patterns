package pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.adapter;

import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.GiftFactory;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.BleuDeChannel;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.DjiMavic3;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.Gift;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.GiftType;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.MillenniumFalcon;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.RobomowRt700;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.WalkingPadC1;
import pl.vm.javaguild.designpatterns.pattern.creational.simplefactory.model.XboxOneX;

import java.util.Optional;

public record GiftFactoryAdapter() implements GiftFactory {

    @Override
    public Optional<Gift> create(GiftType giftType) {
        Gift gift = switch (giftType) {
            case CONSOLE -> new XboxOneX();
            case DRONE -> new DjiMavic3();
            case FRAGRANCE -> new BleuDeChannel();
            case LEGO -> new MillenniumFalcon();
            case HOUSEHOLD_TOOLS -> new RobomowRt700();
            case SPORT_ACCESSORIES -> new WalkingPadC1();
            default -> null;
        };

        return Optional.ofNullable(gift);
    }
}
