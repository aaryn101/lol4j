package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 3/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecommendedDto {
    private List<BlockDto> blocks = new ArrayList<>();
    private String champion;
    private String map;
    private String mode;
    private boolean priority;
    private String title;
    private String type;

    public List<BlockDto> getBlocks() {
        return blocks;
    }

    public String getChampion() {

        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
