package test.domain;

import java.util.Date;

public class Information {
    private String examNumber;

    private String serialNumber;

    private String name;

    private Integer sex;

    private String phoneNumber;

    private String homeAddress;

    private String idNumber;

    private String faculty;

    private String dominantTerm;

    private String dominantInstrument;

    private String dominantSong;

    private String secondaryTerm;

    private String secondaryInstrument;

    private String secondarySong;

    private String sightsinging;

    private Date entranceTime;

    public String getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(String examNumber) {
        this.examNumber = examNumber == null ? null : examNumber.trim();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty == null ? null : faculty.trim();
    }

    public String getDominantTerm() {
        return dominantTerm;
    }

    public void setDominantTerm(String dominantTerm) {
        this.dominantTerm = dominantTerm == null ? null : dominantTerm.trim();
    }

    public String getDominantInstrument() {
        return dominantInstrument;
    }

    public void setDominantInstrument(String dominantInstrument) {
        this.dominantInstrument = dominantInstrument == null ? null : dominantInstrument.trim();
    }

    public String getDominantSong() {
        return dominantSong;
    }

    public void setDominantSong(String dominantSong) {
        this.dominantSong = dominantSong == null ? null : dominantSong.trim();
    }

    public String getSecondaryTerm() {
        return secondaryTerm;
    }

    public void setSecondaryTerm(String secondaryTerm) {
        this.secondaryTerm = secondaryTerm == null ? null : secondaryTerm.trim();
    }

    public String getSecondaryInstrument() {
        return secondaryInstrument;
    }

    public void setSecondaryInstrument(String secondaryInstrument) {
        this.secondaryInstrument = secondaryInstrument == null ? null : secondaryInstrument.trim();
    }

    public String getSecondarySong() {
        return secondarySong;
    }

    public void setSecondarySong(String secondarySong) {
        this.secondarySong = secondarySong == null ? null : secondarySong.trim();
    }

    public String getSightsinging() {
        return sightsinging;
    }

    public void setSightsinging(String sightsinging) {
        this.sightsinging = sightsinging == null ? null : sightsinging.trim();
    }

    public Date getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(Date entranceTime) {
        this.entranceTime = entranceTime;
    }
}