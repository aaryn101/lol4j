package lol4j.protocol.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaron Corley on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasteryDto {
    private int id;
    private int rank;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
