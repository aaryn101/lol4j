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

    public ChampionResource createChampionResource() {
        return (ChampionResource) createAbstractResourceImpl(ChampionResourceImpl.class);
    }

    public GameResource createGameResource() {
        return (GameResource) createAbstractResourceImpl(GameResourceImpl.class);
    }

    public LeagueResource createLeagueResource() {
        return (LeagueResource) createAbstractResourceImpl(LeagueResourceImpl.class);
    }

    public StatsResource createStatsResource() {
        return (StatsResource) createAbstractResourceImpl(StatsResourceImpl.class);
    }

    public SummonerResource createSummonerResource() {
        return (SummonerResource) createAbstractResourceImpl(SummonerResourceImpl.class);
    }

    public TeamResource createTeamResource() {
        return (TeamResource) createAbstractResourceImpl(TeamResourceImpl.class);
    }

    public LolStaticDataResource createLolStaticDataResource() {
        LolStaticDataResourceImpl impl = createAbstractResourceImpl(LolStaticDataResourceImpl.class);
        impl.setApiRequestManager(staticDataApiRequestManager);

        return impl;
    }

    private <T extends AbstractResourceImpl> T createAbstractResourceImpl(Class<? extends AbstractResourceImpl> T) {
        AbstractResourceImpl impl = null;

        try {
            impl = T.newInstance();
            impl.setRequestManagers(requestManagers);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T)impl;
    }
}
