package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 3/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LevelTipDto {
    private List<String> effect = new ArrayList<>();
    private List<String> label = new ArrayList<>();

    public List<String> getEffect() {
        return effect;
    }

    public List<String> getLabel() {
        return label;
    }
}
