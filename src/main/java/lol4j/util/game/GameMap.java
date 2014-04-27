package lol4j.util.game;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum GameMap {
    SUMMONERS_RIFT (1),
    SUMMONERS_RIFT_AUTUMN (2),
    THE_PROVING_GROUNDS (3),
    TWISTED_TREELINE_ORIGINAL (4),
    THE_CRYSTAL_SCAR (8),
    TWISTED_TREELINE (10),
    HOWLING_ABYSS (12),
    UNKNOWN (-42);

    private int mapId;

    private GameMap(int mapId) {
        this.mapId = mapId;
    }

    @JsonValue
    public int getMapId() {
        return mapId;
    }

    @JsonCreator
    public static GameMap create(int val) {
        GameMap[] gameMaps = GameMap.values();
        for (GameMap gameMap : gameMaps) {
            if (gameMap.getMapId() == val) {
                return gameMap;
            }
        }
        return UNKNOWN;
    }
}
