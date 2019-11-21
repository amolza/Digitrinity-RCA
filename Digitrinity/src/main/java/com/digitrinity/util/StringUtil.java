package com.digitrinity.util;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class StringUtil
{
	public static String checkIsNullOrEmpty(String str)
	{
		if (str != null && !str.equals("null") && !str.equals(""))
		{

			return str;
		}
		else
		{
			return "";
		}
	}

	public static boolean isNullOrEmpty(String str)
	{
		if (str != null && !str.equals("null") && !str.equals(""))
		{
			str = str.trim();
			if (str.length() > 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return true;
		}
	}

	public static boolean isNullOrEmptyOrZero(String str)
	{
		if (str != null && !str.equals("null") && !str.equals("") && !str.equals("0"))
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public static String getFirstWord(String str)
	{
		if (str != null && !str.equals(""))
		{
			String[] strWords = str.split(" ");
			return strWords[0];
		}
		else
		{
			return " ";
		}
	}

	public static String getHipenedString(String str)
	{
		if (str != null && !str.equals(""))
		{
			String genStr = str.replace(" ", "_");
			return genStr;
		}
		else
		{
			return " ";
		}
	}

	public static String getGenFolderName(String subFolderName)
	{
		DateFormat dateFormat = new SimpleDateFormat("MMM-yyyy");
		Date date = new Date();
		String folderName = dateFormat.format(date);
		return folderName + "/" + subFolderName;
	}

	public static String getGenFileName(String extension)
	{
		Long milliSecond = DateUtility.getCurrentTimeInMillis();
		return milliSecond + "." + extension;
	}

	public static String getFileExtension(String fileName)
	{
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public static String[] tokenizeCommaSeparatedStr(String emailListTo)
	{
		
		String[] returnStr = emailListTo.split(",");
		
		List<String> list = new ArrayList<>();
		
		for (String s : returnStr)
		{
			if (s != null && s.length() > 0 && !s.equalsIgnoreCase("a@gmail.com"))
			{
				list.add(s);
			}
		}
		
		returnStr = list.toArray(new String[list.size()]);
		return returnStr;
		
	}

	public static String removeQuotesFromString(String input)
	{
		if (!StringUtil.isNullOrEmpty(input))
		{
			return input.replaceAll("'", "").replaceAll("\"", "");
		}
		else
		{
			return "";
		}
	}


	@SuppressWarnings("rawtypes")
	public static String convertArrayToCommaSeperateString(String[] list)
	{
		int end = list.length;
		StringBuffer ret = new StringBuffer("");
		Set<String> set = new HashSet<>();
		for (int i = 0; i < end; i++)
		{
			set.add(list[i]);
		}

		Iterator it = set.iterator();
		while (it.hasNext())
		{
			ret.append(it.next());
			if (it.hasNext())
			{
				ret.append(',');
			}
		}
		return ret.toString();
	}

	public static String getCommaSepStr(String[] strArr)
	{
		String comaSepStr = "";
		if (strArr != null && strArr.length > 0)
		{
			for (int i = 0; i < strArr.length; i++)
			{
				if (i == strArr.length - 1)
				{
					comaSepStr += strArr[i];
				}
				else
				{
					comaSepStr += strArr[i] + ",";
				}
			}
		}
		return comaSepStr;
	}

	// for Integer
	public static String getCommaSepArrStr(Object[] Arr)
	{
		String comaSepStr = "";
		if (Arr != null && Arr.length > 0)
		{
			for (int i = 0; i < Arr.length; i++)
			{
				if (i == Arr.length - 1)
				{
					comaSepStr += Arr[i];
				}
				else
				{
					comaSepStr += Arr[i] + ",";
				}
			}
		}
		return comaSepStr;
	}

	// matches 10-digit numbers only
	public static boolean isValidMobileNo(String mobStr)
	{
		String mobRegexStr = "^[0-9]{10}$";
		boolean mobNoValid = false;
		if (mobStr != null && !mobStr.equals(""))
		{
			if (mobStr.matches(mobRegexStr))
			{
				mobNoValid = true;
			}
		}
		return mobNoValid;
	}


	public static boolean isValidEmailAddress(String email)
	{
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	public static String getNextNumberStr(String noStr)
	{
		String genNoStr = "";
		int noCount = Integer.parseInt(noStr);
		genNoStr = String.format("%0" + noStr.length() + "d", noCount + 1);
		return genNoStr;
	}

	public static String arrayToCSV(String[] array)
	{
		String result = "";
		if (array.length > 0)
		{
			StringBuilder sb = new StringBuilder();
			for (String s : array)
			{
				sb.append(s).append(",");
			}
			result = sb.deleteCharAt(sb.length() - 1).toString();
		}
		return result;
	}

	public static String replaceStringCharWithChar(String valueStr, String placeStr, String replaceStr)
	{
		if (valueStr != null && !valueStr.isEmpty())
		{
			return valueStr = valueStr.replaceAll(placeStr, replaceStr);

		}
		else
		{
			return valueStr;
		}
	}

	// Method for Emoji removal.

	// for validation of special character 2 apr 2018
	public static boolean isSpecialChar(String str)
	{
		if (str == "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)")
		{
			return false;
		}
		else
		{
			return true;
		}

	}

	public static String getLabelValue(HttpServletRequest request, String labelKey)
	{
		return getLabelValue(request.getSession(), labelKey);
	}

	public static String getLabelValue(HttpSession session, String labelKey)
	{
		// Get the Label values to be printed.
		@SuppressWarnings("unchecked")
		Map<String, String> hmLabel = (HashMap<String, String>) session.getAttribute("LABEL_VALUES");
		// Map<String, String> hmLabel = (HashMap<String, String>) session.getAttribute("LANGUAGE_LABEL_VALUES");
		
		return hmLabel.get(labelKey);
	}

	public static boolean isStringContainsSpecialCharactersr(String str)
	{
		Pattern pattern = Pattern.compile("^[a-zA-Z_0-9 -()&,]*$");
		Pattern pattern1 = Pattern.compile("^[0-9_ -()&,]*$");

		Matcher matcher = pattern.matcher(str);
		Matcher matcher1 = pattern1.matcher(str);
		if (!matcher.matches())
		{
			return false;
		}
		else
			if (matcher1.matches())
			{
				return false;
			}
			else
			{
				return true;
			}

	}
	
	public static boolean isValidNo(String str)
	{
		String regexStr = "[0-9]+";
		boolean noValid = false;
		if (str != null && !str.equals(""))
		{
			if (str.matches(regexStr))
			{
				noValid = true;
			}
		}
		return noValid;
	}
	
}
