package com.reportgenerator.datafactory.serviceImpl;

import com.reportgenerator.datafactory.service.ContentDataValues;

public class ContentDataValuesImpl implements ContentDataValues{
	
	private static String[] yearPassOut = {"2001", "2002", "2003", "2004", "2005" , "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018"};

	private static String[] operatingYear = {"200101", "200102", "200103", "200104","200105","200106","200107","200108","200109","200110","200111","200112", "200201", "200202", "200203", "200204", "200205", "200206" , "200207" ,"200208", "200209", "200210","200211","200211","200212", "200301", "200302", "200303", "200304", "200305", "200306" , "200307" ,"200308", "200309", "200310","200311","200311","200312", "200401", "200402", "200403", "200404", "200405", "200406" , "200407" ,"200408", "200409", "200410","200411","200411","200412", "200501", "200502", "200601", "200602"};
	
	public String[] getOperatingYear() {
		return operatingYear;
	}

	public String[] getYearPassOut() {
		return yearPassOut;
	}
}

