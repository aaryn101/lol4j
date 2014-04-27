package lol4j.protocol.resource.impl;

import lol4j.protocol.resource.*;
import lol4j.service.impl.ApiRequestManager;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public class ResourceFactory {
    private ApiRequestManager apiRequestManager;

    public ResourceFactory(ApiRequestManager apiRequestManager) {
        this.apiRequestManager = apiRequestManager;
    }

    public ChampionResource createChampionResource() {
        ChampionResourceImpl championResource = new ChampionResourceImpl();
        championResource.setApiRequestManager(apiRequestManager);

        return championResource;
    }

    public GameResource createGameResource() {
        GameResourceImpl gameResource = new GameResourceImpl();
        gameResource.setApiRequestManager(apiRequestManager);

        return gameResource;
    }

    public LeagueResource createLeagueResource() {
        LeagueResourceImpl leagueResource = new LeagueResourceImpl();
        leagueResource.setApiRequestManager(apiRequestManager);

        return leagueResource;
    }

    public StatsResource createStatsResource() {
        StatsResourceImpl statsResource = new StatsResourceImpl();
        statsResource.setApiRequestManager(apiRequestManager);

        return statsResource;
    }

    public SummonerResource createSummonerResource() {
        SummonerResourceImpl summonerResource = new SummonerResourceImpl();
        summonerResource.setApiRequestManager(apiRequestManager);

        return summonerResource;
    }

    public TeamResource createTeamResource() {
        TeamResourceImpl teamResource = new TeamResourceImpl();
        teamResource.setApiRequestManager(apiRequestManager);

        return teamResource;
    }

    public LolStaticDataResource createLolStaticDataResource() {
        LolStaticDataResourceImpl lolStaticDataResource = new LolStaticDataResourceImpl();
        lolStaticDataResource.setApiRequestManager(apiRequestManager);

        return lolStaticDataResource;
    }
}
