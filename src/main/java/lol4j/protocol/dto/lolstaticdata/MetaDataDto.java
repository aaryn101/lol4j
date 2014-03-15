package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Aaron Corley on 3/10/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MetaDataDto {
    @JsonProperty("isRune")
    private boolean rune;
    private String tier;
    private String type;

    public boolean isRune() {
        return rune;
    }

    public void setRune(boolean rune) {
        this.rune = rune;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
