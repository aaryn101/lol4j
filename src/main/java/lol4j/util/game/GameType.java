package lol4j.util.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum GameType {
    CUSTOM_GAME ("CUSTOM_GAME"),
    TUTORIAL_GAME ("TUTORIAL_GAME"),
    MATCHED_GAME ("MATCHED_GAME"),
    UNKNOWN ("UNKNOWN");

    private String gameType;

    private GameType(String gameType) {
        this.gameType = gameType;
    }

    @JsonValue
    public String getGameType() {
        return gameType;
    }

    @JsonCreator
    public static GameType create(String val) {
        GameType[] types = GameType.values();
        for (GameType type : types) {
            if (type.gameType.equalsIgnoreCase(val)) {
                return type;
            }
        }
        return UNKNOWN;
    }
}
