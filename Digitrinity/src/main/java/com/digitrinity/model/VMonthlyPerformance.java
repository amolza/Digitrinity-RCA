package com.digitrinity.model;

import org.springframework.data.annotation.Immutable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "V_monthlyPerformance")
public class VMonthlyPerformance {
    @Id
    private String smSiteCode;
    private long tranMonth;
    private double mdgEnergy;
    private double dgEnergy;
    private double opco1Energy;
    private double opco2Energy;
    private double opco3Energy;
    private double opco4Energy;
    private double totalDcLoadEnergyConsumption;
    private double battDisEnergy;
    private double battChargingEnergy;
    private double communityLoadEnergy;
    private double teleEnergy;
    private double inverterEnergy;
    private double solarOutputEnergy;
    private double solarInputEnergy;


    public String getSmSiteCode() {
        return smSiteCode;
    }

    public void setSmSiteCode(String smSiteCode) {
        this.smSiteCode = smSiteCode;
    }


    public long getTranMonth() {
        return tranMonth;
    }

    public void setTranMonth(long tranMonth) {
        this.tranMonth = tranMonth;
    }


    public double getMdgEnergy() {
        return mdgEnergy;
    }

    public void setMdgEnergy(double mdgEnergy) {
        this.mdgEnergy = mdgEnergy;
    }


    public double getDgEnergy() {
        return dgEnergy;
    }

    public void setDgEnergy(double dgEnergy) {
        this.dgEnergy = dgEnergy;
    }


    public double getOpco1Energy() {
        return opco1Energy;
    }

    public void setOpco1Energy(double opco1Energy) {
        this.opco1Energy = opco1Energy;
    }


    public double getOpco2Energy() {
        return opco2Energy;
    }

    public void setOpco2Energy(double opco2Energy) {
        this.opco2Energy = opco2Energy;
    }


    public double getOpco3Energy() {
        return opco3Energy;
    }

    public void setOpco3Energy(double opco3Energy) {
        this.opco3Energy = opco3Energy;
    }


    public double getOpco4Energy() {
        return opco4Energy;
    }

    public void setOpco4Energy(double opco4Energy) {
        this.opco4Energy = opco4Energy;
    }


    public double getTotalDcLoadEnergyConsumption() {
        return totalDcLoadEnergyConsumption;
    }

    public void setTotalDcLoadEnergyConsumption(double totalDcLoadEnergyConsumption) {
        this.totalDcLoadEnergyConsumption = totalDcLoadEnergyConsumption;
    }


    public double getBattDisEnergy() {
        return battDisEnergy;
    }

    public void setBattDisEnergy(double battDisEnergy) {
        this.battDisEnergy = battDisEnergy;
    }


    public double getBattChargingEnergy() {
        return battChargingEnergy;
    }

    public void setBattChargingEnergy(double battChargingEnergy) {
        this.battChargingEnergy = battChargingEnergy;
    }


    public double getCommunityLoadEnergy() {
        return communityLoadEnergy;
    }

    public void setCommunityLoadEnergy(double communityLoadEnergy) {
        this.communityLoadEnergy = communityLoadEnergy;
    }


    public double getTeleEnergy() {
        return teleEnergy;
    }

    public void setTeleEnergy(double teleEnergy) {
        this.teleEnergy = teleEnergy;
    }


    public double getInverterEnergy() {
        return inverterEnergy;
    }

    public void setInverterEnergy(double inverterEnergy) {
        this.inverterEnergy = inverterEnergy;
    }


    public double getSolarOutputEnergy() {
        return solarOutputEnergy;
    }

    public void setSolarOutputEnergy(double solarOutputEnergy) {
        this.solarOutputEnergy = solarOutputEnergy;
    }


    public double getSolarInputEnergy() {
        return solarInputEnergy;
    }

    public void setSolarInputEnergy(double solarInputEnergy) {
        this.solarInputEnergy = solarInputEnergy;
    }

  @Override
  public String toString() {
    return "VMonthlyPerformance{" +
            "smSiteCode='" + smSiteCode + '\'' +
            ", tranMonth=" + tranMonth +
            ", mdgEnergy=" + mdgEnergy +
            ", dgEnergy=" + dgEnergy +
            ", opco1Energy=" + opco1Energy +
            ", opco2Energy=" + opco2Energy +
            ", opco3Energy=" + opco3Energy +
            ", opco4Energy=" + opco4Energy +
            ", totalDcLoadEnergyConsumption=" + totalDcLoadEnergyConsumption +
            ", battDisEnergy=" + battDisEnergy +
            ", battChargingEnergy=" + battChargingEnergy +
            ", communityLoadEnergy=" + communityLoadEnergy +
            ", teleEnergy=" + teleEnergy +
            ", inverterEnergy=" + inverterEnergy +
            ", solarOutputEnergy=" + solarOutputEnergy +
            ", solarInputEnergy=" + solarInputEnergy +
            '}';
  }
}
