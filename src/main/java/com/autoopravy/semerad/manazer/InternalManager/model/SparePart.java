package com.autoopravy.semerad.manazer.InternalManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class SparePart {

    @JsonProperty
    private Long partId;

    @JsonProperty
    private Long partNumber;

    @JsonProperty
    private String partDetail;

    @JsonProperty
    private Date repairDate;

    @JsonProperty
    private Long userPartId;

    public SparePart(){};

    public SparePart(Long partId, Long partNumber, String partDetail, Date repairDate, Long userPartId) {
        this.partId = partId;
        this.partNumber = partNumber;
        this.partDetail = partDetail;
        this.repairDate = repairDate;
        this.userPartId = userPartId;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public Long getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(Long partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartDetail() {
        return partDetail;
    }

    public void setPartDetail(String partDetail) {
        this.partDetail = partDetail;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Long getUserPartId() {
        return userPartId;
    }

    public void setUserPartId(Long userPartId) {
        this.userPartId = userPartId;
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "partId=" + partId +
                ", partNumber=" + partNumber +
                ", partDetail='" + partDetail + '\'' +
                ", repairDate=" + repairDate +
                ", userPartId=" + userPartId +
                '}';
    }
}
