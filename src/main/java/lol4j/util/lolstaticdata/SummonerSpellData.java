package lol4j.util.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 3/18/14.
 */
public enum SummonerSpellData {
    ALL ("all"),
    COOLDOWN ("cooldown"),
    COOLDOWN_BURN ("cooldownBurn"),
    COST ("cost"),
    COST_BURN ("costBurn"),
    COST_TYPE ("costType"),
    EFFECT ("effect"),
    EFFECT_BURN ("effectBurn"),
    IMAGE ("image"),
    KEY ("key"),
    LEVEL_TIP ("leveltip"),
    MAX_RANK ("maxrank"),
    MODES ("modes"),
    RANGE ("range"),
    RANGE_BURN ("rangeBurn"),
    RESOURCE ("resource"),
    SANITIZED_DESCRIPTION ("sanitizedDescription"),
    SANITIZED_TOOLTIP ("sanitizedTooltip"),
    VARS ("vars"),
    UNKNOWN ("unknown");

    private String summonerSpellData;

    private SummonerSpellData(String summonerSpellData) {
        this.summonerSpellData = summonerSpellData;
    }

    @JsonValue
    public String getSummonerSpellData() {
        return summonerSpellData;
    }

    @JsonCreator
    public static SummonerSpellData create(String val) {
        SummonerSpellData[] values = SummonerSpellData.values();
        for (SummonerSpellData value : values) {
            if (value.summonerSpellData.equalsIgnoreCase(val)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
