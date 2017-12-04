package test.domain;

import java.util.Date;

public class Score {
    private Integer id;

    private Integer serialNumber;

    private Integer dominantScore;

    private Integer secondaryScore;

    private Integer sightsingingScore;

    private String reviewer;

    private Date scoreTime;

    private Integer place;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getDominantScore() {
        return dominantScore;
    }

    public void setDominantScore(Integer dominantScore) {
        this.dominantScore = dominantScore;
    }

    public Integer getSecondaryScore() {
        return secondaryScore;
    }

    public void setSecondaryScore(Integer secondaryScore) {
        this.secondaryScore = secondaryScore;
    }

    public Integer getSightsingingScore() {
        return sightsingingScore;
    }

    public void setSightsingingScore(Integer sightsingingScore) {
        this.sightsingingScore = sightsingingScore;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer == null ? null : reviewer.trim();
    }

    public Date getScoreTime() {
        return scoreTime;
    }

    public void setScoreTime(Date scoreTime) {
        this.scoreTime = scoreTime;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }
}