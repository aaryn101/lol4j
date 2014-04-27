package lol4j.util.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum MasteryData {
    ALL ("all"),
    RANKS ("ranks"),
    PREREQ ("prereq"),
    IMAGE ("image"),
    UNKNOWN ("unknown");

    private String masteryData;

    private MasteryData(String masteryData) {
        this.masteryData = masteryData;
    }

    @JsonValue
    public String getMasteryData() {
        return masteryData;
    }

    @JsonCreator
    public static MasteryData create(String val) {
        MasteryData[] values = MasteryData.values();
        for (MasteryData value : values) {
            if (value.getMasteryData().equalsIgnoreCase(val)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
