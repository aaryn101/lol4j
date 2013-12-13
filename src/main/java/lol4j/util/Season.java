package lol4j.util;

/**
 * Created by Aaryn101 on 12/12/13.
 */
public enum Season {
    SEASON_3 ("SEASON3"),
    SEASON_4 ("SEASON4");

    private String name = null;

    Season(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
