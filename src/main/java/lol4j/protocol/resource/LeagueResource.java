package lol4j.protocol.resource;

import lol4j.protocol.dto.league.LeagueDto;
import lol4j.protocol.dto.league.LeagueEntryDto;
import lol4j.util.Region;
import lol4j.util.game.SubType;

import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 12/11/13.
 */
public interface LeagueResource {
    LeagueDto getChallengerLeague(Region region, SubType gameType);

    List<LeagueDto> getLeaguesData(long summonerId, Region region);

    Map<String, List<LeagueDto>> getLeaguesData(List<Long> summonerIds, Region region);

    List<LeagueEntryDto> getLeaguesEntryData(long summonerId, Region region);

    Map<String, List<LeagueEntryDto>> getLeaguesEntryData(List<Long> summonerIds, Region region);

    List<LeagueDto> getLeaguesDataByTeam(String teamId, Region region);

    Map<String, List<LeagueDto>> getLeaguesDataByTeam(List<String> teamIds, Region region);

    List<LeagueEntryDto> getLeaguesEntryDataByTeam(String teamId, Region region);

    Map<String, List<LeagueEntryDto>> getLeaguesEntryDataByTeam(List<String> teamIds, Region region);

}
