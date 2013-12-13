package lol4j.protocol.dto.stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aaryn101 on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RankedStatsDto {
    private List<ChampionStatsDto> champions = new ArrayList<>();
    private long modifyDate;
    private Date modifyDateStr;
    private long summonerId;

    public List<ChampionStatsDto> getChampions() {
        return champions;
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

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
