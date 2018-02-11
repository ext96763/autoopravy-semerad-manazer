package com.autoopravy.semerad.manazer.InternalManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Collection;
import java.util.Date;

public class Car {

    @JsonProperty
    private Long carId;

    @JsonProperty
    private Long userCarId;

    @JsonProperty
    private String win;

    @JsonProperty
    private String spz;

    @JsonProperty
    private Long km;

    @JsonProperty
    private String carInfo;

    @JsonProperty
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date startDayError;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDayError;

    @JsonProperty
    private Date featureRepairDate;

    @JsonProperty
    private Boolean doneWork;

    @JsonProperty
    private Boolean exist;

    @JsonProperty
    private  String buyedParts;

    @JsonProperty
    private Collection<Repair> repairs;

    public Car(){};

    public Car(Long carId, Long userCarId, String win, String spz, Long km, String carInfo, Date startDayError, Date endDayError, Date featureRepairDate, Boolean doneWork, Boolean exist, String buyedParts, Collection<Repair> repairs) {
        this.carId = carId;
        this.userCarId = userCarId;
        this.win = win;
        this.spz = spz;
        this.km = km;
        this.carInfo = carInfo;
        this.startDayError = startDayError;
        this.endDayError = endDayError;
        this.featureRepairDate = featureRepairDate;
        this.doneWork = doneWork;
        this.exist = exist;
        this.buyedParts = buyedParts;
        this.repairs = repairs;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Long userCarId) {
        this.userCarId = userCarId;
    }

    public String getWin() {
        return win;
    }

    public void setWin(String win) {
        this.win = win;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public Date getStartDayError() {
        return startDayError;
    }

    public void setStartDayError(Date startDayError) {
        this.startDayError = startDayError;
    }

    public Date getEndDayError() {
        return endDayError;
    }

    public void setEndDayError(Date endDayError) {
        this.endDayError = endDayError;
    }

    public Date getFeatureRepairDate() {
        return featureRepairDate;
    }

    public void setFeatureRepairDate(Date featureRepairDate) {
        this.featureRepairDate = featureRepairDate;
    }

    public Boolean getDoneWork() {
        return doneWork;
    }

    public void setDoneWork(Boolean doneWork) {
        this.doneWork = doneWork;
    }

    public Boolean getExist() {
        return exist;
    }

    public void setExist(Boolean exist) {
        this.exist = exist;
    }

    public String getBuyedParts() {
        return buyedParts;
    }

    public void setBuyedParts(String buyedParts) {
        this.buyedParts = buyedParts;
    }

    public Collection<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(Collection<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", userCarId=" + userCarId +
                ", win='" + win + '\'' +
                ", spz='" + spz + '\'' +
                ", km=" + km +
                ", carInfo='" + carInfo + '\'' +
                ", startDayError=" + startDayError +
                ", endDayError=" + endDayError +
                ", featureRepairDate=" + featureRepairDate +
                ", doneWork=" + doneWork +
                ", exist=" + exist +
                ", buyedParts='" + buyedParts + '\'' +
                ", repairs=" + repairs +
                '}';
    }
}
