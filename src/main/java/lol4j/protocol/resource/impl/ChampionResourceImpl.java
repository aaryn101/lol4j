package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.champion.ChampionDto;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.protocol.resource.ChampionResource;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;

import java.util.HashMap;
import java.util.Map;

/**
 * Compatible with champion-v1.2
 */
public class ChampionResourceImpl extends AbstractResourceImpl implements ChampionResource {
    private static final String RESOURCE_VERSION = "v1.2";
    private static final String RESOURCE_PATH = "champion";
    private static final String SLASH = "/";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;

    public ChampionResourceImpl() {
        super(
                Region.BR,
                Region.EUW,
                Region.EUNE,
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
    public ChampionListDto getAllChampions(Region region, boolean freeToPlay) {
        String path = RESOURCE_URI;
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("freeToPlay", freeToPlay);

        return get(region, path, queryParams, false, ChampionListDto.class);
    }

    @Override
    public ChampionDto getChampion(Region region, int championId) {
        String path = RESOURCE_URI + SLASH + String.valueOf(championId);

        return get(region, path, null, false, ChampionDto.class);
    }
}
