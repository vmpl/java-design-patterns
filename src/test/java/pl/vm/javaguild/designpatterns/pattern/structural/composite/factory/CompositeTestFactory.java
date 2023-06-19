package pl.vm.javaguild.designpatterns.pattern.structural.composite.factory;

import lombok.Getter;
import pl.vm.javaguild.designpatterns.pattern.structural.composite.model.gem.GemTestFactory;

@Getter
public class CompositeTestFactory {

    private final GemTestFactory gemTestFactory = new GemTestFactory();
}
