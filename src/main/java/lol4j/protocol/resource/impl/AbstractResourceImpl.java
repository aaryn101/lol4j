package lol4j.protocol.resource.impl;

import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Regions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public class AbstractResourceImpl {
    private List<Regions> supportedRegions = new ArrayList<>();
    private ApiRequestManager apiRequestManager;
    private String baseUri;

    public boolean isSupportedRegion(String region) {
        return supportedRegions.contains(Regions.valueOf(region.toUpperCase()));
    }

    public List<Regions> getSupportedRegions() {
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
