package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.protocol.resource.GameResource;
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
        getSupportedRegions().add(Region.BR);
        getSupportedRegions().add(Region.EUNE);
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.LAN);
        getSupportedRegions().add(Region.LAS);
        getSupportedRegions().add(Region.NA);
    }

    @Override
    public RecentGamesDto getRecentGames(Region region, long summonerId) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + summonerId + SLASH + "recent";

        return getApiRequestManager().get(path, null, false, RecentGamesDto.class);
    }
}
