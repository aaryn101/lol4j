package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.lolstaticdata.*;
import lol4j.protocol.resource.ItemListDto;
import lol4j.protocol.resource.LolStaticDataResource;
import lol4j.util.Region;
import lol4j.util.lolstaticdata.ChampData;
import lol4j.util.lolstaticdata.ItemData;
import lol4j.util.lolstaticdata.MasteryData;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 3/9/14.
 */
public class LolStaticDataResourceImpl extends AbstractResourceImpl implements LolStaticDataResource {
    private static final String RESOURCE_VERSION = "v1";
    private static final String RESOURCE_PATH = "static-data";
    private static final String CHAMPION = "champion";
    private static final String ITEM = "item";
    private static final String MASTERY = "mastery";
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
    public ItemDto getItem(String id, Region region, String locale, String version, List<ItemData> requestedData) {
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

        return getApiRequestManager().get(path, queryParams, true, ItemDto.class);
    }

    @Override
    public ItemListDto getItems(Region region, String locale, String version, List<ItemData> requestedData) {
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

        return getApiRequestManager().get(path, queryParams, true, MasteryDto.class);
    }

    @Override
    public MasteryListDto getMasteries(Region region, String locale, String version, List<MasteryData> requestedData) {
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
}
