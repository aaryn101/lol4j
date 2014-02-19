package lol4j.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 2/10/14.
 */
public enum SubType {
    NONE,
    NORMAL,
    NORMAL_3x3,
    ODIN_UNRANKED,
    ARAM_UNRANKED_5x5,
    BOT,
    BOT_3x3,
    RANKED_SOLO_5x5,
    RANKED_TEAM_3x3,
    RANKED_TEAM_5x5,
    ONEFORALL_5x5,
    FIRSTBLOOD_1x1,
    FIRSTBLOOD_2x2;

    private static final List<SubType> challengerSubTypes = new ArrayList<>();
    static {
        challengerSubTypes.add(RANKED_SOLO_5x5);
        challengerSubTypes.add(RANKED_TEAM_3x3);
        challengerSubTypes.add(RANKED_TEAM_5x5);
    }

    public static List<SubType> getChallengerSubTypes() {
        return challengerSubTypes;
    }
}
