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
public class LolStaticDataResourceImpl extends AbstractResourceImpl implements LolStaticDataResource {
    private static final String SLASH = "/";
    private static final String RESOURCE_VERSION = "v1.2";
    private static final String CHAMPION = "champion";
    private static final String CHAMPION_URI = RESOURCE_VERSION + SLASH + CHAMPION;
    private static final String ITEM = "item";
    private static final String ITEM_URI = RESOURCE_VERSION + SLASH + ITEM;
    private static final String MASTERY = "mastery";
    private static final String MASTERY_URI = RESOURCE_VERSION + SLASH + MASTERY;
    private static final String REALM = "realm";
    private static final String REALM_URI = RESOURCE_VERSION + SLASH + REALM;
    private static final String RUNE = "rune";
    private static final String RUNE_URI = RESOURCE_VERSION + SLASH + RUNE;
    private static final String SUMMONER_SPELL = "summoner-spell";
    private static final String SUMMONER_SPELL_URI = RESOURCE_VERSION + SLASH + SUMMONER_SPELL;
    private ApiRequestManager apiRequestManager;

    public LolStaticDataResourceImpl() {
        super(
                Region.BR,
                Region.EUNE,
                Region.EUW,
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
    public ChampionListDto getChampionList(Region region, String locale, String version, List<ChampData> requestedData) {
        String path = CHAMPION_URI;
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

        return get(region, path, queryParams, true, ChampionListDto.class);
    }

    @Override
    public ChampionDto getChampion(String id, Region region, String locale, String version, List<ChampData> requestedData) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        String path = CHAMPION_URI + SLASH + id;
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

        return get(region, path, queryParams, true, ChampionDto.class);
    }

    @Override
    public BasicDataDto getItem(String id, Region region, String locale, String version, List<ItemData> requestedData) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        String path = ITEM_URI + SLASH + id;
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

        return get(region, path, queryParams, true, BasicDataDto.class);
    }

    @Override
    public ItemListDto getItemList(Region region, String locale, String version, List<ItemData> requestedData) {
        String path = ITEM_URI;
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

        return get(region, path, queryParams, true, ItemListDto.class);
    }

    @Override
    public MasteryDto getMastery(String id, Region region, String locale, String version, List<MasteryData> requestedData) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("id must not be null or empty");
        }
        String path = MASTERY_URI + SLASH + id;
        Map<String, Object> queryParams = new HashMap<>();
        buildQueryParams(locale, version, requestedData, queryParams);

        return get(region, path, queryParams, true, MasteryDto.class);
    }

    @Override
    public MasteryListDto getMasteryList(Region region, String locale, String version, List<MasteryData> requestedData) {
        String path = MASTERY_URI;
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

        return get(region, path, queryParams, true, MasteryListDto.class);
    }

    @Override
    public RealmDto getRealm(Region region) {
        String path = REALM_URI;

        return get(region, path, null, true, RealmDto.class);
    }

    @Override
    public RuneListDto getRuneList(Region region, String locale, String version, List<RuneData> requestedData) {
        String path = RUNE_URI;
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

        return get(region, path, queryParams, true, RuneListDto.class);
    }

    @Override
    public BasicDataDto getRune(String id, Region region, String locale, String version, List<RuneData> requestedData) {
        String path = RUNE_URI + SLASH + id;
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

        return get(region, path, queryParams, true, BasicDataDto.class);
    }

    @Override
    public SummonerSpellListDto getSummonerSpellList(Region region, String locale, String version, List<SummonerSpellData> requestedData) {
        String path = SUMMONER_SPELL_URI;
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

        return get(region, path, queryParams, true, SummonerSpellListDto.class);
    }

    @Override
    public SummonerSpellDto getSummonerSpell(int id, Region region, String locale, String version, List<SummonerSpellData> requestedData) {
        String path = SUMMONER_SPELL_URI + SLASH + id;
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

        return get(region, path, queryParams, true, SummonerSpellDto.class);
    }

    public void setApiRequestManager(ApiRequestManager apiRequestManager) {
        this.apiRequestManager = apiRequestManager;
    }

    @Override
    public ApiRequestManager getApiRequestManager(Region region) {
        return apiRequestManager;
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
}
