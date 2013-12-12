package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.game.RecentGamesDto;
import lol4j.protocol.resource.GameResource;
import lol4j.util.Regions;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class GameResourceImpl extends AbstractResourceImpl implements GameResource {
    private static final String SLASH = "/";
    private static final String RESOURCE_VERSION = "v1.1";
    private static final String RESOURCE_PATH = "game" + SLASH + "by-summoner";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public GameResourceImpl() {
        getSupportedRegions().add(Regions.EUNE);
        getSupportedRegions().add(Regions.EUW);
        getSupportedRegions().add(Regions.NA);
    }

    @Override
    public RecentGamesDto getRecentGames(String region, long summonerId) throws InvalidRegionException {
        if (isSupportedRegion(region)) {
            return getApiRequestManager()
                    .get(getBaseUri(), buildPath(region, summonerId), null, RecentGamesDto.class);
        }
        else {
            throw new InvalidRegionException(region);
        }
    }

    private String buildPath(String region, long summonerId) {
        return region + SLASH + RESOURCE_URI + SLASH + summonerId + SLASH + "recent";
    }
}
