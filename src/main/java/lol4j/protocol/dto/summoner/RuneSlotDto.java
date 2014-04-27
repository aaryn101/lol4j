package lol4j.protocol.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lol4j.util.summoner.RuneSlot;

/**
 * Created by Aaron Corley on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneSlotDto {
    private int runeId;
    @JsonProperty("runeSlotId")
    private RuneSlot runeSlot;

    public RuneSlot getRuneSlot() {
        return runeSlot;
    }

    public void setRuneSlot(RuneSlot runeSlot) {
        this.runeSlot = runeSlot;
    }

    public int getRuneId() {
        return runeId;
    }

    public void setRuneId(int runeId) {
        this.runeId = runeId;
    }
}
