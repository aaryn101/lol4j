package lol4j.protocol.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Aaron Corley on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RunePagesDto {
    private Set<RunePageDto> pages = new HashSet<>();
    private long summonerId;

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public Set<RunePageDto> getPages() {

        return pages;
    }
}
