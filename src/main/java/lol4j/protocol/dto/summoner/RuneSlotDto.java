package lol4j.protocol.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaryn101 on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneSlotDto {
    private RuneDto rune;
    private int runeSlotId;

    public RuneDto getRune() {
        return rune;
    }

    public void setRune(RuneDto rune) {
        this.rune = rune;
    }

    public int getRuneSlotId() {
        return runeSlotId;
    }

    public void setRuneSlotId(int runeSlotId) {
        this.runeSlotId = runeSlotId;
    }
}
