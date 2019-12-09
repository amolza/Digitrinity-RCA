package com.digitrinity.util;

import java.util.Collection;

public class CollectionUtils
{
	public static boolean isCollectionNullOrEmpty(Collection<?> collection)
	{
		if (collection != null && !collection.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
