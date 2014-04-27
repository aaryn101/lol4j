package lol4j.protocol.dto.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lol4j.util.league.Queue;
import lol4j.util.league.Tier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 12/11/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueDto {
    private List<LeagueItemDto> entries = new ArrayList<>();
    private String name;
    private Queue queue;
    private Tier tier;
    private long timestamp;

    public List<LeagueItemDto> getEntries() {
        return entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue getQueue() {
        return queue;
    }

    public void setQueue(Queue queue) {
        this.queue = queue;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
