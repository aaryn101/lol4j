package lol4j.protocol.resource.impl;

import lol4j.protocol.dto.team.TeamDto;
import lol4j.protocol.resource.TeamResource;
import lol4j.util.Region;

import java.util.List;

/**
 * Created by Aaryn101 on 12/13/13.
 */
public class TeamResourceImpl extends AbstractResourceImpl implements TeamResource {
    private static final String RESOURCE_VERSION = "v2.1";
    private static final String RESOURCE_PATH = "team";
    private static final String SLASH = "/";
    private static final String RESOURCE_URI = RESOURCE_VERSION + SLASH + RESOURCE_PATH;
    private static final String BY_SUMMONER = "by-summoner";

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
}
