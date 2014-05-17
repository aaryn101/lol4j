package lol4j.protocol.resource.impl;

import lol4j.exception.InvalidRegionException;
import lol4j.service.impl.ApiRequestManager;
import lol4j.util.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public final <T> T get(Region region, String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, Class<T> clazz) {
        doSupportedRegionCheck(region);
        ApiRequestManager requestManager = getApiRequestManager(region);
        String fullPath = region.getName() + '/' + path;

        return requestManager.get(fullPath, queryParams, ignoreRateLimiter, clazz);
    }

    public final <K, V> Map<K, List<V>> getMapOfLists(Region region, String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, Class<K> keyClass, Class<V> listValueClass) {
        doSupportedRegionCheck(region);
        ApiRequestManager requestManager = getApiRequestManager(region);
        String fullPath = region.getName() + '/' + path;

        return requestManager.getMapOfLists(fullPath, queryParams, ignoreRateLimiter, keyClass, listValueClass);
    }

    public final <K, V> Map<K, V> getMap(Region region, String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, Class<K> keyClass, Class<V> valueClass) {
        doSupportedRegionCheck(region);
        ApiRequestManager requestManager = getApiRequestManager(region);
        String fullPath = region.getName() + '/' + path;

        return requestManager.getMap(fullPath, queryParams, ignoreRateLimiter, keyClass, valueClass);
    }

    public final <T> List<T> getList(Region region, String path, Map<String, Object> queryParams, boolean ignoreRateLimiter, Class<T> clazz) {
        doSupportedRegionCheck(region);
        ApiRequestManager requestManager = getApiRequestManager(region);
        String fullPath = region.getName() + '/' + path;

        return requestManager.getList(fullPath, queryParams, ignoreRateLimiter, clazz);
    }

    public final void doSupportedRegionCheck(Region region) {
        if (region == null || !supportedRegions.contains(region)) {
            throw new InvalidRegionException(region);
        }
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
