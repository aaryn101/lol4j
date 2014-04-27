package lol4j.protocol.resource;

import lol4j.protocol.dto.champion.ChampionDto;
import lol4j.protocol.dto.champion.ChampionListDto;
import lol4j.util.Region;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public interface ChampionResource {

    /**
     * Retrieve all champions
     * @param region Region where to retrieve the data
     * @param freeToPlay Retrieve only free to play champions
     * @return champions
     * @if region specified is invalid
     */
    ChampionListDto getAllChampions(Region region, boolean freeToPlay);

    /**
     * Retrieve a specific champion
     * @param region Region where to retrieve the data
     * @param id The champion id
     * @return champion
     */
    ChampionDto getChampion(Region region, int id);
}
