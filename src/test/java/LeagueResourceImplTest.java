import lol4j.exception.InvalidRegionException;
import lol4j.exception.SubTypeMismatchException;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueItemDto;
import lol4j.util.Region;
import lol4j.util.game.SubType;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by Aaron Corley on 12/14/13.
 */
public class LeagueResourceImplTest {
    private static final long SUMMONER_ID = 19163557;
    private static final Region REGION = Region.NA;
    private static final SubType GAME_TYPE = SubType.RANKED_SOLO_5X5;

    @Test
    public void getChallengerLeagueWithInvalidGameType() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChallengerLeague(REGION, SubType.NONE);
        }
        catch(SubTypeMismatchException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChallengerLeagueWithNullGameType() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChallengerLeague(REGION, null);
        }
        catch(SubTypeMismatchException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChallengerLeagueWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChallengerLeague(null, SubType.NONE);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChallengerLeagueWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getChallengerLeague(Region.UNKNOWN, SubType.NONE);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getChallengerLeague() {
        LeagueDto league = Lol4JTestClient.getClient().getChallengerLeague(REGION, GAME_TYPE);

        Assert.assertNotNull(league);
        Assert.assertNotNull(league.getName());
        Assert.assertNotNull(league.getTier());
        Assert.assertNotNull(league.getQueue());
        Assert.assertNotNull(league.getEntries());
        Assert.assertNotEquals(league.getEntries().size(), 0);
    }

    @Test
    public void getLeaguesEntryDataWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getLeaguesEntryData(SUMMONER_ID, null);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getLeaguesEntryDataWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getLeaguesEntryData(SUMMONER_ID, Region.UNKNOWN);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getLeaguesEntryData() {
        List<LeagueItemDto> leagueItems = Lol4JTestClient.getClient().getLeaguesEntryData(SUMMONER_ID, REGION);

        Assert.assertNotNull(leagueItems);
    }

    @Test
    public void getLeaguesDataWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getLeaguesData(SUMMONER_ID, null);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getLeaguesDataWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getLeaguesData(SUMMONER_ID, Region.UNKNOWN);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @Test
    public void getLeaguesData() {
        List<LeagueDto> leaguesData = Lol4JTestClient.getClient().getLeaguesData(SUMMONER_ID, REGION);

        Assert.assertNotNull(leaguesData);

        for (LeagueDto leagueData : leaguesData) {
            Assert.assertNotNull(leagueData);
            Assert.assertNotNull(leagueData.getName());
            Assert.assertNotNull(leagueData.getTier());
            Assert.assertNotNull(leagueData.getQueue());
            Assert.assertNotNull(leagueData.getEntries());
            Assert.assertNotEquals(leagueData.getEntries().size(), 0);
        }
    }
}
