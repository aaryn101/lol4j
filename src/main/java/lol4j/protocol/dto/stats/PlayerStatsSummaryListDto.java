package lol4j.protocol.dto.stats;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public class PlayerStatsSummaryListDto {
    private List<PlayerStatsSummaryDto> playerStatSummaries = new ArrayList<>();
    private long summonerId;

    public List<PlayerStatsSummaryDto> getPlayerStatSummaries() {
        return playerStatSummaries;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
