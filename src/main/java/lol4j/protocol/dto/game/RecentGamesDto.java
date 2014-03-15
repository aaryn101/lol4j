package lol4j.protocol.dto.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 12/10/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecentGamesDto {
    private List<GameDto> games = new ArrayList<>();
    private long summonerId;

    public List<GameDto> getGames() {
        return games;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
