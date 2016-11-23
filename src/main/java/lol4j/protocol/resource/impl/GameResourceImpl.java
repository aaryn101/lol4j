package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.protocol.resource.GameResource;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;

/**
 * Compatible with game-v1.3
 */
public class GameResourceImpl extends AbstractResourceImpl implements GameResource {
    private static final String SLASH = "/";
    private static final String RESOURCE_VERSION = "v1.3";
    private static final String RESOURCE_PATH = "game" + SLASH + "by-summoner";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public GameResourceImpl() {
        super(
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
        String path = RESOURCE_URI + SLASH + summonerId + SLASH + "recent";

        return get(region, path, null, false, RecentGamesDto.class);
    }
}
