package lol4j.protocol.resource;

import lol4j.exception.InvalidRegionException;
import lol4j.protocol.dto.champion.ChampionListDto;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public interface ChampionResource {

    /**
     * Retrieve all champions
     * @param region Region where to retrieve the data
     * @param freeToPlay Retrieve only free to play champions
     * @return champions
     * @throws InvalidRegionException if region specified is invalid
     */
    ChampionListDto getAllChampions(String region, boolean freeToPlay) throws InvalidRegionException;
}
