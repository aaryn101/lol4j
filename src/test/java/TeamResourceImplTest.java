import lol4j.exception.InvalidRegionException;
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

/**
 * Created by Aaron Corley on 12/16/13.
 */
public class TeamResourceImplTest {
    private static final long SUMMONER_ID = 19163557;
    private static final String TEAM_ID = "TEAM-898cb9e0-e9e5-11e2-ab2b-782bcb4d0bb2";
    private static final Region REGION = Region.NA;
    private static final List<String> TEAM_IDS = new ArrayList<>();

    @BeforeClass
    public static void initializeTest() {
        TEAM_IDS.add(TEAM_ID);
    }

    @Test(expected = InvalidRegionException.class)
    public void getTeamsBySummonerWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getTeams(SUMMONER_ID, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getTeamsBySummonerWithNullRegion() {
        Lol4JTestClient.getClient().getTeams(SUMMONER_ID, null);
    }

    @Test
    public void getTeamsBySummoner() {
        List<TeamDto> teams = Lol4JTestClient.getClient().getTeams(SUMMONER_ID, REGION);
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
            if (team.getMessageOfDay() != null) {
                Assert.assertNotNull(team.getMessageOfDay().getMessage());
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
            Assert.assertNotNull(team.getTeamStatSummary());
            Assert.assertNotNull(team.getTeamStatSummary().getFullId());
            for (TeamStatDetailDto stat : team.getTeamStatSummary().getTeamStatDetails()) {
                Assert.assertNotNull(stat.getFullId());
                Assert.assertNotNull(stat.getTeamStatType());
            }
            Assert.assertNotNull(team.getThirdLastJoinDate());
        }
    }
    
    @Test(expected = InvalidRegionException.class)
     public void getTeamsWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getTeams(TEAM_IDS, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getTeamsWithNullRegion() {
        Lol4JTestClient.getClient().getTeams(TEAM_IDS, null);
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
            if (team.getMessageOfDay() != null) {
                Assert.assertNotNull(team.getMessageOfDay().getMessage());
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
            Assert.assertNotNull(team.getTeamStatSummary());
            Assert.assertNotNull(team.getTeamStatSummary().getFullId());
            for (TeamStatDetailDto stat : team.getTeamStatSummary().getTeamStatDetails()) {
                Assert.assertNotNull(stat.getFullId());
                Assert.assertNotNull(stat.getTeamStatType());
            }
            Assert.assertNotNull(team.getThirdLastJoinDate());
        }
    }

    @Test(expected = InvalidRegionException.class)
    public void getTeamWithUnsupportedRegion() {
        Lol4JTestClient.getClient().getTeam(TEAM_ID, Region.UNKNOWN);
    }

    @Test(expected = InvalidRegionException.class)
    public void getTeamWithNullRegion() {
        Lol4JTestClient.getClient().getTeam(TEAM_ID, null);
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
        if (team.getMessageOfDay() != null) {
            Assert.assertNotNull(team.getMessageOfDay().getMessage());
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
        Assert.assertNotNull(team.getTeamStatSummary());
        Assert.assertNotNull(team.getTeamStatSummary().getFullId());
        for (TeamStatDetailDto stat : team.getTeamStatSummary().getTeamStatDetails()) {
            Assert.assertNotNull(stat.getFullId());
            Assert.assertNotNull(stat.getTeamStatType());
        }
        Assert.assertNotNull(team.getThirdLastJoinDate());
    }
}
