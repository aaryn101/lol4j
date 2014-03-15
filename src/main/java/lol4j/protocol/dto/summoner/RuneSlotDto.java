package lol4j.protocol.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lol4j.util.summoner.RuneSlot;

/**
 * Created by Aaron Corley on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneSlotDto {
    private RuneDto rune;
    @JsonProperty("runeSlotId")
    private RuneSlot runeSlot;

    public RuneDto getRune() {
        return rune;
    }

    public void setRune(RuneDto rune) {
        this.rune = rune;
    }

    public RuneSlot getRuneSlot() {
        return runeSlot;
    }

    public void setRuneSlot(RuneSlot runeSlot) {
        this.runeSlot = runeSlot;
    }
}
