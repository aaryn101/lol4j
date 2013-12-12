package lol4j.protocol.dto.league;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public class LeagueDto {
    private List<LeagueItemDto> entries = new ArrayList<>();
    private String name;
    private String queue;
    private String tier;
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

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
