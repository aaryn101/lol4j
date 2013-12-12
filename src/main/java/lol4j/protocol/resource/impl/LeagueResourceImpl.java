package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.resource.LeagueResource;
import lol4j.util.Regions;

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
        getSupportedRegions().add(Regions.EUW);
        getSupportedRegions().add(Regions.BR);
        getSupportedRegions().add(Regions.NA);
        getSupportedRegions().add(Regions.TR);
        getSupportedRegions().add(Regions.EUNE);
    }

    @Override
    public Map<String, LeagueDto> getLeaguesData(String region, long summonerId) throws InvalidRegionException {
        if (isSupportedRegion(region)) {
            return getApiRequestManager()
                    .get(getBaseUri(), buildPath(region, summonerId), null, String.class, LeagueDto.class);
        }
        else {
            throw new InvalidRegionException(region);
        }
    }

    private String buildPath(String region, long summonerId) {
        return region + SLASH + RESOURCE_URI + SLASH + summonerId;
    }
}
