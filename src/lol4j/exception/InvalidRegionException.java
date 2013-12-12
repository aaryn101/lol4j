package lol4j.exception;

/**
 * Created by Aaryn101 on 12/10/13.
 */
public class InvalidRegionException extends Exception {
    public InvalidRegionException(String region) {
        super("\"" + region + "\" is not a valid region");
    }
}
