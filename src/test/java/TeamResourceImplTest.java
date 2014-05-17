import lol4j.protocol.dto.team.MatchHistorySummaryDto;
import lol4j.protocol.dto.team.TeamDto;
import lol4j.protocol.dto.team.TeamMemberInfoDto;
import lol4j.protocol.dto.team.TeamStatDetailDto;
import lol4j.protocol.resource.impl.TeamResourceImpl;
import lol4j.util.Region;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Aaron Corley on 12/16/13.
 */
public class TeamResourceImplTest {
    private static final long SUMMONER_ID = 19163557;
    private static final long SUMMONER_ID_TWO = 20295494;
    private static final String TEAM_ID = "TEAM-898cb9e0-e9e5-11e2-ab2b-782bcb4d0bb2";
    private static final Region REGION = Region.NA;
    private static final List<String> TEAM_IDS = new ArrayList<>();
    private static final List<Long> SUMMONER_IDS = new ArrayList<>();

    @BeforeClass
    public static void initializeTest() {
        TEAM_IDS.add(TEAM_ID);
        SUMMONER_IDS.add(SUMMONER_ID);
        SUMMONER_IDS.add(SUMMONER_ID_TWO);
    }

    @Test
    public void getTeamsBySummoner() {
        List<TeamDto> teams = Lol4JTestClient.getClient().getTeamsBySummonerId(SUMMONER_ID, REGION);
        Assert.assertNotNull(teams);

        for (TeamDto team : teams) {
            Assert.assertNotNull(team.getCreateDate());
            Assert.assertNotNull(team.getFullId());
            Assert.assertNotNull(team.getLastGameDate());
            Assert.assertNotNull(team.getLastJoinDate());
            Assert.assertNotNull(team.getLastJoinedRankedTeamQueueDate());
            Assert.assertNotNull(team.getMatchHistory());
            for (MatchHistorySummaryDto summary : team.getMatchHistory()) {
                Assert.assertNotNull(summary.getGameMode());
                Assert.assertNotNull(summary.getMap());
                Assert.assertNotNull(summary.getOpposingTeamName());
            }
            Assert.assertNotNull(team.getModifyDate());
            Assert.assertNotNull(team.getName());
            Assert.assertNotNull(team.getRoster());
            for (TeamMemberInfoDto info : team.getRoster().getMemberList()) {
                Assert.assertNotNull(info.getInviteDate());
                Assert.assertNotNull(info.getJoinDate());
                Assert.assertNotNull(info.getStatus());
            }
            Assert.assertNotNull(team.getSecondLastJoinDate());
            Assert.assertNotNull(team.getStatus());
            Assert.assertNotNull(team.getTag());
            Assert.assertNotNull(team.getThirdLastJoinDate());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTeamsMapBySummonerWithNullList() {
        Lol4JTestClient.getClient().getTeamsBySummonerId(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTeamsMapBySummonerWithEmptyList() {
        Lol4JTestClient.getClient().getTeamsBySummonerId(new ArrayList<Long>(), REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTeamsMapBySummonerWithBigList() {
        List<Long> big = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < TeamResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(random.nextLong());
        }
        Lol4JTestClient.getClient().getTeamsBySummonerId(big, REGION);
    }

    @Test
    public void getTeamsMapBySummoner() {
        Map<String, List<TeamDto>> map = Lol4JTestClient.getClient().getTeamsBySummonerId(SUMMONER_IDS, REGION);

        Assert.assertNotNull(map);
        Assert.assertNotNull(map.get(Long.toString(SUMMONER_ID)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTeamsWithNullList() {
        Lol4JTestClient.getClient().getTeams(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTeamsWithEmptyList() {
        List<String> empty = new ArrayList<>();
        Lol4JTestClient.getClient().getTeams(empty, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getTeamsWithBigList() {
        List<String> big = new ArrayList<>();

        for (int i = 0; i < TeamResourceImpl.MAX_LIST_SIZE + 1; i++) {
            big.add(TEAM_ID);
        }
        Lol4JTestClient.getClient().getTeams(big, REGION);
    }

    @Test
    public void getTeams() {
        Map<String, TeamDto> teams = Lol4JTestClient.getClient().getTeams(TEAM_IDS, REGION);
        Assert.assertNotNull(teams);

        for (Map.Entry<String, TeamDto> entry : teams.entrySet()) {
            TeamDto team = entry.getValue();

            Assert.assertNotNull(entry.getKey());
            Assert.assertNotNull(team);
            Assert.assertNotNull(team.getCreateDate());
            Assert.assertNotNull(team.getFullId());
            Assert.assertNotNull(team.getLastGameDate());
            Assert.assertNotNull(team.getLastJoinDate());
            Assert.assertNotNull(team.getLastJoinedRankedTeamQueueDate());
            Assert.assertNotNull(team.getMatchHistory());
            for (MatchHistorySummaryDto summary : team.getMatchHistory()) {
                Assert.assertNotNull(summary.getGameMode());
                Assert.assertNotNull(summary.getMap());
                Assert.assertNotNull(summary.getOpposingTeamName());
            }
            Assert.assertNotNull(team.getModifyDate());
            Assert.assertNotNull(team.getName());
            Assert.assertNotNull(team.getRoster());
            for (TeamMemberInfoDto info : team.getRoster().getMemberList()) {
                Assert.assertNotNull(info.getInviteDate());
                Assert.assertNotNull(info.getJoinDate());
                Assert.assertNotNull(info.getStatus());
            }
            Assert.assertNotNull(team.getSecondLastJoinDate());
            Assert.assertNotNull(team.getStatus());
            Assert.assertNotNull(team.getTag());
            Assert.assertNotNull(team.getThirdLastJoinDate());
        }
    }

    @Test
    public void getTeam() {
        TeamDto team = Lol4JTestClient.getClient().getTeam(TEAM_ID, REGION);
        Assert.assertNotNull(team);

        Assert.assertNotNull(team.getCreateDate());
        Assert.assertNotNull(team.getFullId());
        Assert.assertNotNull(team.getLastGameDate());
        Assert.assertNotNull(team.getLastJoinDate());
        Assert.assertNotNull(team.getLastJoinedRankedTeamQueueDate());
        Assert.assertNotNull(team.getMatchHistory());
        for (MatchHistorySummaryDto summary : team.getMatchHistory()) {
            Assert.assertNotNull(summary.getGameMode());
            Assert.assertNotNull(summary.getMap());
            Assert.assertNotNull(summary.getOpposingTeamName());
        }
        Assert.assertNotNull(team.getModifyDate());
        Assert.assertNotNull(team.getName());
        Assert.assertNotNull(team.getRoster());
        for (TeamMemberInfoDto info : team.getRoster().getMemberList()) {
            Assert.assertNotNull(info.getInviteDate());
            Assert.assertNotNull(info.getJoinDate());
            Assert.assertNotNull(info.getStatus());
        }
        Assert.assertNotNull(team.getSecondLastJoinDate());
        Assert.assertNotNull(team.getStatus());
        Assert.assertNotNull(team.getTag());
        Assert.assertNotNull(team.getThirdLastJoinDate());
    }
}
