package lol4j.util;

/**
 * Created by Aaryn101 on 12/10/13.
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
    TR ("tr");

    private String name = null;

    Region(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
