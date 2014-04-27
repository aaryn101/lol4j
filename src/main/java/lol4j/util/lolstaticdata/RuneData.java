package lol4j.util.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 3/18/14.
 */
public enum RuneData {
    ALL ("all"),
    BASIC ("basic"),
    COLLOQ ("colloq"),
    CONSUME_ON_FULL ("consumeOnFull"),
    UNKNOWN ("unknown");

    private String runeData;

    private RuneData(String runeData) {
        this.runeData = runeData;
    }

    @JsonValue
    public String getRuneData() {
        return runeData;
    }

    @JsonCreator
    public static RuneData create(String val) {
        RuneData[] values = RuneData.values();
        for (RuneData value : values) {
            if (value.runeData.equalsIgnoreCase(val)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
