package com.digitrinity.model;

import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "V_hourlyPerformance")
public class VHourlyPerformance {
    @Id
    @Column(name = "smSiteCode")
    private String smSiteCode;

    @Column(name = "date_hour")
    private String dateHour;

    @Column(name = "MDG_Energy")
    private double mdgEnergy;

    @Column(name = "dg_energy")
    private double dgEnergy;

    @Column(name = "opco_1_energy")
    private double opco1Energy;

    @Column(name = "opco_2_energy")
    private double opco2Energy;

    @Column(name = "opco_3_energy")
    private double opco3Energy;

    @Column(name = "opco_4_energy")
    private double opco4Energy;

    @Column(name = "Total_DCLoad_Energy_consumption")
    private double totalDcLoadEnergyConsumption;

    @Column(name = "batt_disenergy")
    private double battDisEnergy;

    @Column(name = "batt_chargingenergy")
    private double battChargingEnergy;

    @Column(name = "communityload_energy")
    private double communityLoadEnergy;

    @Column(name = "teleenergy")
    private double teleEnergy;

    @Column(name = "inverterenergy")
    private double inverterEnergy;

    @Column(name = "solar_output_energy")
    private double solarOutputEnergy;

    @Column(name = "solar_input_energy")
    private double solarInputEnergy;

    public String getSmSiteCode() {
        return smSiteCode;
    }

    public void setSmSiteCode(String smSiteCode) {
        this.smSiteCode = smSiteCode;
    }


    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
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
    return "VHourlyPerformance{" +
            "smSiteCode='" + smSiteCode + '\'' +
            ", dateHour='" + dateHour + '\'' +
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
