package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Corley on 3/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionListDto {
    private Map<String, ChampionDto> data = new HashMap<>();
    private String format;
    private Map<String, String> keys = new HashMap<>();
    private String type;
    private String version;

    public Map<String, ChampionDto> getData() {
        return data;
    }

    public Map<String, String> getKeys() {
        return keys;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
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
