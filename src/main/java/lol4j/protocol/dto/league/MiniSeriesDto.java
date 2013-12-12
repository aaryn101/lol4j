package lol4j.protocol.dto.league;

/**
 * Created by Aaryn101 on 12/11/13.
 */
public class MiniSeriesDto {
    private int losses;
    private char[] progress;
    private int target;
    private long timeLeftToPlayMillis;
    private int wins;

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public char[] getProgress() {
        return progress;
    }

    public void setProgress(char[] progress) {
        this.progress = progress;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public long getTimeLeftToPlayMillis() {
        return timeLeftToPlayMillis;
    }

    public void setTimeLeftToPlayMillis(long timeLeftToPlayMillis) {
        this.timeLeftToPlayMillis = timeLeftToPlayMillis;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
