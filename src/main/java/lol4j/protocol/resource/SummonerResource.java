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
    MasteryPagesDto getMasteryPages(Region region, List<Long> summonerIds);

    Map<String, RunePagesDto> getRunePages(Region region, List<Long> summonerIds);

    Map<String, SummonerDto> getSummonersByName(Region region, List<String> names);

    Map<String, SummonerDto> getSummoners(Region region, List<Long> summonerIds);

    Map<String, String> getSummonerNames(Region region, List<Long> summonerIds);
}
