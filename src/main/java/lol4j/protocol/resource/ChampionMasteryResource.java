package lol4j.protocol.resource;

import lol4j.protocol.dto.champion.ChampionMasteryDto;
import lol4j.util.Region;

import java.util.List;

/**
 * Created by Aaron Corley on 11/23/16.
 */
public interface ChampionMasteryResource {
    /**
     * Get a champion mastery by summoner id and champion id
     * @param region Region where to retrieve the data
     * @param summonerId The summoner id
     * @param championId The champion id
     * @return The champion mastery
     */
    ChampionMasteryDto getChampionMastery(Region region, long summonerId, long championId);

    /**
     * Get all champion mastery entries
     * @param region Region where to retrieve the data
     * @param summonerId The summoner id
     * @return The champion mastery entries
     */
    List<ChampionMasteryDto> getChampionMasteries(Region region, long summonerId);

    /**
     * Get a player's total champion mastery score, which is a sum of individual champion mastery levels
     * @param region Region where to retrieve the data
     * @param summonerId The summoner id
     * @return The score
     */
    int getChampionMasteryScore(Region region, long summonerId);

    /**
     * Get a specified number of top champion mastery entries
     * @param region Region where to retrieve the data
     * @param summonerId The summoner id
     * @param count Number of entries to retrieve
     * @return The champion mastery entries
     */
    List<ChampionMasteryDto> getTopChampions(Region region, long summonerId, int count);
}
