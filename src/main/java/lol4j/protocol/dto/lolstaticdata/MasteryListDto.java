package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aaron Corley on 3/10/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasteryListDto {
    private Map<String, MasteryDto> data = new HashMap<>();
    private MasteryTreeDto tree;
    private String type;
    private String version;

    public Map<String, MasteryDto> getData() {
        return data;
    }

    public MasteryTreeDto getTree() {

        return tree;
    }

    public void setTree(MasteryTreeDto tree) {
        this.tree = tree;
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
