package lol4j.util.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 12/12/13.
 */
public enum Season {
    SEASON_3 ("SEASON3"),
    SEASON_4 ("SEASON4"),
    UNKNOWN ("UNKNOWN");

    private String name = null;

    Season(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @JsonCreator
    public static Season create(String val) {
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            if (season.name.equalsIgnoreCase(val)) {
                return season;
            }
        }
        return UNKNOWN;
    }
}
