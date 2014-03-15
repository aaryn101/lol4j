package lol4j.protocol.dto.stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaron Corley on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionStatsDto {
    private int id;
    private String name;
    private AggregatedStatDto stats;

    public AggregatedStatDto getStats() {
        return stats;
    }

    public void setStats(AggregatedStatDto stats) {
        this.stats = stats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
