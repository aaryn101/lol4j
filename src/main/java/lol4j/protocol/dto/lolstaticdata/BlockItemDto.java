package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Aaron Corley on 3/9/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlockItemDto {
    private int count;
    private String id;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
