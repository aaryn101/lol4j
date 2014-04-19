package lol4j.util.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum ChampData {
    ALL ("all"),
    ALLY_TIPS ("allytips"),
    ALT_IMAGES ("altimages"),
    BLURB ("blurb"),
    ENEMY_TIPS ("enemytips"),
    IMAGE ("image"),
    INFO ("info"),
    LORE ("lore"),
    PARTYPE ("partype"),
    PASSIVE ("passive"),
    RECOMMENDED ("recommended"),
    SKINS ("skins"),
    SPELLS ("spells"),
    STATS ("stats"),
    TAGS ("tags"),
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
