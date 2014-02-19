package lol4j.exception;

import lol4j.util.SubType;

/**
 * Created by Aaryn101 on 2/10/14.
 */
public class SubTypeMismatchException extends RuntimeException {
    public SubTypeMismatchException(SubType subType) {
        super("\"" + (subType == null ? "null" : subType.name()) + "\" is not an accepted sub type for this call");
    }
}
