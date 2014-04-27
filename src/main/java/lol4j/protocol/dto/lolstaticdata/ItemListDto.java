package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 3/10/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemListDto {
    private BasicDataDto basic;
    private Map<String, BasicDataDto> data;
    private List<GroupDto> groups = new ArrayList<>();
    private List<ItemTreeDto> tree = new ArrayList<>();
    private String type;
    private String version;

    public Map<String, BasicDataDto> getData() {
        return data;
    }

    public List<GroupDto> getGroups() {
        return groups;
    }

    public List<ItemTreeDto> getTree() {
        return tree;
    }

    public BasicDataDto getBasic() {

        return basic;
    }

    public void setBasic(BasicDataDto basic) {
        this.basic = basic;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
