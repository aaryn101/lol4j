package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Aaron Corley on 12/11/13.
 */
public abstract class AbstractResourceImpl {
    private List<Region> supportedRegions = new ArrayList<>();
    private ApiRequestManager prodApiRequestManager;
    private ApiRequestManager euApiRequestManager;
    private ApiRequestManager asiaApiRequestManager;

    public AbstractResourceImpl(Region... regions) {
        supportedRegions.addAll(Arrays.asList(regions));
    }

    public void doSupportedRegionCheck(Region region) {
        if (region == null || !supportedRegions.contains(region)) {
            throw new InvalidRegionException(region);
        }
    }

    public List<Region> getSupportedRegions() {
        return supportedRegions;
    }

    public ApiRequestManager getApiRequestManager(Region region) {
        ApiRequestManager requestManager = null;

        switch(region) {
            case BR:
            case EUNE:
            case EUW:
            case LAN:
            case LAS:
            case NA:
            case OCE:
                requestManager = prodApiRequestManager;
                break;
            case RU:
            case TR:
                requestManager = euApiRequestManager;
                break;
            case KR:
                requestManager = asiaApiRequestManager;
                break;
            default:
                requestManager = prodApiRequestManager;
                break;
        }

        return requestManager;
    }

    public void setProdApiRequestManager(ApiRequestManager prodApiRequestManager) {
        this.prodApiRequestManager = prodApiRequestManager;
    }

    public void setEuApiRequestManager(ApiRequestManager euApiRequestManager) {
        this.euApiRequestManager = euApiRequestManager;
    }

    public void setAsiaApiRequestManager(ApiRequestManager asiaApiRequestManager) {
        this.asiaApiRequestManager = asiaApiRequestManager;
    }
}
