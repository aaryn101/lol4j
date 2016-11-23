package lol4j.protocol.resource.impl;

import lol4j.util.Region;

/**
 * Created by aaryn on 11/23/16.
 */
public class LocationResource extends AbstractResource {
    private String name;

    public LocationResource(String name, Region... regions) {
        super(regions);
        this.name = name;
    }

    @Override
    protected String getBasePath(Region region) {
        return name + SLASH + "location" + SLASH + region.getLocation();
    }
}
