package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.protocol.resource.GameResource;
import lol4j.util.Region;

/**
 * Compatible with game-v1.3
 */
public class GameResourceImpl extends ApiResource implements GameResource {
    private static final String VERSION = "v1.3";
    private static final String NAME = "game" + SLASH + "by-summoner";

    public GameResourceImpl() {
        super(
                NAME,
                VERSION,
                Region.BR,
                Region.EUNE,
                Region.EUW,
                Region.JP,
                Region.KR,
                Region.LAN,
                Region.LAS,
                Region.NA,
                Region.OCE,
                Region.RU,
                Region.TR,
                Region.KR
        );
    }

    @Override

    public RecentGamesDto getRecentGames(Region region, long summonerId) {
        String path = summonerId + SLASH + "recent";

        return get(region, path, null, false, RecentGamesDto.class);
    }
}
