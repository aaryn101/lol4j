package lol4j.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 12/10/13.
 */
public enum Region {
    BR ("br"),
    EUNE ("eune"),
    EUW ("euw"),
    KR ("kr"),
    LAN ("lan"),
    LAS ("las"),
    NA ("na"),
    OCE ("oce"),
    RU ("ru"),
    TR ("tr"),
    UNKNOWN ("unknown");

    private String name = null;

    Region(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
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
