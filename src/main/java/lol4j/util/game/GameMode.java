package lol4j.util.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum GameMode {
    CLASSIC ("CLASSIC"),
    ODIN ("ODIN"),
    ARAM ("ARAM"),
    TUTORIAL ("TUTORIAL"),
    ONE_FOR_ALL ("ONEFORALL"),
    FIRST_BLOOD ("FIRSTBLOOD"),
    UNKNOWN ("UNKNOWN");

    private String gameMode;

    private GameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    @JsonValue
    public String getGameMode() {
        return gameMode;
    }

    @JsonCreator
    public static GameMode create(String val) {
        GameMode[] modes = GameMode.values();
        for (GameMode mode  : modes) {
            if (mode.gameMode.equalsIgnoreCase(val)) {
                return mode;
            }
        }
        return UNKNOWN;
    }
}
