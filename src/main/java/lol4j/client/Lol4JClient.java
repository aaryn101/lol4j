package lol4j.client;

import lol4j.protocol.resource.ChampionResource;
import lol4j.protocol.resource.GameResource;
import lol4j.protocol.resource.LeagueResource;
import lol4j.protocol.resource.StatsResource;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public interface Lol4JClient {

    /**
     * Get the champion resource
     * @return Champion resource
     */
    ChampionResource getChampionResource();

    GameResource getGameResource();

    LeagueResource getLeagueResource();

    StatsResource getStatsResource();
}
