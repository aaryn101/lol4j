import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.team.MatchHistorySummaryDto;
import lol4j.protocol.dto.team.TeamDto;
import lol4j.protocol.dto.team.TeamMemberInfoDto;
import lol4j.protocol.dto.team.TeamStatDetailDto;
import lol4j.util.Region;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Aaryn101 on 12/16/13.
 */
public class TeamResourceImplTest {
    private static final long SUMMONER_ID = 19163557;
    private static final Region REGION = Region.NA;

    @Test
    public void getTeams() {
        List<TeamDto> teams = Lol4JTestClient.getClient().getTeams(REGION, SUMMONER_ID);
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

    @Test
    public void getTeamsWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getTeams(Region.LAN, SUMMONER_ID);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getTeamsWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getTeams(null, SUMMONER_ID);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }
}
