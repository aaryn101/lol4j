import lol4j.exception.SubTypeMismatchException;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueEntryDto;
import lol4j.protocol.resource.impl.LeagueResourceImpl;
import lol4j.util.Region;
import lol4j.util.game.SubType;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Aaron Corley on 12/14/13.
 */
public class LeagueResourceImplTest {
    private static final long SUMMONER_ID = 19163557;
    private static final long SUMMONER_ID_TWO = 20295494;
    private static final String TEAM_ID = "TEAM-898cb9e0-e9e5-11e2-ab2b-782bcb4d0bb2"; // fragile!
    private static final String TEAM_ID_TWO = "TEAM-30f02cb0-c3f0-11e2-8543-782bcb4d0bb2"; // fragile!
    private static final Region REGION = Region.NA;
    private static final SubType GAME_TYPE = SubType.RANKED_SOLO_5X5;
    private static final List<Long> SUMMONER_ID_LIST = new ArrayList<>();
    private static final List<String> TEAM_ID_LIST = new ArrayList<>();

    @BeforeClass
    public static void init() {
        SUMMONER_ID_LIST.add(SUMMONER_ID);
        SUMMONER_ID_LIST.add(SUMMONER_ID_TWO);
        TEAM_ID_LIST.add(TEAM_ID);
        TEAM_ID_LIST.add(TEAM_ID_TWO);
    }

    @Test(expected = SubTypeMismatchException.class)
    public void getChallengerLeagueWithInvalidGameType() {
        Lol4JTestClient.getClient().getChallengerLeague(REGION, SubType.NONE);
    }

    @Test(expected = SubTypeMismatchException.class)
    public void getChallengerLeagueWithNullGameType() {
        Lol4JTestClient.getClient().getChallengerLeague(REGION, null);
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
    public void getLeaguesEntryData() {
        List<LeagueEntryDto> leagueItems = Lol4JTestClient.getClient().getLeaguesEntryData(SUMMONER_ID, REGION);

        Assert.assertNotNull(leagueItems);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesEntryDataMapWithNullList() {
        Lol4JTestClient.getClient().getLeaguesEntryData(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesEntryDataMapWithEmptyList() {
        Lol4JTestClient.getClient().getLeaguesEntryData(new ArrayList<Long>(), REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesEntryDataMapWithTooBigList() {
        List<Long> tooBigList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < LeagueResourceImpl.MAX_LIST_SIZE + 1; i++) {
            tooBigList.add(random.nextLong());
        }
        Lol4JTestClient.getClient().getLeaguesEntryData(tooBigList, REGION);
    }

    @Test
    public void getLeaguesEntryDataMap() {
        Map<String, List<LeagueEntryDto>> map = Lol4JTestClient.getClient().getLeaguesEntryData(SUMMONER_ID_LIST, REGION);

        Assert.assertNotNull(map);
        Assert.assertNotNull(map.get(Long.toString(SUMMONER_ID)));
        Assert.assertNotNull(map.get(Long.toString(SUMMONER_ID_TWO)));
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

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesDataMapWithNullList() {
        Lol4JTestClient.getClient().getLeaguesData(null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesDataMapWithEmptyList() {
        Lol4JTestClient.getClient().getLeaguesData(new ArrayList<Long>(), REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesDataMapWithTooBigList() {
        List<Long> tooBigList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < LeagueResourceImpl.MAX_LIST_SIZE + 1; i++) {
            tooBigList.add(random.nextLong());
        }

        Lol4JTestClient.getClient().getLeaguesData(tooBigList, REGION);
    }
    
    @Test
    public void getLeaguesDataMap() {
        Map<String, List<LeagueDto>> map = Lol4JTestClient.getClient().getLeaguesData(SUMMONER_ID_LIST, REGION);

        Assert.assertNotNull(map);
        Assert.assertNotNull(map.get(Long.toString(SUMMONER_ID)));
        Assert.assertNotNull(map.get(Long.toString(SUMMONER_ID_TWO)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesDataByTeamWithNullId() {
        Lol4JTestClient.getClient().getLeaguesDataByTeam((String) null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesDataByTeamWithEmptyId() {
        Lol4JTestClient.getClient().getLeaguesDataByTeam("", REGION);
    }

    @Test
    public void getLeaguesDataByTeam() {
        List<LeagueDto> data = Lol4JTestClient.getClient().getLeaguesDataByTeam(TEAM_ID, REGION);

        Assert.assertNotNull(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesEntryDataByTeamWithNullId() {
        Lol4JTestClient.getClient().getLeaguesEntryDataByTeam((String) null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesEntryDataByTeamWithEmptyId() {
        Lol4JTestClient.getClient().getLeaguesEntryDataByTeam("", REGION);
    }

    @Test
    public void getLeaguesEntryDataByTeam() {
        List<LeagueEntryDto> data = Lol4JTestClient.getClient().getLeaguesEntryDataByTeam(TEAM_ID, REGION);

        Assert.assertNotNull(data);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesEntryDataMapByTeamWithNullList() {
        Lol4JTestClient.getClient().getLeaguesEntryDataByTeam((List) null, REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesEntryDataMapByTeamWithEmptyList() {
        Lol4JTestClient.getClient().getLeaguesEntryDataByTeam(new ArrayList<String>(), REGION);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLeaguesEntryDataMapByTeamWithTooBigList() {
        List<String> tooBigList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < LeagueResourceImpl.MAX_LIST_SIZE + 1; i++) {
            tooBigList.add(Long.toString(random.nextLong()));
        }

        Lol4JTestClient.getClient().getLeaguesEntryDataByTeam(tooBigList, REGION);
    }

    @Test
    public void getLeaguesEntryDataMapByTeam() {
        Map<String, List<LeagueEntryDto>> map = Lol4JTestClient.getClient().getLeaguesEntryDataByTeam(TEAM_ID_LIST, REGION);

        Assert.assertNotNull(map);
    }
}
