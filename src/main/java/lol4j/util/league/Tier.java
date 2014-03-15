package lol4j.util.league;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 12/12/13.
 */
public enum Tier {
    CHALLENGER ("CHALLENGER"),
    DIAMOND ("DIAMOND"),
    PLATINUM ("PLATINUM"),
    GOLD ("GOLD"),
    SILVER ("SILVER"),
    BRONZE ("BRONZE"),
    UNKNOWN ("UNKNOWN");

    private String tier;

    private Tier(String tier) {
        this.tier = tier;
    }

    @JsonValue
    public String getTier() {
        return tier;
    }

    @JsonCreator
    public static Tier create(String val) {
        Tier[] tiers = Tier.values();
        for (Tier tier : tiers) {
            if (tier.tier.equalsIgnoreCase(val)) {
                return tier;
            }
        }
        return UNKNOWN;
    }
}
