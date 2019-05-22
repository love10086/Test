package com.gemall.library.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TimeUtil {
    //将字符串转为时间戳
    public static long getStringToDate(String dateString, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = new Date();
        try{
            date = dateFormat.parse(dateString);
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    //时间戳转Calendar
    public static Calendar getCalendarTime(long time) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }

    /**
     * 将长时间格式字符串转换为时间(HH:mm)
     */
    public static String getStringTime(Long date) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 将时间格式yyyy-MM-ddTHH:mm:ss.ss(2017-06-21T21:25:49.62)转换成yyyy-MM-dd HH:mm:ss
     * @param dateStr
     * @return
     */
    public static String getStrDateTime(String dateStr){
        try {
            String newTimeStr = dateStr.substring(0, 19).replace("T", " ");
            return newTimeStr;
        }catch (Exception e){
            e.printStackTrace();
            return dateStr;
        }
    }

    /**
     * 将时间格式yyyy-MM-ddTHH:mm:ss.ss(2017-06-21T21:25:49.62)转换成yyyy-MM-dd
     * @param dateStr
     * @return
     */
    public static String getStrDateTimeNYR(String dateStr){
        try {
            String newTimeStr = dateStr.substring(0, 10);
            return newTimeStr;
        }catch (Exception e){
            e.printStackTrace();
            return dateStr;
        }
    }

    /**
     * 将时间格式yyyy-MM-ddTHH:mm:ss.ss(2017-06-21T21:25:49.62)转换成yyyy.MM.dd
     * @param dateStr
     * @return
     */
    public static String getStrDateNYR(String dateStr) {
        try {
            String date = getStrDateTimeNYR(dateStr);
            String replaceDATE = date.replace("-", ".");
            return replaceDATE;
        } catch (Exception e) {
            e.printStackTrace();
            return dateStr;
        }
    }

    /**
     * 将时间格式字符串转换为时间(MM)
     */
    public static String getStringMonth(int month) {
        String dateString = "" + month;
        if (month >= 1 && month <= 9) {
            dateString = "0" + month;
        }
        return dateString;
    }

    /**
     * 设置一进入dialog时显示的时间，分钟取整，并且延后两小时
     */
    public static long getCurDefaultTime(long curTime) {
        String timeStr = getStringTime(curTime);
        // 分取系统时间 小时分
        String[] timeArray = new String[]{};
        timeArray = timeStr.split(":");
        int minute = Integer.parseInt(timeArray[1]);
        int value = 0;
        if (minute >= 0 && minute < 15) {
            value = 15 - minute;
        } else if (minute >= 15 && minute < 30) {
            value = 30 - minute;
        } else if (minute >= 30 && minute < 45) {
            value = 45 - minute;
        } else if (minute >= 45 && minute < 60) {
            value = 60 - minute;
        }
        curTime = curTime + (2 * 60 + value) * 60 * 1000;
        return curTime;
    }

    /**
     * 设置一进入dialog时显示的时间，分钟取整，并且延后一小时
     */
    public static String getStringCurDefaultTime(String curTime) {
        if (curTime != null && !curTime.equals("")) {
            // 分取系统时间 小时分
            String[] timeArray = new String[]{};
            timeArray = curTime.split(":");
            int minute = Integer.parseInt(timeArray[1]);
            int hour = Integer.parseInt(timeArray[0]);
            if (minute > 0 && minute <= 20) {
                minute = 20;
            } else if (minute > 20 && minute <= 40) {
                minute = 40;
            } else if (minute > 40 && minute <= 59) {
//                minute = 45;
//            } else if (minute > 45 && minute < 60) {
                minute = 0;
                hour += 1;
            }
            hour += 1; // 往后推1小时
            curTime = hour + ":" + minute;
            return curTime;
        }
        return "";
    }

    /**
     * 获取配送时间区间,
     * 这个方法会裁决掉过去的时间。
     * 即是以当前的时间为开端
     */
    public static List<String> getTimeInterval(String startTime, String businessOverTime) {
        List<String> timeInterval = new ArrayList<String>();
        // 分取系统时间 小时分
        String[] startTimeArray = new String[]{};
        String[] overTimeArray = new String[]{};
        startTimeArray = startTime.split(":");
        overTimeArray = businessOverTime.split(":");
        //add ke start 2017.8.18
        String[] nowTimeArray = new String[]{};
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Date curDate =new Date(System.currentTimeMillis());//获取当前时间
        String nowTime  = formatter.format(curDate);
        nowTimeArray = nowTime.split(":");
        //进行判断，如果开始时间比现在当前的时间小，直接用当前时间开始。
        if (Integer.parseInt(nowTimeArray[0])>Integer.parseInt(startTimeArray[0])){
            startTimeArray=nowTimeArray;
        }else if (Integer.parseInt(nowTimeArray[0])==Integer.parseInt(startTimeArray[0])){
            if (Integer.parseInt(nowTimeArray[1]) > Integer.parseInt(startTimeArray[1])){
                startTimeArray=nowTimeArray;
            }
        }
        //add ke end 2017.8.18
        int startHour = Integer.parseInt(startTimeArray[0]);
        int overHour = Integer.parseInt(overTimeArray[0]);
        int startMinute = Integer.parseInt(startTimeArray[1]);
        int overMinute = Integer.parseInt(overTimeArray[1]);
        if (startMinute > 40) {
            startHour += 1;
        }
        startMinute = getStartMinute(startMinute);
        overMinute = getOverMinute(overMinute);
        startTime = startHour + ":" + startMinute;
        businessOverTime = overHour + ":" + overMinute;

        long start = getLongTime(startTime);
        long overTime = getLongTime(businessOverTime);
        boolean isCorrectTime = isCorrectTime(startTime, businessOverTime);
        if (isCorrectTime == false) {
            overTime = overTime + 24 * 60 * 60 * 1000;
        }
        long interval = 20 * 60 * 1000;
        int cycles = (int) ((overTime - start) / interval);
        long time = start;
        for (int i = 0; i <= cycles; i++) {
            String timeStr = getStringTime(time);
            timeInterval.add(timeStr);
            time += interval;
        }
        return timeInterval;
    }


    /**
     * 获取到店取货时间区间
     */
    public static List<String> getTimeIntervals(String startTime, String businessOverTime) {
        List<String> timeInterval = new ArrayList<String>();
        // 分取系统时间 小时分
        String[] startTimeArray = new String[]{};
        String[] overTimeArray = new String[]{};
        startTimeArray = startTime.split(":");
        overTimeArray = businessOverTime.split(":");
        int startHour = Integer.parseInt(startTimeArray[0]);
        int overHour = Integer.parseInt(overTimeArray[0]);
        int startMinute = Integer.parseInt(startTimeArray[1]);
        int overMinute = Integer.parseInt(overTimeArray[1]);
        if (startMinute > 40) {
            startHour += 1;
        }
        startMinute = getStartMinute(startMinute);
        overMinute = getOverMinute(overMinute);
        startTime = startHour + ":" + startMinute;
        businessOverTime = overHour + ":" + overMinute;

        long start = getLongTime(startTime);
        long overTime = getLongTime(businessOverTime);
        boolean isCorrectTime = isCorrectTime(startTime, businessOverTime);
        if (isCorrectTime == false) {
            overTime = overTime + 24 * 60 * 60 * 1000;
        }
        long interval = 20 * 60 * 1000;
        int cycles = (int) ((overTime - start) / interval);
        long time = start;
        for (int i = 0; i <= cycles; i++) {
            String timeStr = getStringTime(time);
            timeInterval.add(timeStr);
            time += interval;
        }
        return timeInterval;
    }

    /**
     * 获取日期区间
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static List<String> getDayInterval(int year, int month, int day) {
        List<String> dateInterval = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            String monthStr = getStringMonth(month);
            String dayStr = getStringMonth(day);
            String date = monthStr + "/" + dayStr;
            dateInterval.add(date);
            day += 1;
            List<Integer> curDateList = getCurDate(year, month, day);
            day = curDateList.get(0);
            month = curDateList.get(1);
            year = curDateList.get(2);
        }
        return dateInterval;
    }

    /**
     * 获取年月日
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static List<Integer> getCurDate(int year, int month, int day) {
        int februaryDay = 28;
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) { // 判断该年份是闰年
            februaryDay = 29;
        }
        switch (month) {
            case 2:
                if (day > februaryDay) {
                    month += 1;
                    day -= februaryDay;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    month += 1;
                    day -= 30;
                }
                break;
            default:
                if (day > 31) {
                    month += 1;
                    day -= 31;
                }
                break;
        }

        if (month > 12) {
            month -= 12;
        }
        List<Integer> dateList = new ArrayList<Integer>();
        dateList.add(day);
        dateList.add(month);
        dateList.add(year);
        return dateList;
    }


    /**
     * 获取开始时间的分钟值
     * @param minute
     * @return
     */
    public static int getStartMinute(int minute) {
        if (minute == 0 || minute > 40 && minute <= 59) {
            minute = 0;
        } else if (minute > 0 && minute <= 20) {
            minute = 20;
        } else if (minute > 20 && minute <= 40) {
            minute = 40;
        }
        return minute;
    }

    /**
     * 获取结束时间的分钟值
     *
     * @param overMinute
     * @return
     */
    public static int getOverMinute(int overMinute) {
        if (overMinute >= 0 && overMinute < 20) {
            overMinute = 0;
        } else if (overMinute >= 20 && overMinute < 40) {
            overMinute = 20;
        } else if (overMinute >= 40 && overMinute < 59) {
            overMinute = 40;
        }
        return overMinute;
    }

    /**
     * 获取长整型时间格式
     *
     * @param timeStr
     * @return
     */
    public static long getLongTime(String timeStr) {
        long timeL = 0;
        SimpleDateFormat sf = new SimpleDateFormat("HH:mm");
        try {
            Date date = sf.parse(timeStr);
            timeL = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeL;
    }


    /**
     * 获取营业时间
     *
     * @param time
     * @return
     */
    public static List<String> getStoreTime(String time) {
        // TODO Auto-generated method stub
        String[] timeArray = new String[]{};
        timeArray = time.split("-");
        String openTime = timeArray[0];
        String closeTime = timeArray[1];
        List<String> list = new ArrayList<String>();
        list.add(openTime);
        list.add(closeTime);
        return list;
    }

    /*
     * 获取开始时间与结束时间的时分区间，判断时间是否在区间之类
     */
    public static boolean checkBusinessTime(String businessTime) {
        if (null == businessTime || "".equals(businessTime))
            return true;// 没时间,默认显示24小时营业
        SimpleDateFormat formatters = new SimpleDateFormat("HH:mm");
        Date curDates = new Date(System.currentTimeMillis());
        String curTime = formatters.format(curDates);
        String[] curTimeArray = new String[]{};
        // 分取系统时间 小时分
        curTimeArray = curTime.split(":");
        int curHour = Integer.parseInt(curTimeArray[0]);
        int curMinute = Integer.parseInt(curTimeArray[1]);
        // 营业时间段
        String[] businessTimeaArray = new String[]{};
        businessTimeaArray = businessTime.split("-");
        // 开始营业时间点
        String startTime = businessTimeaArray[0];
        String[] startbusinessTimeArray = new String[]{};
        // 分取系统时间 小时分
        startbusinessTimeArray = startTime.split(":");
        int startHour = Integer.parseInt(startbusinessTimeArray[0]);
        int startMinute = Integer.parseInt(startbusinessTimeArray[1]);
        // 结束营业时间点
        String endTime = businessTimeaArray[1];
        String[] endbusinessTimeArray = new String[]{};
        // 分取系统时间 小时分
        endbusinessTimeArray = endTime.split(":");
        int endHour = Integer.parseInt(endbusinessTimeArray[0]);
        int endMinute = Integer.parseInt(endbusinessTimeArray[1]);
        return isIncludeTime(curHour, curMinute, startHour, startMinute, endHour, endMinute);
    }

    /**
     * @Title: isIncludeTime @Description: TODO
     * (判断是否在时间区间内，用在微小企的商铺详情) @return @return boolean @throws
     */
    public static boolean isIncludeTime(int curHour, int curMinute, int startHour, int startMinute, int endHour,
                                        int endMinute) {
        if (curHour > startHour && curHour < endHour) {
            return true;
        } else if (curHour == startHour && curMinute >= startMinute) {
            return true;
        } else return curHour == endHour && curMinute <= endMinute;
    }

    /**
     * @Title: isCorrectTime @Description: TODO
     * (判断是否是正确的时间区间，用在微小企的订单配送时间) @return @return boolean @throws
     */
    public static boolean isCorrectTime(String startTime, String overTime) {
        List<Integer> startList = getIntTime(startTime);
        List<Integer> overList = getIntTime(overTime);

        int startHour = startList.get(0);
        int startMinute = startList.get(1);
        int endHour = overList.get(0);
        int endMinute = overList.get(1);
        if (startHour == endHour) {
            return startMinute <= endMinute;
        } else return startHour < endHour;
    }

    /**
     * @param time
     * @param backArray
     * @param fortArray
     * @param isCorrectTime
     * @Title: getIntValue @Description: TODO
     * (计算当前时间在营业时间段中属于第几个区间，用在微小企的提交订单页面选择时间) @return @return
     * int @throws
     */
    private static int getIntValue(boolean isDelivery, boolean isCorrectTime, List<String> dateTimes,
                                   List<String> fortArray, List<String> backArray, String time) {
        int value = 0;
        if (isCorrectTime == false) {
            boolean isFront = false;
            boolean isBack = false;
            for (int i = 0; i < fortArray.size(); i++) {
                isFront = getIntValueMethod(isDelivery, fortArray.get(i), time);// 判断是否属于前一天的时间段
                if (isFront == true) {
                    value = i;
                    break;
                }
            }
            for (int i = 0; i < backArray.size(); i++) {
                isBack = getIntValueMethod(isDelivery, backArray.get(i), time);// 判断是否属于凌晨的时间段
                if (isBack == true) {
                    value = i + fortArray.size();
                    break;
                }
            }
            if (isFront == false && isBack == false) {
                value = 0;
            }
        } else {
            for (int i = 0; i < dateTimes.size(); i++) {
                String dateTime = dateTimes.get(i);
                boolean more = getIntValueMethod(isDelivery, dateTime, time);
                if (more == true) {
                    value = i;
                    break;
                }
            }
        }
        return value;
    }

    /**
     * 根据订单选择送货或者到店方式来计算Value值方法
     *
     * @param isDelivery
     * @param dateTime
     * @param time
     * @return
     */
    private static boolean getIntValueMethod(boolean isDelivery, String dateTime, String time) {
        if (isDelivery == true) { // 配送
            return isMoreTime(dateTime, time);
        } else {
            return isIntValue(dateTime, time);
        }

    }

    /**
     * @Title: isCorrectTime @Description: TODO
     * (判断是时间的大小，用在微小企的订单到店时间) @return @return boolean @throws
     */
    public static boolean isIntValue(String startTime, String overTime) {
        List<Integer> startList = getIntTime(startTime);
        List<Integer> overList = getIntTime(overTime);

        int startHour = startList.get(0);
        int startMinute = startList.get(1);
        int endHour = overList.get(0);
        int endMinute = overList.get(1);

        int time1 = startHour * 60 + startMinute;
        int time2 = endHour * 60 + endMinute;
        return time1 > time2;
    }

    /**
     * @Title: isCorrectTime @Description: TODO
     * (判断是时间的大小，用在微小企的订单到店时间) @return @return boolean @throws
     */
    public static boolean isMoreTime(String startTime, String overTime) {
        List<Integer> startList = getIntTime(startTime);
        List<Integer> overList = getIntTime(overTime);

        int startHour = startList.get(0);
        int startMinute = startList.get(1);
        int endHour = overList.get(0);
        int endMinute = overList.get(1);

        int time1 = startHour * 60 + startMinute;
        int time2 = endHour * 60 + endMinute;
        return time1 >= time2;
    }

    /**
     * 获取时间的分钟值
     *
     * @param overMinute
     * @return
     */
    public static int getIntMinute(int overMinute) {
        if (overMinute >= 0 && overMinute < 15) {
            overMinute = 0;
        } else if (overMinute >= 15 && overMinute < 30) {
            overMinute = 15;
        } else if (overMinute >= 30 && overMinute < 45) {
            overMinute = 30;
        } else if (overMinute >= 45 && overMinute < 60) {
            overMinute = 45;
        }
        return overMinute;
    }

    public static List<Integer> getIntTime(String time) {
        String[] timeArray = new String[]{};
        timeArray = time.split(":");
        int hour = Integer.parseInt(timeArray[0]);
        int minute = Integer.parseInt(timeArray[1]);
        List<Integer> list = new ArrayList<Integer>();
        list.add(hour);
        list.add(minute);
        return list;
    }


    /**
     * 判断是否为今天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean IsToday(String day) throws ParseException {

        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);
        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);
        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            return diffDay == 0;
        }
        return false;
    }

    /**
     * 判断是否为昨天(效率比较高)
     *
     * @param day 传入的 时间  "2016-06-28 10:10:30" "2016-06-28" 都可以
     * @return true今天 false不是
     * @throws ParseException
     */
    public static boolean IsYesterday(String day) throws ParseException {

        Calendar pre = Calendar.getInstance();
        Date predate = new Date(System.currentTimeMillis());
        pre.setTime(predate);

        Calendar cal = Calendar.getInstance();
        Date date = getDateFormat().parse(day);
        cal.setTime(date);

        if (cal.get(Calendar.YEAR) == (pre.get(Calendar.YEAR))) {
            int diffDay = cal.get(Calendar.DAY_OF_YEAR)
                    - pre.get(Calendar.DAY_OF_YEAR);

            return diffDay == -1;
        }
        return false;
    }
    public static SimpleDateFormat getDateFormat() {
        if (null == DateLocal.get()) {
            DateLocal.set(new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA));
        }
        return DateLocal.get();
    }
    private static ThreadLocal<SimpleDateFormat> DateLocal = new ThreadLocal<SimpleDateFormat>();

    //根据秒数转化为时分秒   00:00:00
    public static String getTime(int second) {
        if (second < 10) {
            return "00:0" + second;
        }
        if (second < 60) {
            return "00:" + second;
        }
        if (second < 3600) {
            int minute = second / 60;
            second = second - minute * 60;
            if (minute < 10) {
                if (second < 10) {
                    return "0" + minute + ":0" + second;
                }
                return "0" + minute + ":" + second;
            }
            if (second < 10) {
                return minute + ":0" + second;
            }
            return minute + ":" + second;
        }
        int hour = second / 3600;
        int minute = (second - hour * 3600) / 60;
        second = second - hour * 3600 - minute * 60;
        if (hour < 10) {
            if (minute < 10) {
                if (second < 10) {
                    return "0" + hour + ":0" + minute + ":0" + second;
                }
                return "0" + hour + ":0" + minute + ":" + second;
            }
            if (second < 10) {
                return "0" + hour + minute + ":0" + second;
            }
            return "0" + hour + minute + ":" + second;
        }
        if (minute < 10) {
            if (second < 10) {
                return hour + ":0" + minute + ":0" + second;
            }
            return hour + ":0" + minute + ":" + second;
        }
        if (second < 10) {
            return hour + minute + ":0" + second;
        }
        return hour + minute + ":" + second;
    }

}
