package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.champion.ChampionMasteryDto;
import lol4j.protocol.resource.ChampionMasteryResource;
import lol4j.util.Region;

import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 * Created by aaryn on 11/23/16.
 */
public class ChampionMasteryResourceImpl extends LocationResource implements ChampionMasteryResource {
    private static final String CHAMPION = "champion";
    private static final String CHAMPIONS = "champions";
    private static final String PLAYER = "player";
    private static final String NAME = "championmastery";
    private static final String SCORE = "score";
    private static final String TOP_CHAMPIONS = "topchampions";

    public ChampionMasteryResourceImpl() {
        super(
                NAME,
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
    public ChampionMasteryDto getChampionMastery(Region region, long summonerId, long championId) {
        String path = getSummonerPath(summonerId) + SLASH + getChampionPath(championId);

        return get(region, path, null, false, ChampionMasteryDto.class);
    }

    @Override
    public List<ChampionMasteryDto> getChampionMasteries(Region region, long summonerId) {
        String path = getSummonerPath(summonerId) + SLASH + CHAMPIONS;

        return get(region, path, null, false, new GenericType<List<ChampionMasteryDto>>() {});
    }

    @Override
    public int getChampionMasteryScore(Region region, long summonerId) {
        String path = getSummonerPath(summonerId) + SLASH + SCORE;

        return get(region, path, null, false, Integer.class);
    }

    @Override
    public List<ChampionMasteryDto> getTopChampions(Region region, long summonerId) {
        String path = getSummonerPath(summonerId) + SLASH + TOP_CHAMPIONS;

        return get(region, path, null, false, new GenericType<List<ChampionMasteryDto>>() {});
    }

    private String getChampionPath(long championId) {
        return CHAMPION + SLASH + championId;
    }

    private String getSummonerPath(long summonerId) {
        return PLAYER + SLASH + summonerId;
    }
}
