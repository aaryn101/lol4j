package lol4j.protocol.resource;

import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueItemDto;
import lol4j.util.Region;
import lol4j.util.SubType;

import java.util.List;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public interface LeagueResource {
    LeagueDto getChallengerLeague(Region region, SubType gameType);
    List<LeagueDto> getLeaguesData(Region region, long summonerId);
    List<LeagueItemDto> getLeaguesEntryData(Region region, long summonerId);
}
