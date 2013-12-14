package lol4j.protocol.resource;

import lol4j.protocol.dto.summoner.MasteryPagesDto;
import lol4j.protocol.dto.summoner.RunePagesDto;
import lol4j.protocol.dto.summoner.SummonerDto;
import lol4j.protocol.dto.summoner.SummonerNameListDto;
import lol4j.util.Region;

import java.util.List;

/**
 * Created by Aaryn101 on 12/12/13.
 */
public interface SummonerResource {
    MasteryPagesDto getMasteryPages(Region region, long summonerId);

    RunePagesDto getRunePages(Region region, long summonerId);

    SummonerDto getSummoner(Region region, String name);

    SummonerDto getSummoner(Region region, long summonerId);

    SummonerNameListDto getSummonerNames(Region region, List<Long> summonerIds);
}
