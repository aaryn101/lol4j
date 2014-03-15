package lol4j.util.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum ChampData {
    ALL ("all"),
    IMAGE ("image"),
    SKINS ("skins"),
    LORE ("lore"),
    BLURB ("blurb"),
    ALLY_TIPS ("allytips"),
    ENEMY_TIPS ("enemytips"),
    TAGS ("tags"),
    PARTYPE ("partype"),
    INFO ("info"),
    STATS ("stats"),
    SPELLS ("spells"),
    PASSIVE ("passive"),
    RECOMMENDED ("recommended"),
    UNKNOWN ("unknown");

    private String champData;

    private ChampData(String champData) {
        this.champData = champData;
    }

    @JsonValue
    public String getChampData() {
        return champData;
    }

    @JsonCreator
    public static ChampData create(String val) {
        ChampData[] values = ChampData.values();
        for (ChampData value : values) {
            if (value.getChampData().equalsIgnoreCase(val)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
