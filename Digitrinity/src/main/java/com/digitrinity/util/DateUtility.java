package com.digitrinity.util;


import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtility
{
	
	public static Timestamp getCurrentTimestamp() throws ParseException
	{
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar calUs = Calendar.getInstance();
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		int dstOffsetUs = calUs.get(Calendar.DST_OFFSET);
		int zoneOffsetUs = calUs.get(Calendar.ZONE_OFFSET);
		long timeInMillis = cal.getTimeInMillis();
		timeInMillis = timeInMillis + zoneOffset + dstOffset + dstOffsetUs * -1 + -1 * zoneOffsetUs;
		Timestamp timestamp = new Timestamp(timeInMillis);
		return timestamp;
	}
	
	public static String getCurrentDateInDDMMFormat()
	{
		Calendar localCal = Calendar.getInstance();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cal.setTimeInMillis(localCal.getTimeInMillis());
		Date currDate = new Date(cal.getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		formatter.setTimeZone(zone);
		String strDate = formatter.format(currDate);
		return strDate;
	}
	
	public static String getCurrentDateInDDMMMYYFormat()
	{
		Calendar localCal = Calendar.getInstance();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cal.setTimeInMillis(localCal.getTimeInMillis());
		Date currDate = new Date(cal.getTimeInMillis());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		formatter.setTimeZone(zone);
		String strDate = formatter.format(currDate);
		return strDate;
	}
	
	public static String getFirstDayOfMonth()
	{
		Calendar localCal = Calendar.getInstance();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cal.setTimeInMillis(localCal.getTimeInMillis());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		Date currDate = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		sdf.setTimeZone(zone);
		String finaldate = sdf.format(currDate);
		return finaldate;
	}
	
	public static String getLastDayOfMonth()
	{
		Calendar localCal = Calendar.getInstance();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cal.setTimeInMillis(localCal.getTimeInMillis());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date currDate = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		sdf.setTimeZone(zone);
		String finaldate = sdf.format(currDate);
		return finaldate;
	}
	
	public static String getLastDayOfMonthOfNextMonth()
	{
		Calendar localCal = Calendar.getInstance();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cal.setTimeInMillis(localCal.getTimeInMillis());
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		int lastDayOfMonth = getMonthEndByMonth(Calendar.MONTH + 1, Calendar.YEAR);
		cal.set(Calendar.DAY_OF_MONTH, lastDayOfMonth);
		cal.add(Calendar.MONTH, 1);
		Date currDate = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String finaldate = sdf.format(currDate);
		return finaldate;
	}
	
	public static long getCurrentTimeInMillis()
	{
		Calendar localCal = Calendar.getInstance();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		cal.setTimeInMillis(localCal.getTimeInMillis());
		Date currDate = new Date(cal.getTimeInMillis());
		return currDate.getTime();
	}
	
	public static Date getCurrentDate()
	{
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar calUs = Calendar.getInstance();
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		int dstOffsetUs = calUs.get(Calendar.DST_OFFSET);
		int zoneOffsetUs = calUs.get(Calendar.ZONE_OFFSET);
		long timeInMillis = cal.getTimeInMillis();
		timeInMillis = timeInMillis + zoneOffset + dstOffset + dstOffsetUs * -1 + -1 * zoneOffsetUs;
		Date currDate = new Date(timeInMillis);
		return currDate;
	}
	
	public static Date getNextDateByDay(int day)
	{
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar calUs = Calendar.getInstance();
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		int dstOffsetUs = calUs.get(Calendar.DST_OFFSET);
		int zoneOffsetUs = calUs.get(Calendar.ZONE_OFFSET);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, day);
		long timeInMillis = cal.getTimeInMillis();
		timeInMillis = timeInMillis + zoneOffset + dstOffset + dstOffsetUs * -1 + -1 * zoneOffsetUs;
		Date currDate = new Date(timeInMillis);
		return currDate;
	}
	
	public static Date getNextDateByDateAndDay(Date date, int day)
	{
		Calendar cal = Calendar.getInstance();
		long timeMillis = date.getTime();
		cal.setTimeInMillis(timeMillis);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, day);
		long timeInMillis = cal.getTimeInMillis();
		Date currDate = new Date(timeInMillis);
		return currDate;
	}
	
	public static Date getPreviousDateByDay(int day)
	{
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar calUs = Calendar.getInstance();
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		int dstOffsetUs = calUs.get(Calendar.DST_OFFSET);
		int zoneOffsetUs = calUs.get(Calendar.ZONE_OFFSET);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.add(Calendar.DATE, -day);
		long timeInMillis = cal.getTimeInMillis();
		timeInMillis = timeInMillis + zoneOffset + dstOffset + dstOffsetUs * -1 + -1 * zoneOffsetUs;
		Date currDate = new Date(timeInMillis);
		return currDate;
	}
	
	/**
	 * @param strDate
	 * @return
	 */
	public static Date getDateFromTimeStamp(Timestamp timestamp)
	{
		Calendar cal = Calendar.getInstance();
		long timeMillis = timestamp.getTime();
		cal.setTimeInMillis(timeMillis);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Date currDate = new Date(cal.getTimeInMillis());
		return currDate;
	}
	
	public static Date getOnlyDateFromDateTime(Date date)
	{
		Calendar cal = Calendar.getInstance();
		long timeMillis = date.getTime();
		cal.setTimeInMillis(timeMillis);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date currDate = new Date(cal.getTimeInMillis());
		return currDate;
	}
	
	public static Date getOnlyEndOfDateFromDateTime(Date date)
	{
		Calendar cal = Calendar.getInstance();
		long timeMillis = date.getTime();
		cal.setTimeInMillis(timeMillis);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date currDate = new Date(cal.getTimeInMillis());
		return currDate;
	}

	public static java.util.Date getOnlyEndOfDateFromUtilDateTime(java.util.Date date)
	{
		Calendar cal = Calendar.getInstance();
		long timeMillis = date.getTime();
		cal.setTimeInMillis(timeMillis);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		java.util.Date currDate = new Date(cal.getTimeInMillis());
		return currDate;
	}

	public static String getDateAndTimeFromTimeStamp(Timestamp timestamp)
	{
		Calendar cal = Calendar.getInstance();
		long timeMillis = timestamp.getTime();
		cal.setTimeInMillis(timeMillis);
		int day = cal.get(Calendar.DATE);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		String date = day + "/" + (month + 1) + "/" + year + " " + hour + ":" + minute + ":" + sec;
		return date;
	}
	
	// above code tested on server
	
	public static Timestamp getTimestampObject(String strDate)
	{
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "/");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[2], dtArr[1] - 1, dtArr[0]);
		Timestamp dt = new Timestamp(cal.getTimeInMillis());
		return dt;
	}
	
	public static Timestamp getTimestampByMySqlDate(String strDate) throws ParseException
	{
		
		// SimpleDateFormat sdf = new
		// SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date = sdf.parse(strDate);
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		return timestamp;
	}
	
	public static Timestamp getTimestampByOnlyDate(String strDate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(strDate);
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		return timestamp;
	}
	
	public static Timestamp getTimestampObjectForSlashFormat(String strDate)
	{
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "-");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[2], dtArr[1] - 1, dtArr[0]);
		Timestamp dt = new Timestamp(cal.getTimeInMillis());
		return dt;
	}
	
	// @param strDate dd/mm/yyyy
	public static Date getDateObject(String strDate)
	{
		Calendar cal = Calendar.getInstance();
		Date dt = null;
		if (strDate != null && strDate.trim().length() > 0)
		{
			
			StringTokenizer strToken = new StringTokenizer(strDate, "/");
			int[] dtArr = new int[3];
			int i = 0;
			while (strToken.hasMoreTokens())
			{
				dtArr[i] = Integer.parseInt(strToken.nextToken());
				
				i++;
			}
			cal.set(dtArr[2], dtArr[1] - 1, dtArr[0]);
			dt = new Date(cal.getTimeInMillis());
		}
		return dt;
	}
	
	/**
	 * Accepts date in yyyy-mm-dd String format and creates a java.sql.Date object. If error occurs, null is returned.
	 *
	 * @param strDate
	 *            String
	 * @return java.sql.Date
	 */
	public static Date getDateObjectFormat(String strDate)
	{
		// /Calendar cal =
		// Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "-");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[0], dtArr[1] - 1, dtArr[2]);
		Date dt = new Date(cal.getTimeInMillis());
		return dt;
	}
	
	/**
	 * Accepts date in dd-mm-yyy String format and creates a java.sql.Date object. If error occurs, null is returned.
	 *
	 * @param strDate
	 *            String
	 * @return java.sql.Date
	 */
	public static Date getDateObjectFormatDDMMYYYYInDash(String strDate)
	{
		// /Calendar cal =
		// Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "-");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[2], dtArr[1] - 1, dtArr[0]);
		Date dt = new Date(cal.getTimeInMillis());
		return dt;
	}
	
	public static void main(String[] args) throws ParseException
	{
		System.out.println(getCurrentTimestamp());
		
	}
	
	public static String getDateObjectFormatString(String strDate)
	{
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "-");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[0], dtArr[1] - 1, dtArr[2]);
		Date dt = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		sdf.setTimeZone(zone);
		String finaldate = sdf.format(dt);
		return finaldate;
	}
	
	public static Timestamp getTimeStampFromDate(Date strDate)
	{
		Calendar cal = Calendar.getInstance();
		long timeMillis = strDate.getTime();
		cal.setTimeInMillis(timeMillis);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		Timestamp currDate = new Timestamp(cal.getTimeInMillis());
		return currDate;
	}
	
	public static String getDateObjectPaternForDDMMYY(String strDate)
	{
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "-");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[0], dtArr[1] - 1, dtArr[2]);// As date is accepted in
		Date dt = new Date(cal.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		sdf.setTimeZone(zone);
		sdf.format(dt);
		return sdf.format(dt);
	}
	
	public static String getCurrentDateInUniversalFormat()
	{
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		sdfDate.setTimeZone(zone);
		Date now = new Date(Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta")).getTimeInMillis());
		String strDate = sdfDate.format(now);
		return strDate;
	}
	
	public static String getDateObjectPaternForDDMMYY(Date date)
	{
		if (date != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.format(date);
			return sdf.format(date);
		}
		else
			return null;
	}
	
	public static String getDateObjectPaternForDDMMYYDate(java.util.Date date)
	{
		if (date != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.format(date);
			return sdf.format(date);
		}
		else
			return null;
	}

	public static String getDateStringFromTimestamp(Timestamp myTimestamp)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate = format.format(myTimestamp);
		return stringDate;
	}
	
	public static String getStringFromTimestamp(Timestamp myTimestamp)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String stringDate = format.format(myTimestamp);
		return stringDate;
	}
	
	public static Time getTimeInSQLFormat(String time) throws Exception
	{
		if (time != null && !time.equals(""))
		{
			SimpleDateFormat df = new SimpleDateFormat("kk:mm");
			java.util.Date utilDate = df.parse(time);
			java.sql.Time sqlTime = new Time(utilDate.getTime());
			return sqlTime;
		}
		else
			return null;
		
	}
	
	public static int getMonthEndByMonth(int month, int year)
	{
		int monthEnd = 0;
		switch (month)
		{
			case 1:
			{
				monthEnd = 31;
				break;
			}
			case 2:
			{
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
					monthEnd = 29;
				else
					monthEnd = 28;
				break;
			}
			case 3:
			{
				monthEnd = 31;
				break;
			}
			case 4:
			{
				monthEnd = 30;
				break;
			}
			case 5:
			{
				monthEnd = 31;
				break;
			}
			case 6:
			{
				monthEnd = 30;
				break;
			}
			case 7:
			{
				monthEnd = 31;
				break;
			}
			case 8:
			{
				monthEnd = 30;
				break;
			}
			case 9:
			{
				monthEnd = 30;
				break;
			}
			case 10:
			{
				monthEnd = 31;
				break;
			}
			case 11:
			{
				monthEnd = 30;
				break;
			}
			case 12:
			{
				monthEnd = 31;
				break;
			}
		}
		return monthEnd;
	}
	
	public static String getCurrentYear()
	{
		int year = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta")).get(Calendar.YEAR);
		String currentYear = String.valueOf(year);
		return currentYear;
	}
	
	public static int daysBetween(java.util.Date date1, java.util.Date date2)
	{
		return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
	}
	
	public static int yearsBetween(java.util.Date date1, java.util.Date date2)
	{
		return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24) / 365);
	}
	
	public static Date convertUtilToSqlDate(java.util.Date utilDate)
	{
		
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		return sqlDate;
		
	}
	
	public static String getDateObjectPaternForDDMMYYForDateUtil(java.util.Date date)
	{
		if (date != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			sdf.format(date);
			return sdf.format(date);
		}
		else
			return null;
	}
	
	public static String getDateObjectPaternForDDMMYYForDateUtilShlash(java.util.Date date)
	{
		if (date != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.format(date);
			return sdf.format(date);
		}
		else
			return null;
	}
	
	public static String getDateObjectPaternForDDMMMYYForDateUtil(java.util.Date date)
	{
		if (date != null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			sdf.format(date);
			return sdf.format(date);
		}
		else
			return null;
	}
	
	public static Date getDateObjectFormatForDDMMYYYY(String strDate)
	{
		// /Calendar cal =
		// Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "-");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[2], dtArr[1] - 1, dtArr[0]);
		Date dt = new Date(cal.getTimeInMillis());
		return dt;
	}
	
	public static Date getDateObjectFormatDDMMYYYYInShlash(String strDate)
	{
		// /Calendar cal =
		// Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "/");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[2], dtArr[1] - 1, dtArr[0]);
		Date dt = new Date(cal.getTimeInMillis());
		return dt;
	}
	
	public static String getTime()
	{
		SimpleDateFormat localDateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = DateUtility.getCurrentDate();
		return localDateFormat.format(date);
	}
	
	public static Timestamp getTimestampByMySqlDateSlash(String strDate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		java.util.Date date = sdf.parse(strDate);
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		return timestamp;
	}
	public static Timestamp getTimestampByMySqlDateSlashMMDDYY(String strDate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
		java.util.Date date = sdf.parse(strDate);
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		return timestamp;
	}
	public static Timestamp getTimestampByOnlyDateSlash(String strDate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date date = sdf.parse(strDate);
		Timestamp timestamp = new java.sql.Timestamp(date.getTime());
		
		return timestamp;
	}
	
	public static java.util.Date timestampToUtilDate(Timestamp ts)
	{
		try
		{
			return new java.util.Date(ts.getTime());
		}
		catch (Exception e)
		{
			return null;
		}
	}
	
	public static Date getLastDateOfMonth(int year, int month)
	{
		Calendar calendar = new GregorianCalendar(year, month, Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date date = new Date(calendar.getTimeInMillis());
		return date;
	}
	
	public static String getDayNameOfGivenDate(Date inputDate) throws ParseException
	{
		Date date = null;
		// date = new SimpleDateFormat(format).parse(inputDate);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.format(inputDate);
		return new SimpleDateFormat("EEEE", Locale.ENGLISH).format(inputDate);
	}
	
	public static int getDayIntByDayName(String dayName)
	{
		int dayNameInt = 0;
		switch (dayName)
		{
		
			case "Monday":
				dayNameInt = 1;
				break;
			case "Tuesday":
				dayNameInt = 2;
				break;
			case "Wednesday":
				dayNameInt = 3;
				break;
			case "Thursday":
				dayNameInt = 4;
				break;
			case "Friday":
				dayNameInt = 5;
				break;
			case "Saturday":
				dayNameInt = 6;
				break;
			case "Sunday":
				dayNameInt = 7;
				break;
		
		}
		
		return dayNameInt;
		
	}
	
	private static final AtomicLong LAST_TIME_MS = new AtomicLong();
	
	public static long uniqueCurrentTimeMS()
	{
		long now = System.currentTimeMillis();
		while (true)
		{
			long lastTime = LAST_TIME_MS.get();
			if (lastTime >= now)
				now = lastTime + 1;
			if (LAST_TIME_MS.compareAndSet(lastTime, now))
				return now;
		}
	}
	
	public static String getDateStrddmmyyTommddyy(String dateStr)
	{
		if (dateStr != null && !dateStr.isEmpty())
		{
			dateStr = dateStr.trim();
			Date dtFrom = DateUtility.getDateObject(dateStr);
			Calendar cal = Calendar.getInstance();
			cal.setTime(dtFrom);
			int fromYear = cal.get(Calendar.YEAR);
			int fromMonth = cal.get(Calendar.MONTH) + 1;
			int fromDay = cal.get(Calendar.DAY_OF_MONTH);
			dateStr = fromMonth + "-" + fromDay + "-" + fromYear;
		}
		return dateStr;
	}
	
	/*
	 * public static void getDateToStringAnyFormat(java.util.Date) {
	 * 
	 * }
	 */
	public static String getMonth(int month)
	{
		return new DateFormatSymbols().getMonths()[month - 1];
	}
	
	public static String getMonthShortName(int month)
	{
		String monthString = "";
		String[] str = { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" };
		if (month <= str.length)
			monthString = str[month - 1];
		return monthString;
	}
	
	public static String getYearInWords(String year)
	{
		boolean flag = true;
		StringBuilder builder = new StringBuilder();
		String strSecondHalf = year.substring(2, 4);
		if (year.startsWith("190"))
			builder.append("NINTEEN THOUSAND ");
		else
			if (year.startsWith("19"))
				builder.append("NINTEEN ");
			else
				if (year.startsWith("20"))
					builder.append("TWO THOUSAND ");
				else
					flag = false;
		if (flag)
			try
			{
				BigDecimal valDouble = new BigDecimal(strSecondHalf);
				if (!(valDouble.compareTo(BigDecimal.ZERO) == 0))
					builder.append(NumberToWordUtility.convertNumberToWords(valDouble));
			}
			catch (Exception e)
			{
			}
		else
			builder.append("DEFAULT");
		return builder.toString().toUpperCase();
	}
	
	public static String getDateTimeTimestamp(Timestamp myTimestamp)
	{
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String stringDate = format.format(myTimestamp);
		return stringDate;
	}
	
	public static boolean isDateEqual(Date date1, Date date2)
	{
		String date1Str = "";
		String date2Str = "";
		if (date1 != null && date2 != null)
		{
			date1Str = DateUtility.getDateObjectPaternForDDMMYY(date1);
			date2Str = DateUtility.getDateObjectPaternForDDMMYY(date2);
		}
		if (date1Str.equalsIgnoreCase(date2Str))
			return true;
		else
			return false;
	}
	
	public static String getStartWeekDateString(String strDate)
	{
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "-");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[0], dtArr[1] - 1, dtArr[2]);
		Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		
		cal1.setTimeInMillis(cal.getTimeInMillis());
		cal1.set(Calendar.HOUR, 0);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		cal1.set(Calendar.DAY_OF_WEEK, 1);
		Date dt = new Date(cal1.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		sdf.setTimeZone(zone);
		String finaldate = sdf.format(dt);
		return finaldate;
	}
	
	public static String getLastWeekDateString(String strDate)
	{
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "-");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[0], dtArr[1] - 1, dtArr[2]);
		Calendar cal1 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		
		cal1.setTimeInMillis(cal.getTimeInMillis());
		cal1.set(Calendar.HOUR, 0);
		cal1.set(Calendar.HOUR_OF_DAY, 0);
		cal1.set(Calendar.MINUTE, 0);
		cal1.set(Calendar.SECOND, 0);
		cal1.set(Calendar.MILLISECOND, 0);
		cal1.set(Calendar.DAY_OF_WEEK, 7);
		Date dt = new Date(cal1.getTimeInMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		sdf.setTimeZone(zone);
		String finaldate = sdf.format(dt);
		return finaldate;
	}
	
	public static String getDateStringFormatYYYYMMDDInShlash(String strDate)
	{
		// /Calendar cal =
		// Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
		Calendar cal = Calendar.getInstance();
		StringTokenizer strToken = new StringTokenizer(strDate, "/");
		int[] dtArr = new int[3];
		int i = 0;
		while (strToken.hasMoreTokens())
		{
			dtArr[i] = Integer.parseInt(strToken.nextToken());
			i++;
		}
		cal.clear();
		cal.set(dtArr[2], dtArr[1] - 1, dtArr[0]);
		Date dt = new Date(cal.getTimeInMillis());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		TimeZone zone = TimeZone.getTimeZone("Asia/Calcutta");
		sdf.setTimeZone(zone);
		String finaldate = sdf.format(dt);
		return finaldate;
	}

	// new date format with slash(yyyy/MM/dd)
	public static String getDateStringWithSlashFromTimestamp(Timestamp myTimestamp)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		String stringDate = format.format(myTimestamp);
		return stringDate;
	}

	public static java.util.Date getNextYearDate()
	{
		Calendar cal = Calendar.getInstance();
		java.util.Date today = cal.getTime();
		cal.add(Calendar.YEAR, 1); // to get previous year add -1
		java.util.Date nextYear = cal.getTime();
		return nextYear;
	}
	
	public static Date getDateByOnlyDateSlash(Date inputDate) throws ParseException
	{

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateStr = sdf.format(inputDate);
		java.util.Date date = sdf.parse(dateStr);
		convertUtilToSqlDate(date);

		return (Date) date;
	}
	
	public static boolean isDateInBetweenIncludingEndPoints(final java.util.Date min, final java.util.Date max, final java.util.Date date)
	{
		return !(date.before(min) || date.after(max));
	}

	public static boolean isDate2isEarlierThanDate1(String d1, String d2)
	{
		boolean isDate2isEarlierThanDate1 = false;
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			if (sdf.parse(d2).before(sdf.parse(d1)))
				isDate2isEarlierThanDate1 = true;

			if (sdf.parse(d1).after(sdf.parse(d2)))
				isDate2isEarlierThanDate1 = true;
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		
		return isDate2isEarlierThanDate1;
	}
	
	public static List<java.sql.Date> getAllSunday(java.sql.Date academicStartDate, java.sql.Date academicEndDate)
	{

		List<java.sql.Date> allSundayDateList = new ArrayList<java.sql.Date>();
		java.sql.Date startDate = null;
		int dayOfWeek = Calendar.SUNDAY;
		Calendar c1 = Calendar.getInstance();
		c1.setTime(academicStartDate);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(academicEndDate);

		while (c1.before(c2) || c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR) && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
		{
			if (Calendar.SUNDAY == c1.get(Calendar.DAY_OF_WEEK))
			{
				c1.set(Calendar.HOUR_OF_DAY, 0);
				c1.set(Calendar.MINUTE, 0);
				c1.set(Calendar.SECOND, 0);
				c1.set(Calendar.MILLISECOND, 0);
				allSundayDateList.add(DateUtility.convertUtilToSqlDate(c1.getTime()));
			}
			c1.add(Calendar.DATE, 1);
		}
		return allSundayDateList;

	}

	public static List<java.sql.Date> getAllSaturday(java.sql.Date academicStartDate, java.sql.Date academicEndDate)
	{
		List<java.sql.Date> allSaturdayDateList = new ArrayList<java.sql.Date>();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(academicStartDate);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(academicEndDate);

		while (c1.before(c2) || c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR) && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
		{
			if (Calendar.SATURDAY == c1.get(Calendar.DAY_OF_WEEK))
			{
				c1.set(Calendar.HOUR_OF_DAY, 0);
				c1.set(Calendar.MINUTE, 0);
				c1.set(Calendar.SECOND, 0);
				c1.set(Calendar.MILLISECOND, 0);
				allSaturdayDateList.add(DateUtility.convertUtilToSqlDate(c1.getTime()));
			}
			c1.add(Calendar.DATE, 1);
		}
		return allSaturdayDateList;

	}


	public static List<java.sql.Date> getAllDate(java.sql.Date startDate, java.sql.Date endDate)
	{
		List<java.sql.Date> dates = new ArrayList<java.sql.Date>();
		long interval = 24 * 1000 * 60 * 60;
		long endTime = endDate.getTime();
		long curTime = startDate.getTime();
		if (startDate.compareTo(endDate) == 0)
		{
			dates.add(new Date(curTime));
		}
		else
		{

			while (curTime <= endTime)
			{
				dates.add(new Date(curTime));
				curTime += interval;
			}
		}
		return dates;
	}

	public static int getWeek(java.sql.Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		return dayOfWeek;
	}

	public static int getDayOfWeek(java.sql.Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int dayOfWeekCalendar = c.get(Calendar.DAY_OF_WEEK);
		int dayOfWeek = dayOfWeekCalendar - 1;
		return dayOfWeek;
	}

	public static boolean isValidDateRange(java.sql.Date startDate, java.sql.Date endDate)
	{
		boolean checkDate = false;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(startDate);
		cal2.setTime(endDate);
		checkDate = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);

		return checkDate;
	}

	public static java.util.Date convertSqlToUtilDate(java.sql.Date sqlDate)
	{

		java.util.Date utilDate = new java.util.Date(sqlDate.getTime());

		return utilDate;

	}

	public static boolean isWithinRange(Date date, java.sql.Date startDate, java.sql.Date endDate)
	{
		return !(date.before(startDate) || date.after(endDate));
	}

	public static boolean isCurrentMonthWithinRange(java.sql.Date startDate, java.sql.Date endDate)
	{

		boolean checkCurrentMonth = false;
		Calendar c1 = Calendar.getInstance();
		c1.setTime(startDate);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(endDate);

		Calendar cal = Calendar.getInstance();

		while (c1.before(c2))
		{
			if (c1.get(Calendar.MONTH) == cal.get(Calendar.MONTH) && c1.get(Calendar.YEAR) == cal.get(Calendar.YEAR))
			{
				checkCurrentMonth = true;
				break;
			}
			c1.add(Calendar.DATE, 1);
		}

		return checkCurrentMonth;
	}

	public static java.sql.Date isFirstDateinCurrentMonth()
	{

		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, 1);
		java.sql.Date sqlDate = convertUtilToSqlDate(c.getTime());
		return sqlDate;
	}

	public static boolean isValidDateFormatddmmyyyy(String value)
	{
		boolean checkDate = false;

		String regex = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);
		System.out.println(value + " : " + matcher.matches());
		return checkDate = matcher.matches();
	}

	public static String convertStringToDate(java.util.Date date)
	{
		String dateString = null;
		SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");

		try
		{
			dateString = sdfr.format(date);
		}
		catch (Exception ex)
		{
			System.out.println(ex);
		}
		return dateString;
	}

	public static boolean getstartDateAndLastDateOfMonth(String dateStr)
	{
		boolean checkDate = false;
		int month = 0, day = 0, year = 0;

		if (dateStr != null && dateStr.trim().length() > 0)
		{

			StringTokenizer strToken = new StringTokenizer(dateStr, "/");
			int[] dtArr = new int[3];
			int i = 0;
			while (strToken.hasMoreTokens())
			{
				dtArr[i] = Integer.parseInt(strToken.nextToken());

				i++;
			}

			month = dtArr[1];
			day = dtArr[0];
			year = dtArr[2];
			int monthEnd = getMonthEndByMonth(month, year);
			if (month <= 12 && day <= monthEnd && day >= 1)
			{
				checkDate = true;
			}

		}

		return checkDate;
	}

	public static boolean isValidFormatddmmyyyy(String value)
	{
		boolean checkDate = false;

		String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(value);

		return checkDate = matcher.matches();
	}
	
	public static boolean isDateEquals(Date date, java.sql.Date startDate, java.sql.Date endDate)
	{
		boolean checkDate = false;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		cal1.setTime(date);
		cal2.setTime(startDate);
		cal3.setTime(endDate);

		if (cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
				|| cal1.get(Calendar.DAY_OF_YEAR) == cal3.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.YEAR) == cal3.get(Calendar.YEAR))
			checkDate = true;

		return checkDate;
	}
	
	public static boolean isCompareDate(java.sql.Date startDate, java.sql.Date endDate)
	{

		Calendar c1 = Calendar.getInstance();
		c1.setTime(startDate);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(endDate);
		
		return c1.before(c2) || c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR) && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR);
	}

	public static boolean isEquals(Date date, java.sql.Date startDate)
	{
		boolean checkDate = false;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.setTime(date);
		cal2.setTime(startDate);

		if (cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) && cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR))
			checkDate = true;

		return checkDate;
	}
	
	public static int timeDiffranceInSeconds(long d1, long d2)
	{
		int diffrance = 0;
		try
		{

			Date firstParsedDate = new Date(d1);
			Date secondParsedDate = new Date(d2);
			SimpleDateFormat dateFormat = new SimpleDateFormat("ss S");
			long milliseconds = secondParsedDate.getTime() - firstParsedDate.getTime();
			int seconds = (int) milliseconds / 1000;
			System.out.println(" Seconds: " + seconds);
			diffrance = seconds;
			// // calculate hours minutes and seconds
			// int hours = seconds / 3600;
			// int minutes = seconds % 3600 / 60;
			// seconds = seconds % 3600 % 60;
			// System.out.println("Difference: ");
			// System.out.println(" Hours: " + hours);
			// System.out.println(" Minutes: " + minutes);
			// System.out.println(" Seconds: " + seconds);

		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		
		return diffrance;
		
	}
	
	public static Timestamp getDateNextYear()
	{
		Calendar now = Calendar.getInstance();
		now.add(Calendar.YEAR, 1);
		
		long timeInMillis = now.getTimeInMillis();
		
		Timestamp timestamp = new Timestamp(timeInMillis);

		return timestamp;
	}
}
