package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.protocol.resource.ChampionResource;
import lol4j.util.Regions;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class ChampionResourceImpl extends AbstractResourceImpl implements ChampionResource {
    private static final String RESOURCE_VERSION = "v1.1";
    private static final String RESOURCE_PATH = "champion";
    private static final String SLASH = "/";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public ChampionResourceImpl() {
        this.getSupportedRegions().add(Regions.EUW);
        this.getSupportedRegions().add(Regions.EUNE);
        this.getSupportedRegions().add(Regions.NA);
    }

    @Override
    public ChampionListDto getAllChampions(String region, boolean freeToPlay) throws InvalidRegionException {
        if (isSupportedRegion(region)) {
            return getApiRequestManager()
                    .get(getBaseUri(), buildPath(region), buildQueryParams(freeToPlay), ChampionListDto.class);
        }
        else {
            throw new InvalidRegionException(region);
        }
    }

    private List<Map.Entry<String, Object>> buildQueryParams(boolean freeToPlay) {
        List<Map.Entry<String, Object>> queryParams = new ArrayList<>();
        queryParams.add(new AbstractMap.SimpleEntry("freeToPlay", Boolean.valueOf(freeToPlay)));

        return queryParams;
    }

    private String buildPath(String region) {
        return region + SLASH + RESOURCE_URI;
    }
}
