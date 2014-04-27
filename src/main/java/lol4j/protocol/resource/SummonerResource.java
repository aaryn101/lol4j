package lol4j.protocol.resource;

import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.protocol.dto.summoner.RunePagesDto;
import lol4j.protocol.dto.summoner.SummonerDto;
import lol4j.util.Region;

import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 12/12/13.
 */
public interface SummonerResource {
    Map<String, MasteryPagesDto> getMasteryPages(List<Long> summonerIds, Region region);

    MasteryPagesDto getMasteryPages(long summonerId, Region region);

    Map<String, RunePagesDto> getRunePages(List<Long> summonerIds, Region region);

    RunePagesDto getRunePages(long summonerId, Region region);

    Map<String, SummonerDto> getSummonersByName(List<String> names, Region region);

    SummonerDto getSummonerByName(String name, Region region);

    Map<String, SummonerDto> getSummoners(List<Long> summonerIds, Region region);

    SummonerDto getSummoner(long summonerId, Region region);

    Map<String, String> getSummonerNames(List<Long> summonerIds, Region region);

    String getSummonerName(long summonerId, Region region);
}
