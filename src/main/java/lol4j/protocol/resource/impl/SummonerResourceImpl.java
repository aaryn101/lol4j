package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.protocol.dto.summoner.RunePagesDto;
import lol4j.protocol.dto.summoner.SummonerDto;
import lol4j.protocol.resource.SummonerResource;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.GenericType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * Compatible with summoner-v1.4
 */
public class SummonerResourceImpl extends AbstractResourceImpl implements SummonerResource {
    private static final String RESOURCE_VERSION = "v1.4";
    private static final String RESOURCE_PATH = "summoner";
    private static final String SLASH = "/";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;
    private static final String RUNES = "runes";
    private static final String MASTERIES = "masteries";
    private static final String BY_NAME = "by-name";
    private static final String NAME = "name";
    public static final int MAX_LIST_SIZE = 40;

    public SummonerResourceImpl() {
        super(
                Region.BR,
                Region.EUNE,
                Region.EUW,
                Region.LAN,
                Region.LAS,
                Region.NA
        );
    }

    @Override
    public Map<String, MasteryPagesDto> getMasteryPages(List<Long> summonerIds, Region region) {
        if (summonerIds == null || summonerIds.size() > MAX_LIST_SIZE || summonerIds.size() == 0) {
            throw new IllegalArgumentException("summonerIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String summonerIdList = StringUtils.join(summonerIds, ",");
        String path = RESOURCE_URI + SLASH + summonerIdList + SLASH + MASTERIES;

        return get(region, path, null, false, new GenericType<Map<String, MasteryPagesDto>>() {});
    }

    @Override
    public MasteryPagesDto getMasteryPages(long summonerId, Region region) {
        String path = RESOURCE_URI + SLASH + summonerId + SLASH + MASTERIES;
        Map<String, MasteryPagesDto> result = get(region, path, null, false, new GenericType<Map<String, MasteryPagesDto>>() {});

        return result.get(Long.toString(summonerId));
    }

    @Override
    public Map<String, RunePagesDto> getRunePages(List<Long> summonerIds, Region region) {
        if (summonerIds == null || summonerIds.size() > MAX_LIST_SIZE || summonerIds.size() == 0) {
            throw new IllegalArgumentException("summonerIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String summonerIdList = StringUtils.join(summonerIds, ",");
        String path = RESOURCE_URI + SLASH + summonerIdList + SLASH + RUNES;

        return get(region, path, null, false, new GenericType<Map<String, RunePagesDto>>() {});
    }

    @Override
    public RunePagesDto getRunePages(long summonerId, Region region) {
        String path = RESOURCE_URI + SLASH + summonerId + SLASH + RUNES;
        Map<String, RunePagesDto> result = get(region, path, null, false, new GenericType<Map<String, RunePagesDto>>() {});

        return result.get(Long.toString(summonerId));
    }

    @Override
    public Map<String, SummonerDto> getSummonersByName(List<String> names, Region region) {
        if (names == null || names.size() > MAX_LIST_SIZE || names.size() == 0) {
            throw new IllegalArgumentException("summonerIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String summonerNameList = StringUtils.join(names, ",");
        String path;
        try {
            path = RESOURCE_URI + SLASH + BY_NAME + SLASH + URLEncoder.encode(summonerNameList, ApiRequestManager.ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unsupported encoding: " + ApiRequestManager.ENCODING);
        }

        return get(region, path, null, false, new GenericType<Map<String, SummonerDto>>() {});
    }

    @Override
    public SummonerDto getSummonerByName(String name, Region region) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name must not be null or empty");
        }
        String path;
        try {
            path = RESOURCE_URI + SLASH + BY_NAME + SLASH + URLEncoder.encode(name, ApiRequestManager.ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Unsupported encoding: " + ApiRequestManager.ENCODING);
        }
        Map<String, SummonerDto> result = get(region, path, null, false, new GenericType<Map<String, SummonerDto>>() {});

        return result.get(name.toLowerCase());
    }

    @Override
    public Map<String, SummonerDto> getSummoners(List<Long> summonerIds, Region region) {
        if (summonerIds == null || summonerIds.size() > MAX_LIST_SIZE || summonerIds.size() == 0) {
            throw new IllegalArgumentException("summonerIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String summonerIdList = StringUtils.join(summonerIds, ",");
        String path = RESOURCE_URI + SLASH + summonerIdList;

        return get(region, path, null, false, new GenericType<Map<String, SummonerDto>>() {});
    }

    @Override
    public SummonerDto getSummoner(long summonerId, Region region) {
        String path = RESOURCE_URI + SLASH + summonerId;
        Map<String, SummonerDto> result = get(region, path, null, false, new GenericType<Map<String, SummonerDto>>() {});

        return result.get(Long.toString(summonerId));
    }

    @Override
    public Map<String, String> getSummonerNames(List<Long> summonerIds, Region region) {
        if (summonerIds == null || summonerIds.size() > MAX_LIST_SIZE || summonerIds.size() == 0) {
            throw new IllegalArgumentException("summonerIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String summonerIdList = StringUtils.join(summonerIds, ",");
        String path = RESOURCE_URI + SLASH + summonerIdList + SLASH + NAME;

        return get(region, path, null, false, new GenericType<Map<String, String>>() {});
    }

    @Override
    public String getSummonerName(long summonerId, Region region) {
        String path = RESOURCE_URI + SLASH + summonerId + SLASH + NAME;
        Map<String, String> result = get(region, path, null, false, new GenericType<Map<String, String>>() {});

        return result.get(Long.toString(summonerId));
    }
}
