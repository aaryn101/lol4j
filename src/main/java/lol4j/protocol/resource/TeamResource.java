package lol4j.protocol.resource;

import lol4j.protocol.dto.team.TeamDto;
import lol4j.util.Region;

import java.util.List;

/**
 * Created by Aaryn101 on 12/13/13.
 */
public interface TeamResource {
    List<TeamDto> getTeams(Region region, long summonerId);
}
