package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.team.TeamDto;
import lol4j.protocol.resource.TeamResource;
import lol4j.util.Region;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.GenericType;
import java.util.List;
import java.util.Map;

/**
 * Compatible with team-v2.4
 */
public class TeamResourceImpl extends ApiResource implements TeamResource {
    private static final String VERSION = "v2.4";
    private static final String NAME = "team";
    private static final String BY_SUMMONER = "by-summoner";
    public static final int MAX_LIST_SIZE = 40;

    public TeamResourceImpl() {
        super(
                NAME,
                VERSION,
                Region.BR,
                Region.EUNE,
                Region.EUW,
                Region.EUNE,
                Region.LAN,
                Region.LAS,
                Region.NA,
                Region.OCE,
                Region.RU,
                Region.TR
        );
    }

    @Override
    public List<TeamDto> getTeamsBySummonerId(long summonerId, Region region) {
        String path = BY_SUMMONER + SLASH + summonerId;
        Map<String, List<TeamDto>> map = get(region, path, null, false, new GenericType<Map<String, List<TeamDto>>>() {});

        return map.get(Long.toString(summonerId));
    }

    @Override
    public Map<String, List<TeamDto>> getTeamsBySummonerId(List<Long> summonerIds, Region region) {
        if (summonerIds == null || summonerIds.size() > MAX_LIST_SIZE || summonerIds.isEmpty()) {
            throw new IllegalArgumentException("summonerIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String path = BY_SUMMONER + SLASH + StringUtils.join(summonerIds, ',');

        return get(region, path, null, false, new GenericType<Map<String, List<TeamDto>>>() {});
    }

    @Override
    public TeamDto getTeam(String teamId, Region region) {
        if (StringUtils.isEmpty(teamId)) {
            throw new IllegalArgumentException("team must not be null or empty");
        }

        Map<String, TeamDto> result = get(region, teamId, null, false, new GenericType<Map<String, TeamDto>>() {});

        return result.get(teamId);
    }

    @Override
    public Map<String, TeamDto> getTeams(List<String> teamIds, Region region) {
        if (teamIds == null || teamIds.size() > MAX_LIST_SIZE || teamIds.isEmpty()) {
            throw new IllegalArgumentException("teamIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }

        String path = StringUtils.join(teamIds, ',');

        return get(region, path, null, false, new GenericType<Map<String, TeamDto>>() {});
    }
}
