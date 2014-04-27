package lol4j.protocol.dto.lolstaticdata;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 3/10/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemTreeDto {
    private String header;
    private List<String> tags = new ArrayList<>();

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {

        return header;
    }

    public List<String> getTags() {
        return tags;
    }
}
