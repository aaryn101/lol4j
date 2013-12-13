package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.resource.LeagueResource;
import lol4j.util.Region;

import java.util.Map;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public class LeagueResourceImpl extends AbstractResourceImpl implements LeagueResource {
    private static final String SLASH = "/";
    private static final String RESOURCE_VERSION = "v2.1";
    private static final String RESOURCE_PATH = "league" + SLASH + "by-summoner";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public LeagueResourceImpl() {
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.BR);
        getSupportedRegions().add(Region.NA);
        getSupportedRegions().add(Region.TR);
        getSupportedRegions().add(Region.EUNE);
    }

    @Override
    public Map<String, LeagueDto> getLeaguesData(Region region, long summonerId) {
        if (isSupportedRegion(region)) {
            String path = region.getName() + SLASH + RESOURCE_URI + SLASH + summonerId;

            return getApiRequestManager()
                    .get(getBaseUri(), path, null, String.class, LeagueDto.class);
        }
        else {
            throw new InvalidRegionException(region);
        }
    }
}
