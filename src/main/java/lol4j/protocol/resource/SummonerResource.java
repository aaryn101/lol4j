package lol4j.protocol.resource;

import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.protocol.dto.summoner.RunePagesDto;
import lol4j.protocol.dto.summoner.SummonerDto;
import lol4j.util.Region;

import java.util.List;
import java.util.Map;

/**
 * Created by Aaryn101 on 12/12/13.
 */
public interface SummonerResource {
    Map<String, MasteryPagesDto> getMasteryPages(Region region, List<Long> summonerIds);

    MasteryPagesDto getMasteryPages(Region region, long summonerId);

    Map<String, RunePagesDto> getRunePages(Region region, List<Long> summonerIds);

    RunePagesDto getRunePages(Region region, long summonerId);

    Map<String, SummonerDto> getSummonersByName(Region region, List<String> names);

    SummonerDto getSummonerByName(Region region, String name);

    Map<String, SummonerDto> getSummoners(Region region, List<Long> summonerIds);

    SummonerDto getSummoner(Region region, long summonerId);

    Map<String, String> getSummonerNames(Region region, List<Long> summonerIds);

    String getSummonerName(Region region, long summonerId);
}
