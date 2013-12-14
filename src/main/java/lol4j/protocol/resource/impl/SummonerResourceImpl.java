package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.protocol.dto.summoner.RunePagesDto;
import lol4j.protocol.dto.summoner.SummonerDto;
import lol4j.protocol.dto.summoner.SummonerNameListDto;
import lol4j.protocol.resource.SummonerResource;
import lol4j.util.Region;

import java.util.List;

/**
 * Created by Aaryn101 on 12/12/13.
 */
public class SummonerResourceImpl extends AbstractResourceImpl implements SummonerResource {
    private static final String RESOURCE_VERSION = "v1.1";
    private static final String RESOURCE_PATH = "summoner";
    private static final String SLASH = "/";
    private static final String COMMA = ",";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;
    private static final String RUNES = "runes";
    private static final String MASTERIES = "masteries";
    private static final String BY_NAME = "by-name";
    private static final String NAME = "name";
    private static final int MAX_SUMMONER_IDS = 40;

    public SummonerResourceImpl() {
        getSupportedRegions().add(Region.NA);
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.EUNE);
    }

    @Override
    public MasteryPagesDto getMasteryPages(Region region, long summonerId) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + summonerId + SLASH + MASTERIES;

        return getApiRequestManager().get(getBaseUri(), path, null, MasteryPagesDto.class);
    }

    @Override
    public RunePagesDto getRunePages(Region region, long summonerId) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + summonerId + SLASH + RUNES;

        return getApiRequestManager().get(getBaseUri(), path, null, RunePagesDto.class);
    }

    @Override
    public SummonerDto getSummoner(Region region, String name) {
        doSupportedRegionCheck(region);
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid summoner name");
        }
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + BY_NAME + SLASH + name;

        return getApiRequestManager().get(getBaseUri(), path, null, SummonerDto.class);
    }

    @Override
    public SummonerDto getSummoner(Region region, long summonerId) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + summonerId;

        return getApiRequestManager().get(getBaseUri(), path, null, SummonerDto.class);
    }

    @Override
    public SummonerNameListDto getSummonerNames(Region region, List<Long> summonerIds) {
        doSupportedRegionCheck(region);
        if (summonerIds == null || summonerIds.size() > MAX_SUMMONER_IDS || summonerIds.size() == 0) {
            throw new IllegalArgumentException("Invalid summoner id list");
        }
        StringBuilder path = new StringBuilder();
        path.append(region.getName()).append(SLASH).append(RESOURCE_URI).append(SLASH);
        for (Long summonerId : summonerIds) {
            path.append(summonerId).append(COMMA);
        }
        path.deleteCharAt(path.length() - 1);
        path.append(SLASH).append(NAME);

        return getApiRequestManager().get(getBaseUri(), path.toString(), null, SummonerNameListDto.class);
    }
}
