package lol4j.util.stats;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/11/14.
 */
public enum StatSummaryType {
    ARAM_UNRANKED_5X5 ("AramUnranked5x5"),
    COOP_VS_AI ("CoopVsAI"),
    COOP_VS_AI_3X3 ("CoopVsAI3x3"),
    ODIN_UNRANKED ("OdinUnranked"),
    RANKED_PREMADE_3X3 ("RankedPremade3x3"),
    RANKED_PREMADE_5X5 ("RankedPremade5x5"),
    RANKED_SOLO_5X5 ("RankedSolo5x5"),
    RANKED_TEAM_3X3 ("RankedTeam3x3"),
    RANKED_TEAM_5X5 ("RankedTeam5x5"),
    UNRANKED ("Unranked"),
    UNRANKED_3X3 ("Unranked3x3"),
    ONE_FOR_ALL_5X5 ("OneForAll5x5"),
    FIRST_BLOOD_1X1 ("FirstBlood1x1"),
    FIRST_BLOOD_2X2 ("FirstBlood2x2"),
    SUMMONERS_RIFT_6X6 ("SummonersRift6x6"),
    UNKNOWN ("Unknown");

    private String statSummaryType;

    private StatSummaryType(String statSummaryType) {
        this.statSummaryType = statSummaryType;
    }

    @JsonValue
    public String getStatSummaryType() {
        return statSummaryType;
    }

    @JsonCreator
    public static StatSummaryType create(String val) {
        StatSummaryType[] types = StatSummaryType.values();

        for (StatSummaryType type : types) {
            if (type.statSummaryType.equalsIgnoreCase(val)) {
                return type;
            }
        }

        return UNKNOWN;
    }
}
