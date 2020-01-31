package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_PowerTracker_Hybrid")
public class VPowerTrackerHybrid {
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
  @Column(name = "smsitetypeid")
  private int smSitetypeid;
  @Column(name = "devicetype")
  private String devicetype;
  @Column(name = "smcustomername")
  private String smCustomerName;
  @Column(name = "batt_soc")
  private long battSoc;
  @Column(name = "total_dcload_current")
  private double totalDcLoadCurrent;
  @Column(name = "fuellevel_ltrs")
  private long fuellevelLtrs;
  @Column(name = "dg_bat_volt")
  private double dgBatVolt;
  @Column(name = "batt_charging_current")
  private double battChargingCurrent;
  @Column(name = "batt_discharging_current")
  private double battDischargingCurrent;
  @Column(name = "total_rect_output_current")
  private double totalRectOutputCurrent;
  @Column(name = "teleenergy")
  private double teleEnergy;
  @Column(name = "inverterinputpower")
  private double inverterInputPower;
  @Column(name = "inverteroutputpower")
  private double inverterOutputPower;
  @Column(name = "sitebattvolt")
  private double sitebattvolt;
  @Column(name = "datetime")
  private String datetime;
  @Column(name = "powersource")
  private String powersource;
  @Column(name = "rect_input_r_voltage")
  private long rectInputRVoltage;
  @Column(name = "rect_input_R_current")
  private double rectInputRCurrent;
  @Column(name = "rect_input_y_current")
  private double rectInputYCurrent;
  @Column(name = "rect_input_b_current")
  private double rectInputBCurrent;
  @Column(name = "dg_r_amp")
  private double dgRAmp;
  @Column(name = "dg_y_amp")
  private double dgYAmp;
  @Column(name = "dg_b_amp")
  private double dgBAmp;
  @Column(name = "actel_r_current")
  private double actelRCurrent;
  @Column(name = "actel_y_current")
  private double actelYCurrent;
  @Column(name = "actel_b_current")
  private double actelBCurrent;
  @Column(name = "customer_name")
  private String customerName;
  @Column(name = "customer_id")
  private int customerId;

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


  public int getSmSitetypeid() {
    return smSitetypeid;
  }

  public void setSmSitetypeid(int smSitetypeid) {
    this.smSitetypeid = smSitetypeid;
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


  public long getFuellevelLtrs() {
    return fuellevelLtrs;
  }

  public void setFuellevelLtrs(long fuellevelLtrs) {
    this.fuellevelLtrs = fuellevelLtrs;
  }


  public double getDgBatVolt() {
    return dgBatVolt;
  }

  public void setDgBatVolt(double dgBatVolt) {
    this.dgBatVolt = dgBatVolt;
  }


  public double getBattChargingCurrent() {
    return battChargingCurrent;
  }

  public void setBattChargingCurrent(double battChargingCurrent) {
    this.battChargingCurrent = battChargingCurrent;
  }


  public double getBattDischargingCurrent() {
    return battDischargingCurrent;
  }

  public void setBattDischargingCurrent(double battDischargingCurrent) {
    this.battDischargingCurrent = battDischargingCurrent;
  }


  public double getTotalRectOutputCurrent() {
    return totalRectOutputCurrent;
  }

  public void setTotalRectOutputCurrent(double totalRectOutputCurrent) {
    this.totalRectOutputCurrent = totalRectOutputCurrent;
  }


  public double getTeleEnergy() {
    return teleEnergy;
  }

  public void setTeleEnergy(double teleEnergy) {
    this.teleEnergy = teleEnergy;
  }


  public double getInverterInputPower() {
    return inverterInputPower;
  }

  public void setInverterInputPower(double inverterInputPower) {
    this.inverterInputPower = inverterInputPower;
  }


  public double getInverterOutputPower() {
    return inverterOutputPower;
  }

  public void setInverterOutputPower(double inverterOutputPower) {
    this.inverterOutputPower = inverterOutputPower;
  }


  public double getSitebattvolt() {
    return sitebattvolt;
  }

  public void setSitebattvolt(double sitebattvolt) {
    this.sitebattvolt = sitebattvolt;
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


  public long getRectInputRVoltage() {
    return rectInputRVoltage;
  }

  public void setRectInputRVoltage(long rectInputRVoltage) {
    this.rectInputRVoltage = rectInputRVoltage;
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


  public double getDgRAmp() {
    return dgRAmp;
  }

  public void setDgRAmp(double dgRAmp) {
    this.dgRAmp = dgRAmp;
  }


  public double getDgYAmp() {
    return dgYAmp;
  }

  public void setDgYAmp(double dgYAmp) {
    this.dgYAmp = dgYAmp;
  }


  public double getDgBAmp() {
    return dgBAmp;
  }

  public void setDgBAmp(double dgBAmp) {
    this.dgBAmp = dgBAmp;
  }


  public double getActelRCurrent() {
    return actelRCurrent;
  }

  public void setActelRCurrent(double actelRCurrent) {
    this.actelRCurrent = actelRCurrent;
  }


  public double getActelYCurrent() {
    return actelYCurrent;
  }

  public void setActelYCurrent(double actelYCurrent) {
    this.actelYCurrent = actelYCurrent;
  }


  public double getActelBCurrent() {
    return actelBCurrent;
  }

  public void setActelBCurrent(double actelBCurrent) {
    this.actelBCurrent = actelBCurrent;
  }


  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }


  public int getCustomerId() {
    return customerId;
  }

  public void setCustomerId(int customerId) {
    this.customerId = customerId;
  }

}
