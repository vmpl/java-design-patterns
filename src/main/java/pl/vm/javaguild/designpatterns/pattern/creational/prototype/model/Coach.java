package pl.vm.javaguild.designpatterns.pattern.creational.prototype.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Coach extends Person<Coach> {

    private final CoachingStrategy coachingStrategy;

    public Coach(String name, CoachingStrategy coachingStrategy) {
        super(name);
        this.coachingStrategy = coachingStrategy;
    }

    public Coach(Coach coach) {
        super(coach.name);
        this.coachingStrategy = coach.coachingStrategy;
    }

    @Override
    void showInfo() {
        log.info(
                """
                        --- Coach info ---
                        Name:     {}
                        Strategy: {}
                        """,
                name,
                coachingStrategy
        );
    }
}
