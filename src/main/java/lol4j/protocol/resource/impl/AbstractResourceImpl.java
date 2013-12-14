package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public abstract class AbstractResourceImpl {
    private List<Region> supportedRegions = new ArrayList<>();
    private ApiRequestManager apiRequestManager;
    private String baseUri;

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

    public String getBaseUri() {
        return baseUri;
    }

    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }
}
