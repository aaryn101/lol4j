package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.lolstaticdata.*;
import lol4j.protocol.resource.LolStaticDataResource;
import lol4j.util.Region;
import lol4j.util.lolstaticdata.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 3/9/14.
 */
public class LolStaticDataResourceImpl extends AbstractResourceImpl implements LolStaticDataResource {
    private static final String RESOURCE_VERSION = "v1.1";
    private static final String RESOURCE_PATH = "static-data";
    private static final String CHAMPION = "champion";
    private static final String ITEM = "item";
    private static final String MASTERY = "mastery";
    private static final String REALM = "realm";
    private static final String RUNE = "rune";
    private static final String SUMMONER_SPELL = "summoner-spell";
    private static final String SLASH = "/";

    public LolStaticDataResourceImpl() {
        getSupportedRegions().add(Region.BR);
        getSupportedRegions().add(Region.EUNE);
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.KR);
        getSupportedRegions().add(Region.LAN);
        getSupportedRegions().add(Region.LAS);
        getSupportedRegions().add(Region.NA);
        getSupportedRegions().add(Region.OCE);
        getSupportedRegions().add(Region.RU);
        getSupportedRegions().add(Region.TR);
    }

    @Override
    public ChampionListDto getChampionList(Region region, String locale, String version, List<ChampData> requestedData) {
        doSupportedRegionCheck(region);
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + CHAMPION;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (ChampData data : requestedData) {
                list.add(data.getChampData());
            }
            queryParams.put("champData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, ChampionListDto.class);
    }

    @Override
    public ChampionDto getChampion(String id, Region region, String locale, String version, List<ChampData> requestedData) {
        doSupportedRegionCheck(region);
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + CHAMPION + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (ChampData data : requestedData) {
                list.add(data.getChampData());
            }
            queryParams.put("champData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, ChampionDto.class);
    }

    @Override
    public BasicDataDto getItem(String id, Region region, String locale, String version, List<ItemData> requestedData) {
        doSupportedRegionCheck(region);
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + ITEM + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (ItemData data : requestedData) {
                list.add(data.getItemData());
            }
            queryParams.put("itemData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, BasicDataDto.class);
    }

    @Override
    public ItemListDto getItemList(Region region, String locale, String version, List<ItemData> requestedData) {
        doSupportedRegionCheck(region);
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + ITEM;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (ItemData data : requestedData) {
                list.add(data.getItemData());
            }
            queryParams.put("itemData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, ItemListDto.class);
    }

    @Override
    public MasteryDto getMastery(String id, Region region, String locale, String version, List<MasteryData> requestedData) {
        doSupportedRegionCheck(region);
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + MASTERY + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();
        buildQueryParams(locale, version, requestedData, queryParams);

        return getApiRequestManager().get(path, queryParams, true, MasteryDto.class);
    }

    private void buildQueryParams(String locale, String version, List<MasteryData> requestedData, Map<String, Object> queryParams) {
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (MasteryData data : requestedData) {
                list.add(data.getMasteryData());
            }
            queryParams.put("itemData", StringUtils.join(list, ","));
        }
    }

    @Override
    public MasteryListDto getMasteryList(Region region, String locale, String version, List<MasteryData> requestedData) {
        doSupportedRegionCheck(region);
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + MASTERY;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (MasteryData data : requestedData) {
                list.add(data.getMasteryData());
            }
            queryParams.put("itemData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, MasteryListDto.class);
    }

    @Override
    public RealmDto getRealm(Region region) {
        doSupportedRegionCheck(region);
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + REALM;

        return getApiRequestManager().get(path, null, true, RealmDto.class);
    }

    @Override
    public RuneListDto getRuneList(Region region, String locale, String version, List<RuneData> requestedData) {
        doSupportedRegionCheck(region);
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + RUNE;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (RuneData data : requestedData) {
                list.add(data.getRuneData());
            }
            queryParams.put("itemData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, RuneListDto.class);
    }

    @Override
    public BasicDataDto getRune(String id, Region region, String locale, String version, List<RuneData> requestedData) {
        doSupportedRegionCheck(region);
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + RUNE + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (RuneData data : requestedData) {
                list.add(data.getRuneData());
            }
            queryParams.put("itemData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, BasicDataDto.class);
    }

    @Override
    public SummonerSpellListDto getSummonerSpellList(Region region, String locale, String version, List<SummonerSpellData> requestedData) {
        doSupportedRegionCheck(region);
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + SUMMONER_SPELL;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (SummonerSpellData data : requestedData) {
                list.add(data.getSummonerSpellData());
            }
            queryParams.put("itemData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, SummonerSpellListDto.class);
    }

    @Override
    public SummonerSpellDto getSummonerSpell(String id, Region region, String locale, String version, List<SummonerSpellData> requestedData) {
        doSupportedRegionCheck(region);
        String path = RESOURCE_PATH + SLASH + region.getName() + SLASH + RESOURCE_VERSION + SLASH + SUMMONER_SPELL + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();
        if (locale != null && !locale.isEmpty()) {
            queryParams.put("locale", locale);
        }
        if (version != null && !version.isEmpty()) {
            queryParams.put("version", version);
        }
        if (requestedData != null) {
            List<String> list = new ArrayList<>();
            for (SummonerSpellData data : requestedData) {
                list.add(data.getSummonerSpellData());
            }
            queryParams.put("itemData", StringUtils.join(list, ","));
        }

        return getApiRequestManager().get(path, queryParams, true, SummonerSpellDto.class);
    }
}
