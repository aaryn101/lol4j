package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.champion.ChampionDto;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.protocol.resource.ChampionResource;
import lol4j.util.Region;

import java.util.HashMap;
import java.util.Map;

/**
 * Compatible with champion-v1.2
 */
public class ChampionResourceImpl extends ApiResource implements ChampionResource {
    private static final String VERSION = "v1.2";
    private static final String NAME = "champion";

    public ChampionResourceImpl() {
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
                Region.TR
        );
    }

    @Override
    public ChampionListDto getAllChampions(Region region, boolean freeToPlay) {
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("freeToPlay", freeToPlay);

        return get(region, null, queryParams, false, ChampionListDto.class);
    }

    @Override
    public ChampionDto getChampion(Region region, int championId) {
        return get(region, String.valueOf(championId), null, false, ChampionDto.class);
    }
}
