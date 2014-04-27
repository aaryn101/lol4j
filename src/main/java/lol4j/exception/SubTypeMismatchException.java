package lol4j.exception;

import lol4j.util.game.SubType;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public class SubTypeMismatchException extends RuntimeException {
    public SubTypeMismatchException(SubType subType) {
        super("\"" + (subType == null ? "null" : subType.name()) + "\" is not an accepted sub type for this call");
    }
}
