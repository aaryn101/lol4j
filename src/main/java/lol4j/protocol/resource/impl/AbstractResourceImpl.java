package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 12/11/13.
 */
public abstract class AbstractResourceImpl {
    private List<Region> supportedRegions = new ArrayList<>();
    private ApiRequestManager apiRequestManager;

    public void doSupportedRegionCheck(Region region) {
        if (region == null || !supportedRegions.contains(region)) {
            throw new InvalidRegionException(region);
        }
    }

    public List<Region> getSupportedRegions() {
        return supportedRegions;
    }

    public ApiRequestManager getApiRequestManager() {
        return apiRequestManager;
    }

    public void setApiRequestManager(ApiRequestManager apiRequestManager) {
        this.apiRequestManager = apiRequestManager;
    }
}
