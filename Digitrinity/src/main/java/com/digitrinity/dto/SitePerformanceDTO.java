package com.digitrinity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SitePerformanceDTO implements Serializable {
    private String siteId;
    private String startDate;
    private String endDate;

    private enum perfType {SOLAR, GENERATOR, INVERTER, BATTERY, DC, AC};

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
