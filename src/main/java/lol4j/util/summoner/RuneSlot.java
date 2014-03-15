package lol4j.util.summoner;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum RuneSlot {
    MARK_1 (1),
    MARK_2 (2),
    MARK_3 (3),
    MARK_4 (4),
    MARK_5 (5),
    MARK_6 (6),
    MARK_7 (7),
    MARK_8 (8),
    MARK_9 (9),
    SEAL_1 (10),
    SEAL_2 (11),
    SEAL_3 (12),
    SEAL_4 (13),
    SEAL_5 (14),
    SEAL_6 (15),
    SEAL_7 (16),
    SEAL_8 (17),
    SEAL_9 (18),
    GLYPH_1 (19),
    GLYPH_2 (20),
    GLYPH_3 (21),
    GLYPH_4 (22),
    GLYPH_5 (23),
    GLYPH_6 (24),
    GLYPH_7 (25),
    GLYPH_8 (26),
    GLYPH_9 (27),
    QUINTESSENCE_1 (28),
    QUINTESSENCE_2 (29),
    QUINTESSENCE_3 (30),
    UNKNOWN (-42);

    private int runeSlotId;

    RuneSlot(int runeSlotId) {
        this.runeSlotId = runeSlotId;
    }

    @JsonValue
    public int getRuneSlotId() {
        return runeSlotId;
    }

    @JsonCreator
    public static RuneSlot create(int val) {
        RuneSlot[] runeSlots = RuneSlot.values();
        for (RuneSlot runeSlot : runeSlots) {
            if (runeSlot.getRuneSlotId() == val) {
                return runeSlot;
            }
        }
        return UNKNOWN;
    }
}
