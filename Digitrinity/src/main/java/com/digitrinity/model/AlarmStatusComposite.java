package com.digitrinity.model;

import java.io.Serializable;

public class AlarmStatusComposite implements Serializable {

	private String alOpentime;
	
	private String smSiteCode;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alOpentime == null) ? 0 : alOpentime.hashCode());
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
		AlarmStatusComposite other = (AlarmStatusComposite) obj;
		if (alOpentime == null) {
			if (other.alOpentime != null)
				return false;
		} else if (!alOpentime.equals(other.alOpentime))
			return false;
		if (smSiteCode == null) {
			if (other.smSiteCode != null)
				return false;
		} else if (!smSiteCode.equals(other.smSiteCode))
			return false;
		return true;
	}
	
	
}
