package lol4j.protocol.resource;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.game.RecentGamesDto;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public interface GameResource {
    RecentGamesDto getRecentGames(String region, long summonerId) throws InvalidRegionException;
}
