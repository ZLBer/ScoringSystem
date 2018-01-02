package test.domain;

import test.GlobalVariance;

import javax.xml.bind.JAXBElement;

public class AllScore {
    public int place;
    public String name;
    public String examNumber;
    public int serialNumber;
    public int dominantScore[];
    public int secondaryScore[];
    public int sightsingScore[];
    public int count;

    public AllScore(){
        dominantScore=new int[3];
        secondaryScore=new int[3];
        sightsingScore=new int[3];
    }

    public AllScore(ScoreInfo scoreInfo){
        this.serialNumber = scoreInfo.getSerialNumber();
        this.place = scoreInfo.getPlace();
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
    public void addS(Score score){
        serialNumber=score.getSerialNumber();
        if(score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_A1)||score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_B1)){
         dominantScore[0]=score.getDominantScore();
         secondaryScore[0]=score.getSecondaryScore();
         sightsingScore[0]=score.getSightsingingScore();
        }
        else if(score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_A2)||score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_B2)){
            dominantScore[1]=score.getDominantScore();
            secondaryScore[1]=score.getSecondaryScore();
            sightsingScore[1]=score.getSightsingingScore();
        }
        else if(score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_A3)||score.getReviewer().equals(GlobalVariance.ACCOUNT_REVIEWE_B3)){
            dominantScore[2]=score.getDominantScore();
            secondaryScore[2]=score.getSecondaryScore();
            sightsingScore[2]=score.getSightsingingScore();
        }

}
}
