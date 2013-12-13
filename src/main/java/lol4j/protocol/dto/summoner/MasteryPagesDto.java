package lol4j.protocol.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasteryPagesDto {
    private List<MasteryPageDto> pages = new ArrayList<>();
    private long summonerId;

    public List<MasteryPageDto> getPages() {
        return pages;
    }

    public long getSummonerId() {

        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}
