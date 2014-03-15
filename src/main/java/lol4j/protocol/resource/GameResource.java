package lol4j.protocol.resource;

import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.util.Region;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public interface GameResource {
    RecentGamesDto getRecentGames(Region region, long summonerId);
}
