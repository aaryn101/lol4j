import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.game.GameDto;
import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.util.Region;
import org.junit.Assert;

/**
 * Created by Aaryn101 on 12/14/13.
 */
public class GameResourceImplTest {
    @org.junit.Test
    public void getRecentGames() {
        Lol4JTestVariables vars = Lol4JTestVariables.getInstance();
        RecentGamesDto recentGames = vars.getClient().getRecentGames(vars.getRegion(), vars.getSummonerId());

        Assert.assertNotNull(recentGames);
        Assert.assertNotNull(recentGames.getGames());
        Assert.assertTrue(recentGames.getGames().size() <= 10);

        if (recentGames.getGames().size() > 0) {
            GameDto game = recentGames.getGames().get(0);

            Assert.assertNotNull(game.getCreateDateStr());
            Assert.assertNotNull(game.getGameMode());
            Assert.assertNotNull(game.getGameType());
            Assert.assertNotNull(game.getStatistics());
            Assert.assertNotEquals(game.getStatistics().size(), 0);
            Assert.assertNotNull(game.getSubType());
            Assert.assertNotNull(game.getFellowPlayers());
            Assert.assertNotEquals(game.getFellowPlayers().size(), 0);
        }
    }

    @org.junit.Test
    public void getRecentGamesWithUnsupportedRegion() {
        boolean exceptionThrown = false;

        try {
            Lol4JTestVariables.getInstance().getClient().getRecentGames(Region.TR, 0L);
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
            Lol4JTestVariables.getInstance().getClient().getRecentGames(null, 0L);
        }
        catch(InvalidRegionException e) {
            exceptionThrown = true;
        }

        Assert.assertTrue(exceptionThrown);
    }
}
