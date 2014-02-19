package lol4j.protocol.dto.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aaryn101 on 12/13/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatSummaryDto {
    private String fullId;
    private Set<TeamStatDetailDto> teamStatDetails = new HashSet<>();

    public Set<TeamStatDetailDto> getTeamStatDetails() {
        return teamStatDetails;
    }

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }
}
