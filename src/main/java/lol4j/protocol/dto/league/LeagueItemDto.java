package lol4j.protocol.dto.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Aaryn101 on 12/11/13.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class LeagueItemDto {
    @JsonProperty("isFreshBlood")
    private boolean freshBlood;
    @JsonProperty("isHotStreak")
    private boolean hotStreak;
    @JsonProperty("isInactive")
    private boolean inactive;
    @JsonProperty("isVeteran")
    private boolean veteran;
    private long lastPlayed;
    private String leagueName;
    private int leaguePoints;
    private int losses;
    private MiniSeriesDto miniSeries;
    private String playerOrTeamId;
    private String playerOrTeamName;
    private String queueType;
    private String rank;
    private String tier;
    private long timeUntilDecay;
    private int wins;

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(boolean freshBlood) {
        this.freshBlood = freshBlood;
    }

    public boolean isHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(boolean hotStreak) {
        this.hotStreak = hotStreak;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public void setVeteran(boolean veteran) {
        this.veteran = veteran;
    }

    public long getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(long lastPlayed) {
        this.lastPlayed = lastPlayed;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public MiniSeriesDto getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(MiniSeriesDto miniSeries) {
        this.miniSeries = miniSeries;
    }

    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    public void setPlayerOrTeamId(String playerOrTeamId) {
        this.playerOrTeamId = playerOrTeamId;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    public String getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = queueType;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public long getTimeUntilDecay() {
        return timeUntilDecay;
    }

    public void setTimeUntilDecay(long timeUntilDecay) {
        this.timeUntilDecay = timeUntilDecay;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
}
