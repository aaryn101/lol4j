package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Corley on 4/5/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerSpellListDto {
    private Map<String, SummonerSpellDto> data = new HashMap<>();
    private String type;
    private String version;

    public Map<String, SummonerSpellDto> getData() {
        return data;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
