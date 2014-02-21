package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.team.TeamDto;
import lol4j.protocol.resource.TeamResource;
import lol4j.util.Region;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Compatible with team-v2.2
 */
public class TeamResourceImpl extends AbstractResourceImpl implements TeamResource {
    private static final String RESOURCE_VERSION = "v2.2";
    private static final String RESOURCE_PATH = "team";
    private static final String SLASH = "/";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;
    private static final String BY_SUMMONER = "by-summoner";
    public static final int MAX_LIST_SIZE = 40;

    public TeamResourceImpl() {
        getSupportedRegions().add(Region.TR);
        getSupportedRegions().add(Region.NA);
        getSupportedRegions().add(Region.EUNE);
        getSupportedRegions().add(Region.EUW);
        getSupportedRegions().add(Region.BR);
    }

    @Override
    public List<TeamDto> getTeams(Region region, long summonerId) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + BY_SUMMONER + SLASH + summonerId;

        return getApiRequestManager().getList(getBaseUri(), path, null, TeamDto.class);
    }

    @Override
    public TeamDto getTeam(Region region, String teamId) {
        doSupportedRegionCheck(region);
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + teamId;
        Map<String, TeamDto> result =
                getApiRequestManager().getMap(getBaseUri(), path, null, String.class, TeamDto.class);

        return result.get(teamId);
    }

    @Override
    public Map<String, TeamDto> getTeams(Region region, List<String> teamIds) {
        doSupportedRegionCheck(region);
        if (teamIds == null || teamIds.size() > MAX_LIST_SIZE || teamIds.size() == 0) {
            throw new IllegalArgumentException("teamIds list must have at least one entry and no more than " +
                    MAX_LIST_SIZE + " entries");
        }
        String path = region.getName() + SLASH + RESOURCE_URI + SLASH + StringUtils.join(teamIds, ',');

        return getApiRequestManager().getMap(getBaseUri(), path, null, String.class, TeamDto.class);
    }
}
