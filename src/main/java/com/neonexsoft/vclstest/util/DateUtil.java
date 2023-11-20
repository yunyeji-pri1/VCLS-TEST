package com.neonexsoft.vclstest.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {
    public static long diffOfDate(String begin, String end) throws Exception  {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

        Date beginDate = formatter.parse(begin);
        Date endDate = formatter.parse(end);

        long diff = endDate.getTime() - beginDate.getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000);

        return diffDays;
      }

    public static String addDays(String s, int day) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date date = df.parse(s);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);

        return df.format(cal.getTime());
    }

    public static String dormantDate(int day) throws Exception {
        //long sysDt = System.currentTimeMillis();
        //long dormantSysDt = sysDt + (day * 24 * 60 * 60 * 1000);

        DateFormat df = new SimpleDateFormat("yyyyMMdd");

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, day);

        return df.format(cal.getTime());
    }

    // 현재월 마지막날짜
    public static String getCurrentMonthLastDay() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        String yyyy = format1.format(cal.getTime());
        String mm = format2.format(cal.getTime());

        return getEndDateOfMonth(yyyy, mm);
    }

    // 현재월 첫날짜
    public static String getCurrentMonthFirstDay() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        String yyyy = format1.format(cal.getTime());
        String mm = format2.format(cal.getTime());

        return getFirstDateOfMonth(yyyy, mm);
    }

    // 이전월 첫날짜
    public static String getPreMonthFirstDay() throws Exception {

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("MM");
        String yyyy = format1.format(cal.getTime());
        String mm = format2.format(cal.getTime());

        return getFirstDateOfMonth(yyyy, mm);
    }

    // 지정년월 마지막 날짜
    public static String getEndDateOfMonth(String yyyy, String mm) {

        int day = 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(yyyy), Integer.parseInt(mm)-1, day);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Integer.parseInt(yyyy), Integer.parseInt(mm)-1, cal.getActualMaximum(cal.DAY_OF_MONTH));
        return dateFormat.format(cal2.getTime());
    }

    // 지정년월 첫 날짜
    public static String getFirstDateOfMonth(String yyyy, String mm) {

        int day = 1;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.set(Integer.parseInt(yyyy), Integer.parseInt(mm)-1, day);
        return dateFormat.format(cal.getTime());
    }

    //현재 날짜시간 구하기
    public static String getNowDate() {

        SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
        Calendar time = Calendar.getInstance();

        return format.format(time.getTime());
    }

}
