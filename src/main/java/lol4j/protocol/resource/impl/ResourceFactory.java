package lol4j.protocol.resource.impl;

import lol4j.protocol.resource.*;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;

import java.util.Map;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public class ResourceFactory {
    private ApiRequestManager staticDataApiRequestManager;
    private Map<Region, ApiRequestManager> requestManagers;


    public ResourceFactory(Map<Region, ApiRequestManager> requestManagers, ApiRequestManager staticDataApiRequestManager) {
        this.requestManagers = requestManagers;
        this.staticDataApiRequestManager = staticDataApiRequestManager;
    }

    public ChampionMasteryResource createChampionMasteryResource() {
        return createAbstractResourceImpl(ChampionMasteryResourceImpl.class);
    }

    public ChampionResource createChampionResource() {
        return createAbstractResourceImpl(ChampionResourceImpl.class);
    }

    public GameResource createGameResource() {
        return createAbstractResourceImpl(GameResourceImpl.class);
    }

    public LeagueResource createLeagueResource() {
        return createAbstractResourceImpl(LeagueResourceImpl.class);
    }

    public StatsResource createStatsResource() {
        return createAbstractResourceImpl(StatsResourceImpl.class);
    }

    public SummonerResource createSummonerResource() {
        return createAbstractResourceImpl(SummonerResourceImpl.class);
    }

    public TeamResource createTeamResource() {
        return createAbstractResourceImpl(TeamResourceImpl.class);
    }

    public LolStaticDataResource createLolStaticDataResource() {
        LolStaticDataResourceImpl impl = createAbstractResourceImpl(LolStaticDataResourceImpl.class);
        impl.setApiRequestManager(staticDataApiRequestManager);

        return impl;
    }

    private <T extends AbstractResource> T createAbstractResourceImpl(Class<? extends AbstractResource> T) {
        AbstractResource impl = null;

        try {
            impl = T.newInstance();
            impl.setRequestManagers(requestManagers);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T)impl;
    }
}
