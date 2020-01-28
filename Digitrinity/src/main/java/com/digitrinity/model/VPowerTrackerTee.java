package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_PowerTracker_TEE")
public class VPowerTrackerTee {
    @Id
    @Column(name = "smsiteid")
    private long smSiteId;
    @Column(name = "zone")
    private String zone;
    @Column(name = "region")
    private String region;
    @Column(name = "clustername")
    private String clusterName;

    @Column(name = "engineer_name")
    private String engineerName;
    @Column(name = "smsitecode")
    private String smSiteCode;
    @Column(name = "sitetypeid")
    private String sitetypeid;
    @Column(name = "devicetype")
    private String devicetype;

    @Column(name = "smcustomername")
    private String smCustomerName;
    @Column(name = "sitebattvolt")
    private double sitebattvolt;

    @Column(name = "batt_soc")
    private long battSoc;

    @Column(name = "total_dcload_current")
    private double totalDcLoadCurrent;

    @Column(name = "datetime")
    private String datetime;
    @Column(name = "powersource")
    private String powersource;
    @Column(name = "rect_input_r_current")
    private double rectInputRCurrent;

    @Column(name = "rect_input_y_current")
    private double rectInputYCurrent;
    @Column(name = "rect_input_b_current")
    private double rectInputBCurrent;

    @Column(name = "opco_1_loadcurrent")
    private double opco1LoadCurrent;
    @Column(name = "opco_2_loadcurrent")
    private double opco2LoadCurrent;
    @Column(name = "opco_3_loadcurrent")
    private double opco3LoadCurrent;

    @Column(name = "opco_4_loadcurrent")
    private double opco4LoadCurrent;

    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "smsitetypeid")
    private long smsitetypeid;


    public long getSmSiteId() {
        return smSiteId;
    }

    public void setSmSiteId(long smSiteId) {
        this.smSiteId = smSiteId;
    }


    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }


    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }


    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }


    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }


    public String getSmSiteCode() {
        return smSiteCode;
    }

    public void setSmSiteCode(String smSiteCode) {
        this.smSiteCode = smSiteCode;
    }


    public String getSitetypeid() {
        return sitetypeid;
    }

    public void setSitetypeid(String sitetypeid) {
        this.sitetypeid = sitetypeid;
    }


    public String getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(String devicetype) {
        this.devicetype = devicetype;
    }


    public String getSmCustomerName() {
        return smCustomerName;
    }

    public void setSmCustomerName(String smCustomerName) {
        this.smCustomerName = smCustomerName;
    }


    public double getSitebattvolt() {
        return sitebattvolt;
    }

    public void setSitebattvolt(double sitebattvolt) {
        this.sitebattvolt = sitebattvolt;
    }


    public long getBattSoc() {
        return battSoc;
    }

    public void setBattSoc(long battSoc) {
        this.battSoc = battSoc;
    }


    public double getTotalDcLoadCurrent() {
        return totalDcLoadCurrent;
    }

    public void setTotalDcLoadCurrent(double totalDcLoadCurrent) {
        this.totalDcLoadCurrent = totalDcLoadCurrent;
    }


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }


    public String getPowersource() {
        return powersource;
    }

    public void setPowersource(String powersource) {
        this.powersource = powersource;
    }


    public double getRectInputRCurrent() {
        return rectInputRCurrent;
    }

    public void setRectInputRCurrent(double rectInputRCurrent) {
        this.rectInputRCurrent = rectInputRCurrent;
    }


    public double getRectInputYCurrent() {
        return rectInputYCurrent;
    }

    public void setRectInputYCurrent(double rectInputYCurrent) {
        this.rectInputYCurrent = rectInputYCurrent;
    }


    public double getRectInputBCurrent() {
        return rectInputBCurrent;
    }

    public void setRectInputBCurrent(double rectInputBCurrent) {
        this.rectInputBCurrent = rectInputBCurrent;
    }


    public double getOpco1LoadCurrent() {
        return opco1LoadCurrent;
    }

    public void setOpco1LoadCurrent(double opco1LoadCurrent) {
        this.opco1LoadCurrent = opco1LoadCurrent;
    }


    public double getOpco2LoadCurrent() {
        return opco2LoadCurrent;
    }

    public void setOpco2LoadCurrent(double opco2LoadCurrent) {
        this.opco2LoadCurrent = opco2LoadCurrent;
    }


    public double getOpco3LoadCurrent() {
        return opco3LoadCurrent;
    }

    public void setOpco3LoadCurrent(double opco3LoadCurrent) {
        this.opco3LoadCurrent = opco3LoadCurrent;
    }


    public double getOpco4LoadCurrent() {
        return opco4LoadCurrent;
    }

    public void setOpco4LoadCurrent(double opco4LoadCurrent) {
        this.opco4LoadCurrent = opco4LoadCurrent;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }


    public long getSmsitetypeid() {
        return smsitetypeid;
    }

    public void setSmsitetypeid(long smsitetypeid) {
        this.smsitetypeid = smsitetypeid;
    }

}
