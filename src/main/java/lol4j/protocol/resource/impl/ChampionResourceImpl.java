package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.protocol.resource.ChampionResource;
import lol4j.util.Region;

import java.util.HashMap;
import java.util.Map;

/**
 * Compatible with champion-v1.1
 */
public class ChampionResourceImpl extends AbstractResourceImpl implements ChampionResource {
    private static final String RESOURCE_VERSION = "v1.1";
    private static final String RESOURCE_PATH = "champion";
    private static final String SLASH = "/";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public ChampionResourceImpl() {
        getSupportedRegions().add(Region.BR);
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.EUNE);
        getSupportedRegions().add(Region.LAN);
        getSupportedRegions().add(Region.LAS);
        getSupportedRegions().add(Region.NA);
    }

    @Override
    public ChampionListDto getAllChampions(Region region, boolean freeToPlay) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI;
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("freeToPlay", freeToPlay);

        return getApiRequestManager().get(path, queryParams, false, ChampionListDto.class);
    }
}
