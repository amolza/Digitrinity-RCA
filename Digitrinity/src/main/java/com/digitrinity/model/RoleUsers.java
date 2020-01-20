package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE_USERS")
public class RoleUsers {
@Id
@Column(name = "role_id")
  private long roleId;
  @Column(name = "role_name")
  private String roleName;
  @Column(name = "tee")
  private long tee;
  @Column(name = "hybrid")
  private long hybrid;
  @Column(name = "lithium_ion")
  private long lithiumIon;
  @Column(name = "rca")
  private long rca;
  @Column(name = "site_wise")
  private String siteWise;
  @Column(name = "region")
  private String region;

  @Override
  public String toString() {
    return "RoleUsers{" +
            "roleId=" + roleId +
            ", roleName='" + roleName + '\'' +
            ", tee=" + tee +
            ", hybrid=" + hybrid +
            ", lithiumIon=" + lithiumIon +
            ", rca=" + rca +
            ", siteWise='" + siteWise + '\'' +
            ", region='" + region + '\'' +
            '}';
  }

  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public long getTee() {
    return tee;
  }

  public void setTee(long tee) {
    this.tee = tee;
  }


  public long getHybrid() {
    return hybrid;
  }

  public void setHybrid(long hybrid) {
    this.hybrid = hybrid;
  }


  public long getLithiumIon() {
    return lithiumIon;
  }

  public void setLithiumIon(long lithiumIon) {
    this.lithiumIon = lithiumIon;
  }


  public long getRca() {
    return rca;
  }

  public void setRca(long rca) {
    this.rca = rca;
  }


  public String getSiteWise() {
    return siteWise;
  }

  public void setSiteWise(String siteWise) {
    this.siteWise = siteWise;
  }


  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

}
