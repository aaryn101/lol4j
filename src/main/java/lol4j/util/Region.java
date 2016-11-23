package lol4j.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public enum Region {
    BR ("br", "BR1"),
    EUNE ("eune", "EUN1"),
    EUW ("euw", "EUW1"),
    JP ("jp", "JP1"),
    KR ("kr", "KR"),
    LAN ("lan", "LA1"),
    LAS ("las", "LA2"),
    NA ("na", "NA1"),
    OCE ("oce", "OC1"),
    PBE("pbe", "PBE1"),
    RU ("ru", "RU"),
    TR ("tr", "TR1"),
    UNKNOWN ("unknown", "unknown");

    private String name = null;
    private String location = null;

    Region(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    @JsonCreator
    public static Region create(String val) {
        Region[] regions = Region.values();
        for (Region region : regions) {
            if (region.name.equalsIgnoreCase(val)) {
                return region;
            }
        }
        return UNKNOWN;
    }
}
