package lol4j.protocol.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 12/13/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerNameListDto {
    private List<SummonerNameDto> summoners = new ArrayList<>();

    public List<SummonerNameDto> getSummoners() {
        return summoners;
    }
}
