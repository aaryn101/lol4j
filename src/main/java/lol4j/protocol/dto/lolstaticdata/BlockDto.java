package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 3/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockDto {
    private List<BlockItemDto> items = new ArrayList<>();
    private String type;

    public void setType(String type) {
        this.type = type;
    }

    public List<BlockItemDto> getItems() {

        return items;
    }

    public String getType() {
        return type;
    }
}
