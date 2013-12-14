package lol4j.exception;

import lol4j.util.Region;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class InvalidRegionException extends RuntimeException {
    public InvalidRegionException(Region region) {
        super("\"" +  (region == null ? "null" : region.getName()) + "\" is not a valid region");
    }
}
