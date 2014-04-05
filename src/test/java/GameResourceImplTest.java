import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.game.GameDto;
import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.util.Region;
import org.junit.Assert;

/**
 * Created by Aaron Corley on 12/14/13.
 */
public class GameResourceImplTest {
    private static final long SUMMONER_ID = 19163557;
    private static final Region REGION = Region.NA;

    @org.junit.Test
    public void getRecentGames() {
        RecentGamesDto recentGames = Lol4JTestClient.getClient().getRecentGames(REGION, SUMMONER_ID);

        Assert.assertNotNull(recentGames);
        Assert.assertNotNull(recentGames.getGames());
        Assert.assertTrue(recentGames.getGames().size() <= 10);

        if (recentGames.getGames().size() > 0) {
            GameDto game = recentGames.getGames().get(0);

            Assert.assertNotNull(game.getGameMode());
            Assert.assertNotNull(game.getGameType());
            Assert.assertNotNull(game.getGameMap());
            Assert.assertNotNull(game.getStats());
            Assert.assertNotNull(game.getSubType());
            Assert.assertNotNull(game.getFellowPlayers());
            Assert.assertNotEquals(game.getFellowPlayers().size(), 0);
            Assert.assertTrue(game.getIpEarned() >= 0);
        }
    }

    @org.junit.Test
    public void getRecentGamesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getRecentGames(Region.UNKNOWN, 0L);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }

    @org.junit.Test
    public void getRecentGamesWithNullRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestClient.getClient().getRecentGames(null, 0L);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }
}
