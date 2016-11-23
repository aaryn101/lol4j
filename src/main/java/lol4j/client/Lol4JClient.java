package lol4j.client;

import lol4j.protocol.resource.*;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public interface Lol4JClient extends
        GameResource,
        ChampionMasteryResource,
        ChampionResource,
        LeagueResource,
        StatsResource,
        SummonerResource,
        TeamResource,
        LolStaticDataResource {
    public void setRateLimit(int perTenSeconds, int perTenMinutes);
}
