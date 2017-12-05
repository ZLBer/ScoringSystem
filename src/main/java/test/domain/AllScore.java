package test.domain;

public class AllScore {
    public String name;
    public String examNumber;
    public int dominantScore[];
    public int secondaryScore[];
    public int sightsingScore[];
    public int count;

    public AllScore(ScoreInfo scoreInfo){
        this.name = scoreInfo.getName();
        this.examNumber =scoreInfo.getExamNumber();
        dominantScore = new int[3];
        dominantScore[0] = scoreInfo.getDominantScore();
        secondaryScore = new int[3];
        secondaryScore[0] = scoreInfo.getSecondaryScore();
        sightsingScore = new int[3];
        sightsingScore[0] = scoreInfo.getSightsingingScore();
        count = 1;
    }

    public void addScore(ScoreInfo score){
        if (count<3){
            dominantScore[count]=score.getDominantScore();
            secondaryScore[count]=score.getSecondaryScore();
            sightsingScore[count]=score.getSightsingingScore();
            count++;
        }
    }
}
