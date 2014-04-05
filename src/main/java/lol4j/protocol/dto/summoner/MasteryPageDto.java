package lol4j.protocol.dto.summoner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron Corley on 12/12/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasteryPageDto {
    private boolean current;
    private long id;
    private String name;
    private List<MasteryDto> masteries = new ArrayList<>();

    public List<MasteryDto> getMasteries() {
        return masteries;
    }

    public boolean isCurrent() {

        return current;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
