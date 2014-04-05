package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Aaron Corley on 3/10/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDto {
    @JsonProperty("MaxGroupOwnable")
    private String maxGroupOwnable;
    private String id;

    public String getMaxGroupOwnable() {
        return maxGroupOwnable;
    }

    public void setMaxGroupOwnable(String maxGroupOwnable) {
        this.maxGroupOwnable = maxGroupOwnable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
