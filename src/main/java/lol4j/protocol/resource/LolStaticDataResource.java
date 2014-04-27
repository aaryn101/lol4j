package lol4j.protocol.resource;

import lol4j.protocol.dto.lolstaticdata.*;
import lol4j.util.Region;
import lol4j.util.lolstaticdata.*;

import java.util.List;

/**
 * Created by Aaron Corley on 3/9/14.
 */
public interface LolStaticDataResource {
    ChampionListDto getChampionList(Region region, String locale, String version, List<ChampData> requestedData);

    ChampionDto getChampion(String id, Region region, String locale, String version, List<ChampData> requestedData);

    BasicDataDto getItem(String id, Region region, String locale, String version, List<ItemData> requestedData);

    ItemListDto getItemList(Region region, String locale, String version, List<ItemData> requestedData);

    MasteryDto getMastery(String id, Region region, String locale, String version, List<MasteryData> requestedData);

    MasteryListDto getMasteryList(Region region, String locale, String version, List<MasteryData> requestedData);

    RealmDto getRealm(Region region);

    RuneListDto getRuneList(Region region, String locale, String version, List<RuneData> requestedData);

    BasicDataDto getRune(String id, Region region, String locale, String version, List<RuneData> requestedData);

    SummonerSpellListDto getSummonerSpellList(Region region, String locale, String version, List<SummonerSpellData> requestedData);

    SummonerSpellDto getSummonerSpell(String id, Region region, String locale, String version, List<SummonerSpellData> requestedData);
}
