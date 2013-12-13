package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.protocol.resource.SummonerResource;
import lol4j.util.Region;

/**
 * Created by Aaryn101 on 12/12/13.
 */
public class SummonerResourceImpl extends AbstractResourceImpl implements SummonerResource {
    private static final String RESOURCE_VERSION = "v1.1";
    private static final String RESOURCE_PATH = "summoner";
    private static final String SLASH = "/";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public SummonerResourceImpl() {
        getSupportedRegions().add(Region.NA);
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.EUNE);
    }

    @Override
    public MasteryPagesDto getMasteryPages(Region region, long summonerId) {
        if (isSupportedRegion(region)) {
            String path = region.getName() + SLASH + RESOURCE_URI + SLASH + summonerId + SLASH + "masteries";

            return getApiRequestManager().get(getBaseUri(), path, null, MasteryPagesDto.class);
        }
        else {
            throw new InvalidRegionException(region);
        }
    }
}
