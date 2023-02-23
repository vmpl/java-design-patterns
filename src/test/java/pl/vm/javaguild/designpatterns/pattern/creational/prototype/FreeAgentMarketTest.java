package pl.vm.javaguild.designpatterns.pattern.creational.prototype;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.adapter.FreeAgentMarketAdapter;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.model.Coach;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.model.CoachingStrategy;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.model.Player;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.model.SportDiscipline;
import pl.vm.javaguild.designpatterns.pattern.creational.prototype.model.Team;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.setAllowComparingPrivateFields;

@DisplayName("Creational pattern: Prototype functionality Test")
class FreeAgentMarketTest {

    private final Player baseFirstPlayer = new Player("Michael Jordan", SportDiscipline.BASKETBALL);
    private final Player baseSecondPlayer = new Player("Dennis Rodman", SportDiscipline.BASKETBALL);
    private final Coach baseCoach = new Coach("Phil Jackson", CoachingStrategy.TRIANGLE);
    private final Team baseTeam = new Team(baseCoach, List.of(baseFirstPlayer, baseSecondPlayer), "Chicago Bulls");

    @Test
    void should_create_player() {
        // given
        FreeAgentMarket freeAgentMarket = new FreeAgentMarketAdapter(baseFirstPlayer, baseCoach, baseTeam);

        // when
        Player player = freeAgentMarket.createPlayer();

        // then
        assertThat(player.getName()).isEqualTo(baseFirstPlayer.getName());
        assertThat(player.getSportDiscipline()).isEqualTo(baseFirstPlayer.getSportDiscipline());
        assertThat(player).isNotEqualTo(baseFirstPlayer);
    }

    @Test
    void should_create_player_with_name() {
        // given
        FreeAgentMarket freeAgentMarket = new FreeAgentMarketAdapter(baseSecondPlayer, baseCoach, baseTeam);
        String newPlayerName = "Scottie Pippen";

        // when
        Player player = freeAgentMarket.createPlayer(newPlayerName);

        // then
        assertThat(player.getName()).satisfies(name -> {
            assertThat(name).isEqualTo(newPlayerName);
            assertThat(name).isNotEqualTo(baseFirstPlayer.getName());
        });
        assertThat(player.getSportDiscipline()).isEqualTo(baseSecondPlayer.getSportDiscipline());
        assertThat(player).isNotEqualTo(baseSecondPlayer);
    }

    @Test
    void should_create_coach() {
        // given
        FreeAgentMarket freeAgentMarket = new FreeAgentMarketAdapter(baseFirstPlayer, baseCoach, baseTeam);

        // when
        Coach coach = freeAgentMarket.createCoach();

        // then
        assertThat(coach.getName()).isEqualTo(baseCoach.getName());
        assertThat(coach.getCoachingStrategy()).isEqualTo(baseCoach.getCoachingStrategy());
        assertThat(coach).isNotEqualTo(baseCoach);
    }

    @Test
    void should_create_coach_with_name() {
        // given
        FreeAgentMarket freeAgentMarket = new FreeAgentMarketAdapter(baseFirstPlayer, baseCoach, baseTeam);
        String newCoachName = "Pat Riley";

        // when
        Coach coach = freeAgentMarket.createCoach(newCoachName);

        // then
        assertThat(coach.getName()).satisfies(name -> {
            assertThat(name).isEqualTo(newCoachName);
            assertThat(name).isNotEqualTo(baseCoach.getName());
        });
        assertThat(coach.getCoachingStrategy()).isEqualTo(baseCoach.getCoachingStrategy());
        assertThat(coach).isNotEqualTo(baseCoach);
    }

    @Test
    void should_create_team() {
        // given
        FreeAgentMarket freeAgentMarket = new FreeAgentMarketAdapter(baseFirstPlayer, baseCoach, baseTeam);

        // when
        Team team = freeAgentMarket.createTeam();

        // then
        assertThat(team.getName()).isEqualTo(baseTeam.getName());
        assertThat(team.getCoach()).satisfies(coach -> {
            assertThat(coach.getName()).isEqualTo(baseCoach.getName());
            assertThat(coach.getCoachingStrategy()).isEqualTo(baseCoach.getCoachingStrategy());
            assertThat(coach).isNotEqualTo(baseCoach);
        });
        assertThat(team.getPlayers()).satisfies(players -> {
            assertThat(players).hasSize(baseTeam.getPlayers().size());
            assertThat(players).isNotEqualTo(baseTeam.getPlayers());
            assertThat(players).noneMatch(
                    player -> baseTeam.getPlayers().contains(player)
            );
        });
    }

    @Test
    void should_create_team_with_name() {
        // given
        FreeAgentMarket freeAgentMarket = new FreeAgentMarketAdapter(baseFirstPlayer, baseCoach, baseTeam);
        String newTeamName = "Los Angeles Lakers";

        // when
        Team team = freeAgentMarket.createTeam(newTeamName);

        // then
        assertThat(team.getName()).satisfies(name -> {
            assertThat(name).isEqualTo(newTeamName);
            assertThat(name).isNotEqualTo(baseTeam.getName());
        });
    }
}
