package lol4j.protocol.resource.impl;

import lol4j.protocol.resource.*;
import lol4j.service.impl.ApiRequestManager;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public class ResourceFactory {
    private ApiRequestManager prodApiRequestManager;
    private ApiRequestManager euApiRequestManager;
    private ApiRequestManager asiaApiRequestManager;

    public ResourceFactory(ApiRequestManager prodApiRequestManager, ApiRequestManager euApiRequestManager, ApiRequestManager asiaApiRequestManager) {
        this.prodApiRequestManager = prodApiRequestManager;
        this.euApiRequestManager = euApiRequestManager;
        this.asiaApiRequestManager = asiaApiRequestManager;
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
        return (LolStaticDataResource) createAbstractResourceImpl(LolStaticDataResourceImpl.class);
    }

    private <T extends AbstractResourceImpl> T createAbstractResourceImpl(Class<? extends AbstractResourceImpl> T) {
        AbstractResourceImpl impl = null;

        try {
            impl = T.newInstance();
            impl.setProdApiRequestManager(prodApiRequestManager);
            impl.setEuApiRequestManager(euApiRequestManager);
            impl.setAsiaApiRequestManager(asiaApiRequestManager);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return (T)impl;
    }
}
