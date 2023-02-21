package pl.vm.javaguild.designpatterns.pattern.creational.prototype.adapter;

import lombok.RequiredArgsConstructor;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.FreeAgentMarket;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.model.Coach;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.model.Player;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.model.Team;

@RequiredArgsConstructor
public class FreeAgentMarketAdapter implements FreeAgentMarket {

    private final Player basePlayer;
    private final Coach baseCoach;
    private final Team baseTeam;

    @Override
    public Player cratePlayer() {
        return basePlayer.copy();
    }

    @Override
    public Player cratePlayer(String name) {
        Player player = basePlayer.copy();
        player.setName(name);
        return player;
    }

    @Override
    public Coach createCoach() {
        return baseCoach.copy();
    }

    @Override
    public Coach createCoach(String name) {
        Coach coach = baseCoach.copy();
        coach.setName(name);
        return coach;
    }

    @Override
    public Team createTeam() {
        return baseTeam.copy();
    }

    @Override
    public Team createTeam(String name) {
        Team team = baseTeam.copy();
        team.setName(name);
        return team;
    }
}
