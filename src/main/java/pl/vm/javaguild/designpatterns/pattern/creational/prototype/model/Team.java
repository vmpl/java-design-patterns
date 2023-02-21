package pl.vm.javaguild.designpatterns.pattern.creational.prototype.model;

import org.slf4j.Logger;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.Prototype;

import java.util.List;

public class Team extends Prototype<Team> {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Team.class);
    private final Coach coach;
    private final List<Player> players;
    private String name;

    public Team(Team team) {
        this.name = team.getName();
        this.coach = team.getCoach().copy();
        this.players = team.getPlayers().stream().map(Player::copy).toList();
    }

    public Team(Coach coach, List<Player> players, String name) {
        this.coach = coach;
        this.players = players;
        this.name = name;
    }

    @Override
    public Team copy() {
        return new Team(this);
    }

    void showInfo() {
        log.info(
                """
                                                
                        --- Team info ---
                        Name:              {}
                        Coach              {}
                        Number of players: {}
                        """,
                name,
                coach.getName(),
                players.size()
        );
    }

    public Coach getCoach() {
        return this.coach;
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
