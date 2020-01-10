package com.digitrinity.model;

import java.io.Serializable;

public class LatestDataReportComposite implements Serializable {

	private String lastUpdated;
	
	private String smSiteCode;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lastUpdated == null) ? 0 : lastUpdated.hashCode());
		result = prime * result + ((smSiteCode == null) ? 0 : smSiteCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LatestDataReportComposite other = (LatestDataReportComposite) obj;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (smSiteCode == null) {
			if (other.smSiteCode != null)
				return false;
		} else if (!smSiteCode.equals(other.smSiteCode))
			return false;
		return true;
	}
	
	
}
