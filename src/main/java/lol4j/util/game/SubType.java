package lol4j.util.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum SubType {
    NONE ("NONE"),
    NORMAL ("NORMAL"),
    NORMAL_3X3 ("NORMAL_3x3"),
    ODIN_UNRANKED ("ODIN_UNRANKED"),
    ARAM_UNRANKED_5X5 ("ARAM_UNRANKED_5x5"),
    BOT ("BOT"),
    BOT_3X3 ("BOT_3x3"),
    RANKED_SOLO_5X5 ("RANKED_SOLO_5x5"),
    RANKED_TEAM_3X3 ("RANKED_TEAM_3x3"),
    RANKED_TEAM_5X5 ("RANKED_TEAM_5x5"),
    ONE_FOR_ALL_5X5 ("ONEFORALL_5x5"),
    FIRST_BLOOD_1X1 ("FIRSTBLOOD_1x1"),
    FIRST_BLOOD_2X2 ("FIRSTBLOOD_2x2"),
    SUMMONERS_RIFT_6X6 ("SR_6x6"),
    UNKNOWN ("UNKNOWN");

    private String subType;

    private SubType(String subType) {
        this.subType = subType;
    }

    private static final List<SubType> challengerSubTypes = new ArrayList<>();
    static {
        challengerSubTypes.add(RANKED_SOLO_5X5);
        challengerSubTypes.add(RANKED_TEAM_3X3);
        challengerSubTypes.add(RANKED_TEAM_5X5);
    }

    public static List<SubType> getChallengerSubTypes() {
        return challengerSubTypes;
    }

    @JsonValue
    public String getSubType() {
        return subType;
    }

    @JsonCreator
    public static SubType create(String val) {
        SubType[] subTypes = SubType.values();
        for (SubType subType : subTypes) {
            if (subType.subType.equalsIgnoreCase(val)) {
                return subType;
            }
        }
        return UNKNOWN;
    }
}
