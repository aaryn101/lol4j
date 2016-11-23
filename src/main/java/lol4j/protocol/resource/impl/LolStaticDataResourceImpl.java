package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.lolstaticdata.*;
import lol4j.protocol.resource.LolStaticDataResource;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;
import lol4j.util.lolstaticdata.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Compatible with static-data v1.2
 */
public class LolStaticDataResourceImpl extends AbstractResource implements LolStaticDataResource {
    private static final String NAME = "static-data";
    private static final String VERSION = "v1.2";
    private static final String CHAMPION_URI = "champion";
    private static final String ITEM_URI = "item";
    private static final String MASTERY_URI = "mastery";
    private static final String REALM_URI = "realm";
    private static final String RUNE_URI = "rune";
    private static final String SUMMONER_SPELL_URI = "summoner-spell";
    private ApiRequestManager apiRequestManager;

    public LolStaticDataResourceImpl() {
        super(
                Region.BR,
                Region.EUNE,
                Region.EUW,
                Region.JP,
                Region.KR,
                Region.LAN,
                Region.LAS,
                Region.NA,
                Region.OCE,
                Region.PBE,
                Region.RU,
                Region.TR
        );
    }

    @Override
    public ChampionListDto getChampionList(Region region, String locale, String version, List<ChampData> requestedData) {
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedChampData(requestedData, queryParams);

        return get(region, CHAMPION_URI, queryParams, true, ChampionListDto.class);
    }

    @Override
    public ChampionDto getChampion(String id, Region region, String locale, String version, List<ChampData> requestedData) {
        checkForEmptyId(id);

        String path = CHAMPION_URI + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedChampData(requestedData, queryParams);

        return get(region, path, queryParams, true, ChampionDto.class);
    }

    @Override
    public BasicDataDto getItem(String id, Region region, String locale, String version, List<ItemData> requestedData) {
        checkForEmptyId(id);

        String path = ITEM_URI + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedItemData(requestedData, queryParams);

        return get(region, path, queryParams, true, BasicDataDto.class);
    }

    @Override
    public ItemListDto getItemList(Region region, String locale, String version, List<ItemData> requestedData) {
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedItemData(requestedData, queryParams);

        return get(region, ITEM_URI, queryParams, true, ItemListDto.class);
    }

    @Override
    public MasteryDto getMastery(String id, Region region, String locale, String version, List<MasteryData> requestedData) {
        checkForEmptyId(id);

        String path = MASTERY_URI + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedMasteryData(requestedData, queryParams);

        return get(region, path, queryParams, true, MasteryDto.class);
    }

    @Override
    public MasteryListDto getMasteryList(Region region, String locale, String version, List<MasteryData> requestedData) {
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedMasteryData(requestedData, queryParams);

        return get(region, MASTERY_URI, queryParams, true, MasteryListDto.class);
    }

    @Override
    public RealmDto getRealm(Region region) {
        return get(region, REALM_URI, null, true, RealmDto.class);
    }

    @Override
    public RuneListDto getRuneList(Region region, String locale, String version, List<RuneData> requestedData) {
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedRuneData(requestedData, queryParams);

        return get(region, RUNE_URI, queryParams, true, RuneListDto.class);
    }

    @Override
    public BasicDataDto getRune(String id, Region region, String locale, String version, List<RuneData> requestedData) {
        String path = RUNE_URI + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedRuneData(requestedData, queryParams);

        return get(region, path, queryParams, true, BasicDataDto.class);
    }

    @Override
    public SummonerSpellListDto getSummonerSpellList(Region region, String locale, String version, List<SummonerSpellData> requestedData) {
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedSummonerSpellData(requestedData, queryParams);

        return get(region, SUMMONER_SPELL_URI, queryParams, true, SummonerSpellListDto.class);
    }

    @Override
    public SummonerSpellDto getSummonerSpell(int id, Region region, String locale, String version, List<SummonerSpellData> requestedData) {
        String path = SUMMONER_SPELL_URI + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();

        addLocale(locale, queryParams);
        addVersion(version, queryParams);
        addRequestedSummonerSpellData(requestedData, queryParams);

        return get(region, path, queryParams, true, SummonerSpellDto.class);
    }

    public void setApiRequestManager(ApiRequestManager apiRequestManager) {
        this.apiRequestManager = apiRequestManager;
    }

    @Override
    public ApiRequestManager getApiRequestManager(Region region) {
        return apiRequestManager;
    }

    @Override
    protected String getBasePath(Region region) {
        return "api/lol/" + NAME + SLASH + region.getName() + SLASH + VERSION;
    }

    private void checkForEmptyId(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new IllegalArgumentException("id must not be empty");
        }
    }

    private void addLocale(String locale, Map<String, Object> queryParams) {
        if (!StringUtils.isEmpty(locale)) {
            queryParams.put("locale", locale);
        }
    }

    private void addVersion(String version, Map<String, Object> queryParams) {
        if (!StringUtils.isEmpty(version)) {
            queryParams.put("version", version);
        }
    }

    private void addRequestedItemData(List<ItemData> requestedData, Map<String, Object> queryParams) {
        if (requestedData != null) {
            List<String> list = new ArrayList<>();

            for (ItemData data : requestedData) {
                list.add(data.getItemData());
            }

            queryParams.put("itemData", StringUtils.join(list, ","));
        }
    }

    private void addRequestedChampData(List<ChampData> requestedData, Map<String, Object> queryParams) {
        if (requestedData != null) {
            List<String> list = new ArrayList<>();

            for (ChampData data : requestedData) {
                list.add(data.getChampData());
            }

            queryParams.put("champData", StringUtils.join(list, ","));
        }
    }

    private void addRequestedMasteryData(List<MasteryData> requestedData, Map<String, Object> queryParams) {
        if (requestedData != null) {
            List<String> list = new ArrayList<>();

            for (MasteryData data : requestedData) {
                list.add(data.getMasteryData());
            }

            queryParams.put("masteryData", StringUtils.join(list, ","));
        }
    }

    private void addRequestedRuneData(List<RuneData> requestedData, Map<String, Object> queryParams) {
        if (requestedData != null) {
            List<String> list = new ArrayList<>();

            for (RuneData data : requestedData) {
                list.add(data.getRuneData());
            }

            queryParams.put("runeData", StringUtils.join(list, ","));
        }
    }

    private void addRequestedSummonerSpellData(List<SummonerSpellData> requestedData, Map<String, Object> queryParams) {
        if (requestedData != null) {
            List<String> list = new ArrayList<>();

            for (SummonerSpellData data : requestedData) {
                list.add(data.getSummonerSpellData());
            }

            queryParams.put("summonerSpellData", StringUtils.join(list, ","));
        }
    }
}
