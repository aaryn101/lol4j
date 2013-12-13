package lol4j.protocol.dto.champion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 12/10/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionListDto {
    private List<ChampionDto> champions = new ArrayList<>();

    public List<ChampionDto> getChampions() {
        return champions;
    }
}
