package lol4j.protocol.dto.stats;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public class PlayerStatsSummaryDto {
    private List<AggregatedStatDto> aggregatedStats = new ArrayList<>();
    private int losses;
    private long modifyDate;
    private Date modifyDateStr;
    private String playerStatSummaryType;
    private int wins;

    public List<AggregatedStatDto> getAggregatedStats() {
        return aggregatedStats;
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

    public Date getModifyDateStr() {
        return modifyDateStr;
    }

    public void setModifyDateStr(Date modifyDateStr) {
        this.modifyDateStr = modifyDateStr;
    }

    public String getPlayerStatSummaryType() {
        return playerStatSummaryType;
    }

    public void setPlayerStatSummaryType(String playerStatSummaryType) {
        this.playerStatSummaryType = playerStatSummaryType;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
