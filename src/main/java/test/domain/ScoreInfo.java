package test.domain;

public class ScoreInfo {
    private String name;
    private String examNumber;
    private Integer dominantScore;
    private Integer secondaryScore;
    private Integer sightsingingScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber;
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
}
