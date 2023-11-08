package pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.engine;

import pl.vm.javaguild.designpatterns.pattern.structural.bridge.model.Engine;

import java.util.List;
import java.util.Optional;

public class EngineFactory {

    private final List<Engine> engines = List.of(
            new BoxerEngine(300, 280),
            new StraightTwinEngine(50, 40),
            new V12Engine(850, 1100)
    );

    public Engine getBy(CylinderConfiguration cylinderConfiguration) {
        return findBy(cylinderConfiguration)
                .orElseThrow();
    }

    public Optional<Engine> findBy(CylinderConfiguration cylinderConfiguration) {
        return engines.stream()
                .filter(engine -> engine.getCylinderConfiguration() == cylinderConfiguration)
                .findFirst();
    }
}
