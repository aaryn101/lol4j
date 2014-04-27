package lol4j.protocol.resource;

import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueItemDto;
import lol4j.util.Region;
import lol4j.util.game.SubType;

import java.util.List;

/**
 * Created by Aaron Corley on 12/11/13.
 */
public interface LeagueResource {
    LeagueDto getChallengerLeague(Region region, SubType gameType);

    List<LeagueDto> getLeaguesData(long summonerId, Region region);

    List<LeagueItemDto> getLeaguesEntryData(long summonerId, Region region);

}
