package com.caccia.david.okrs_demo_0.demo.report.factories;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringFormatConstants
{
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String REPORT_ID_KEY = "Report ID: ";
    public static final String OBJECTIVE_ID_KEY = "Objective ID: ";
    public static final String KEY_RESULT_ID_KEY = "Key Result ID: ";
    public static final String NODE_SEPARATOR = "====================================================================" + LINE_SEPARATOR;
    public static final String TEAM_REPORT = "Team Report: ";
    public static final String CHAINED_REPORTS = "Chained Reports: ";
    public static final String SUBSCRIBED_REPORTS = "Subscribed Reports: ";
    public static final String SPACES = "     ";
    public static final String DATE = "Last updated: ";
    public static final String LINK = "Link: ";

    public static final String DATE_PATTERN = "yyyy-MM-dd:hh-mm";

    public static final String ID_DATE_FORMAT = "%s%s" + SPACES + DATE + "%s"; // id key, id value, spaces, date key, date value


    public static String getTime(Date date)
    {
        DateFormat df = new SimpleDateFormat(DATE_PATTERN);
        return df.format(date);
    }

}
