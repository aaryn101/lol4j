package lol4j.util.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 2/10/14.
 */
public enum ItemData {
    ALL ("all"),
    GOLD ("gold"),
    COLLOQ ("colloq"),
    CONSUMED ("consumed"),
    STACKS ("stacks"),
    DEPTH ("depth"),
    CONSUME_ON_FULL ("consumeOnFull"),
    FROM ("from"),
    INTO ("into"),
    SPECIAL_RECIPE ("specialRecipe"),
    IN_STORE ("inStore"),
    HIDE_FROM_ALL ("hideFromAll"),
    REQUIRED_CHAMPION ("requiredChampion"),
    TAGS ("tags"),
    MAPS ("maps"),
    IMAGE ("image"),
    STATS ("stats"),
    UNKNOWN ("unknown");

    private String itemData;

    private ItemData(String itemData) {
        this.itemData = itemData;
    }

    @JsonValue
    public String getItemData() {
        return itemData;
    }

    @JsonCreator
    public static ItemData create(String val) {
        ItemData[] values = ItemData.values();
        for (ItemData value : values) {
            if (value.getItemData().equalsIgnoreCase(val)) {
                return value;
            }
        }
        return UNKNOWN;
    }
}
