package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 3/10/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasteryTreeDto {
    @JsonProperty("Defense")
    private List<MasteryTreeListDto> defense = new ArrayList<>();
    @JsonProperty("Offense")
    private List<MasteryTreeListDto> offense = new ArrayList<>();
    @JsonProperty("Utility")
    private List<MasteryTreeListDto> utility = new ArrayList<>();

    public List<MasteryTreeListDto> getDefense() {
        return defense;
    }

    public List<MasteryTreeListDto> getOffense() {
        return offense;
    }

    public List<MasteryTreeListDto> getUtility() {
        return utility;
    }
}
