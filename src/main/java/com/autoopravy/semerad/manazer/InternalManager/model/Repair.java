package com.autoopravy.semerad.manazer.InternalManager.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collection;
import java.util.Date;

public class Repair {

    @JsonProperty
    private Long repairId;

    @JsonProperty
    private Long userRepairId;

    @JsonProperty
    private String repairs;

    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd")
    private Date startOfRepair;

    @JsonProperty
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date endOfRepair;

    @JsonProperty
    private Boolean techCheck;

    @JsonProperty
    private Boolean oil;

    private Collection<SparePart> parts;

    public Repair(){};

    public Repair(Long repairId, Long userRepairId, String repairs, Date startOfRepair, Date endOfRepair, Boolean techCheck, Boolean oil, Collection<SparePart> parts) {
        this.repairId = repairId;
        this.userRepairId = userRepairId;
        this.repairs = repairs;
        this.startOfRepair = startOfRepair;
        this.endOfRepair = endOfRepair;
        this.techCheck = techCheck;
        this.oil = oil;
        this.parts = parts;
    }

    public Long getRepairId() {
        return repairId;
    }

    public void setRepairId(Long repairId) {
        this.repairId = repairId;
    }

    public Long getUserRepairId() {
        return userRepairId;
    }

    public void setUserRepairId(Long userRepairId) {
        this.userRepairId = userRepairId;
    }

    public String getRepairs() {
        return repairs;
    }

    public void setRepairs(String repairs) {
        this.repairs = repairs;
    }

    public Date getStartOfRepair() {
        return startOfRepair;
    }

    public void setStartOfRepair(Date startOfRepair) {
        this.startOfRepair = startOfRepair;
    }

    public Date getEndOfRepair() {
        return endOfRepair;
    }

    public void setEndOfRepair(Date endOfRepair) {
        this.endOfRepair = endOfRepair;
    }

    public Boolean getTechCheck() {
        return techCheck;
    }

    public void setTechCheck(Boolean techCheck) {
        this.techCheck = techCheck;
    }

    public Boolean getOil() {
        return oil;
    }

    public void setOil(Boolean oil) {
        this.oil = oil;
    }

    public Collection<SparePart> getParts() {
        return parts;
    }

    public void setParts(Collection<SparePart> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "repairId=" + repairId +
                ", userRepairId=" + userRepairId +
                ", repairs='" + repairs + '\'' +
                ", startOfRepair=" + startOfRepair +
                ", endOfRepair=" + endOfRepair +
                ", techCheck=" + techCheck +
                ", oil=" + oil +
                ", parts=" + parts +
                '}';
    }
}
