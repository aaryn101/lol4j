package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Corley on 3/18/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneListDto {
    private BasicDataDto basic;
    private Map<String, BasicDataDto> data = new HashMap<>();
    private String type;
    private String version;

    public BasicDataDto getBasic() {
        return basic;
    }

    public void setBasic(BasicDataDto basic) {
        this.basic = basic;
    }

    public Map<String, BasicDataDto> getData() {
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
