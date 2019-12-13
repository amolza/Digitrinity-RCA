package com.digitrinity.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SiteTypeDto implements Serializable {
	
	private static final long serialVersionUID = 7007785319737302893L;

	private int id;
	
	private String type;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static List<SiteTypeDto> generate(List<Integer> ids)
	{
		List<SiteTypeDto> siteTypes = new ArrayList<SiteTypeDto>();
		if (ids != null && ids.size() > 0) {
			siteTypes = ids.stream().map(id -> {
				SiteTypeDto siteType = new SiteTypeDto();
				if(1 == id.intValue())
				{
					siteType.setId(id);
					siteType.setType("Hybrid");
				}else if(2 == id.intValue()){
					siteType.setId(id);
					siteType.setType("TEE");
				}
				return siteType;
			}).collect(Collectors.toList());

		}
		return siteTypes;
	}
}
