package lol4j.protocol.resource.impl;

import lol4j.util.Region;

/**
 * Created by aaryn on 11/23/16.
 */
public class ApiResource extends AbstractResource {
    private String name;
    private String version;

    public ApiResource(String name, String version, Region... regions) {
        super(regions);
        this.name = name;
        this.version = version;
    }

    @Override
    protected String getBasePath(Region region) {
        return "api/lol/" + region.getName() + SLASH + version + SLASH + name;
    }
}
