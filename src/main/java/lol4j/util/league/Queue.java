package lol4j.util.league;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by Aaron Corley on 12/12/13.
 */
public enum Queue {
    RANKED_SOLO_5X5 ("RANKED_SOLO_5x5"),
    RANKED_TEAM_3X3 ("RANKED_TEAM_3x3"),
    RANKED_TEAM_5X5 ("RANKED_TEAM_5x5"),
    UNKNOWN ("UNKNOWN");

    private String queue;

    private Queue(String queue) {
        this.queue = queue;
    }

    @JsonValue
    public String getQueue() {
        return queue;
    }

    @JsonCreator
    public static Queue create(String val) {
        Queue[] queues = Queue.values();
        for (Queue queue : queues) {
            if (queue.queue.equalsIgnoreCase(val)) {
                return queue;
            }
        }
        return UNKNOWN;
    }
}
