package lol4j.protocol.dto.stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lol4j.util.StatSummaryType;

/**
 * Created by Aaryn101 on 12/11/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatsSummaryDto {
    private AggregatedStatDto aggregatedStats;
    private int losses;
    private long modifyDate;
    private StatSummaryType playerStatSummaryType;
    private int wins;

    public AggregatedStatDto getAggregatedStats() {
        return aggregatedStats;
    }

    public void setAggregatedStats(AggregatedStatDto aggregatedStats) {
        this.aggregatedStats = aggregatedStats;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public long getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }

    public StatSummaryType getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    public void setPlayerStatSummaryType(StatSummaryType playerStatSummaryType) {
        this.playerStatSummaryType = playerStatSummaryType;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
