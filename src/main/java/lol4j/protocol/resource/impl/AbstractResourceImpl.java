package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;

import javax.ws.rs.core.GenericType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Aaron Corley on 12/11/13.
 */
public abstract class AbstractResourceImpl {
    private List<Region> supportedRegions = new ArrayList<>();
    private Map<Region, ApiRequestManager> requestManagers;

    public AbstractResourceImpl(Region... regions) {
        supportedRegions.addAll(Arrays.asList(regions));
    }

    public final <T> T get(Region region, String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, Class<T> clazz) {
        doSupportedRegionCheck(region);
        ApiRequestManager requestManager = getApiRequestManager(region);
        String fullPath = region.getName() + '/' + path;

        return requestManager.get(fullPath, queryParams, ignoreRateLimiter, clazz);
    }

    public final <T> T get(Region region, String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, GenericType<T> genericType) {
        doSupportedRegionCheck(region);
        ApiRequestManager requestManager = getApiRequestManager(region);
        String fullPath = region.getName() + '/' + path;

        return requestManager.get(fullPath, queryParams, ignoreRateLimiter, genericType);
    }

    public final void doSupportedRegionCheck(Region region) {
        if (region == null || !supportedRegions.contains(region)) {
            throw new InvalidRegionException(region);
        }
    }

    public ApiRequestManager getApiRequestManager(Region region) {
        return requestManagers.get(region);
    }

    public void setRequestManagers(Map<Region, ApiRequestManager> requestManagers) {
        this.requestManagers = requestManagers;
    }
}
