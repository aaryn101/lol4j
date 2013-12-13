package lol4j.protocol.resource;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.util.Region;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public interface GameResource {
    RecentGamesDto getRecentGames(Region region, long summonerId) throws InvalidRegionException;
}
