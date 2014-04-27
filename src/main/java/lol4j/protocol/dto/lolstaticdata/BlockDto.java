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
    private boolean recMath;
    private String type;

    public List<BlockItemDto> getItems() {
        return items;
    }

    public void setItems(List<BlockItemDto> items) {
        this.items = items;
    }

    public boolean isRecMath() {
        return recMath;
    }

    public void setRecMath(boolean recMath) {
        this.recMath = recMath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
