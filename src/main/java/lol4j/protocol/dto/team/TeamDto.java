package lol4j.protocol.dto.team;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Aaryn101 on 12/13/13.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamDto {
    private Date createDate;
    private String fullId;
    private Date lastGameDate;
    private Date lastJoinDate;
    private Date lastJoinedRankedTeamQueueDate;
    private List<MatchHistorySummaryDto> matchHistory = new ArrayList<>();
    private MessageOfDayDto messageOfDay;
    private Date modifyDate;
    private String name;
    private RosterDto roster;
    private Date secondLastJoinDate;
    private String status;
    private String tag;
    private TeamStatSummaryDto teamStatSummary;
    private Date thirdLastJoinDate;

    public String getFullId() {
        return fullId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }

    public void setMatchHistory(List<MatchHistorySummaryDto> matchHistory) {
        this.matchHistory = matchHistory;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public List<MatchHistorySummaryDto> getMatchHistory() {
        return matchHistory;
    }

    public MessageOfDayDto getMessageOfDay() {

        return messageOfDay;
    }

    public void setMessageOfDay(MessageOfDayDto messageOfDay) {
        this.messageOfDay = messageOfDay;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RosterDto getRoster() {
        return roster;
    }

    public void setRoster(RosterDto roster) {
        this.roster = roster;
    }

    public Date getSecondLastJoinDate() {
        return secondLastJoinDate;
    }

    public void setSecondLastJoinDate(Date secondLastJoinDate) {
        this.secondLastJoinDate = secondLastJoinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public TeamStatSummaryDto getTeamStatSummary() {
        return teamStatSummary;
    }

    public void setTeamStatSummary(TeamStatSummaryDto teamStatSummary) {
        this.teamStatSummary = teamStatSummary;
    }

    public Date getThirdLastJoinDate() {
        return thirdLastJoinDate;
    }

    public void setThirdLastJoinDate(Date thirdLastJoinDate) {
        this.thirdLastJoinDate = thirdLastJoinDate;
    }

    public Date getLastJoinDate() {
        return lastJoinDate;
    }

    public void setLastJoinDate(Date lastJoinDate) {
        this.lastJoinDate = lastJoinDate;
    }

    public Date getLastJoinedRankedTeamQueueDate() {
        return lastJoinedRankedTeamQueueDate;
    }

    public void setLastJoinedRankedTeamQueueDate(Date lastJoinedRankedTeamQueueDate) {
        this.lastJoinedRankedTeamQueueDate = lastJoinedRankedTeamQueueDate;
    }

    public Date getLastGameDate() {
        return lastGameDate;
    }

    public void setLastGameDate(Date lastGameDate) {
        this.lastGameDate = lastGameDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
