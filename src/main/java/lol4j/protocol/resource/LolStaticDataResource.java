package lol4j.protocol.resource;

import lol4j.protocol.dto.lolstaticdata.*;
import lol4j.util.Region;
import lol4j.util.lolstaticdata.ChampData;
import lol4j.util.lolstaticdata.ItemData;
import lol4j.util.lolstaticdata.MasteryData;

import java.util.List;

/**
 * Created by Aaron Corley on 3/9/14.
 */
public interface LolStaticDataResource {
    ChampionListDto getChampionList(Region region, String locale, String version, List<ChampData> requestedData);

    ChampionDto getChampion(String id, Region region, String locale, String version, List<ChampData> requestedData);

    ItemDto getItem(String id, Region region, String locale, String version, List<ItemData> requestedData);

    ItemListDto getItems(Region region, String locale, String version, List<ItemData> requestedData);

    MasteryDto getMastery(String id, Region region, String locale, String version, List<MasteryData> requestedData);

    MasteryListDto getMasteries(Region region, String locale, String version, List<MasteryData> requestedData);
}
