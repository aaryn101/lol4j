package lol4j.protocol.dto.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aaryn101 on 12/13/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatSummaryDto {
    private TeamIdDto teamId;
    private Set<TeamStatDetailDto> teamStatDetails = new HashSet<>();

    public Set<TeamStatDetailDto> getTeamStatDetails() {
        return teamStatDetails;
    }

    public TeamIdDto getTeamId() {

        return teamId;
    }

    public void setTeamId(TeamIdDto teamId) {
        this.teamId = teamId;
    }
}
