package com.gemall.library.util;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.gemall.library.BuildConfig;
import com.gemall.library.config.URLs;
import com.gemall.library.crypt.DesUtil;
import com.gemall.library.db.Info;
import com.gemall.library.db.Info_Table;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by Gemall on 2017/7/3.
 */
public class SkuUtils {


    public static Gson gson = new GsonBuilder().disableHtmlEscaping()//.serializeNulls().excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .create();


    /*加*/
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /*减*/
    public static double reduce(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /*乘*/
    public static double mul(double v1, double v2) {
        return mul2(v1, v2, 20);
    }

    /*乘*/
    public static double mul2(double v1, double v2, int retainLeng) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(retainLeng, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /*除*/
    public static double divide(double v1, double v2) {
        return divide2(v1, v2, 20);
    }

    /*除*/
    public static double divide2(double v1, double v2, int retainLeng) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, retainLeng, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * 金额最终值
     * 小数长度超过两位 第三位进一 如0.001=>0.01
     */
    public static double finalMoney(double v1) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(0.01);
        String mumStr = b1.toString();
        while (mumStr.endsWith("0")) {//去除尾0  比如0.110000
            mumStr = mumStr.substring(0, mumStr.length() - 1);
        }
        try {//0.5605
            mumStr = mumStr.split("\\.")[1];
            mumStr = String.valueOf(mumStr.toCharArray()[2]);
            System.out.println("v1 = [" + mumStr + "]");
            if (Double.parseDouble(mumStr) > 0) {
                b1 = b1.add(b2).setScale(2, BigDecimal.ROUND_DOWN);
            }
        } catch (Exception e) {
        }
        return b1.doubleValue();
    }

    public static double finalMoney2(double v1) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(0.01);

        String mumStr = b1.toString();
        while (mumStr.endsWith("0")) {//去除尾0  比如0.110000
            mumStr = mumStr.substring(0, mumStr.length() - 1);
        }
        try {
            mumStr = mumStr.split("\\.")[1];
            if (mumStr.length() > 2) {
                b1 = b1.add(b2).setScale(2, BigDecimal.ROUND_DOWN);
            }
        } catch (Exception e) {
        }
        return b1.doubleValue();
    }


    //经纬度计算
    public static double[] returnNeedWithLat(double lat, double lng, double distance) {
        double tempLat = distance / 111.00;
        if (lat >= 90) {
            lat = 89.00;
        }
        if (lat <= -90) {
            lat = -89.00;
        }
        if (lng >= 180) {
            lat = 179.00;
        }
        if (lng <= -180) {
            lat = -179.00;
        }
        double templng = distance / (110 * Math.cos(lng));
        double backX2 = lat + tempLat;
        double backY2 = lng - templng;
        double backX1 = lat - tempLat;
        double backY1 = lng + templng;


        return new double[]{backY2, backX2, backY1, backX1, lng, lat};
    }


    public static void printf(String msg) {
        if (BuildConfig.DEBUG && !TextUtils.isEmpty(msg)) {
            Log.i("sku_print", msg);
        }
    }


    public static double parseDouble(String parse) {
        try {

            return Double.parseDouble(parse);
        } catch (Exception e) {

            return 0;
        }

    }

    /*打印全部log数据*/
    public static void printf(String tag, String content) {


        try {
            if (TextUtils.isEmpty(content)) {
                return;
            }
            content = format(content);

            if (BuildConfig.DEBUG) {
                int p = 2000;
                long length = content.length();
                if (length <= p)
                    Log.i(tag, content);
                else {
                    while (content.length() > p) {
                        String logContent = content.substring(0, p);
                        content = content.replace(logContent, "");
                        Log.i(tag, logContent);
                    }
                    Log.i(tag, content);
                }
            }
        } catch (Exception e) {

        }
    }


    /**
     * @param
     * @return 时:分:秒
     */
    public static String getHours(long m) {
        if (m < 60) {//秒

            return NumFormat(0) + ":" + NumFormat(m);
        }

        if (m < 3600) {//分

            return NumFormat(m / 60) + ":" + NumFormat(m % 60);
        }

        if (m < 3600 * 24) {//时

            return NumFormat(m / 60 / 60) + ":" + NumFormat(m / 60 % 60) + ":" + NumFormat(m % 60);
        }

        if (m >= 3600 * 24) {//天

            return NumFormat(m / 60 / 60 / 24) + "天" + NumFormat(m / 60 / 60 % 24) + ":" + NumFormat(m / 60 % 60) + ":" + NumFormat(m % 60);
        }

        return "--";
    }

    public static String NumFormat(long i) {
        if (String.valueOf(i).length() < 2) {
            return "0" + i;
        } else {
            return String.valueOf(i);
        }
    }


    /**
     * 得到格式化json数据  退格用\t 换行用\r
     */
    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for (int i = 0; i < jsonStr.length(); i++) {
            char c = jsonStr.charAt(i);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return jsonForMatStr.toString();
    }

    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }

    public static String getWeek(String pTime) {
        String Week = "(星期";
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            Week += "天";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            Week += "一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY) {
            Week += "二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY) {
            Week += "三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY) {
            Week += "四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            Week += "五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            Week += "六";
        }
        return Week + ")";
    }

    public static int MaxDayFromDay_OF_MONTH(int year, int month) {
        Calendar time = Calendar.getInstance();
        time.clear();
        time.set(Calendar.YEAR, year);
        time.set(Calendar.MONTH, month - 1);//注意,Calendar对象默认一月为0
        int day = time.getActualMaximum(Calendar.DAY_OF_MONTH);//本月份的天数
        return day;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的名称
     */
    public static String getAppName(Context context) {
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getApplicationContext().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        String applicationName =
                (String) packageManager.getApplicationLabel(applicationInfo);
        return applicationName;
    }

    /**
     * float/double数据不显示成科学计数法
     */
    public static String NumToString(String num) {
        if (TextUtils.isEmpty(num)) {
            return "";
        }

        try {
            Double.parseDouble(num);
        } catch (Exception e) {
            return num;
        }

        return NumToString(Double.parseDouble(num));
    }

    /**
     * float/double数据不显示成科学计数法
     */
    public static String NumToString(double num) {

        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        nf.setMaximumFractionDigits(2);
        String stringNum = nf.format(num);

        int index = stringNum.indexOf(".");
        if (index == -1) {
//            stringNum += ".00";
            stringNum += "";
        } else {
            String endstr = stringNum.substring(index + 1);
            switch (endstr.length()) {
                case 0:
                    stringNum += "00";
                    break;
                case 1:
                    stringNum += "0";
                    break;
                case 2:
                    stringNum += "";
                    break;
            }
        }
        return stringNum;

    }


    public static String fmtMicrometer(double text) {
        return fmtMicrometer(NumToString(text));
    }

    /**
     * 格式化数字为千分位显示；
     *
     * @param text；
     * @return
     */
    public static String fmtMicrometer(String text) {
        DecimalFormat df = null;
        if (text.indexOf(".") > 0) {
            if (text.length() - text.indexOf(".") - 1 == 0) {
                df = new DecimalFormat("###,##0.");
            } else if (text.length() - text.indexOf(".") - 1 == 1) {
                df = new DecimalFormat("###,##0.0");
            } else {
                df = new DecimalFormat("###,##0.00");
            }
        } else {
            df = new DecimalFormat("###,##0");
        }
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }


    //方便获取输入值
    public static <T> T getText(View t, Class<T> tt) {

        T ttttt = null;

        CharSequence str = (t instanceof TextView ? ((TextView) t).getText() : t instanceof EditText ? ((EditText) t).getText() : "") + "";

        if (tt.equals(Double.class)) {
            ttttt = tt.cast(TextUtils.isEmpty(str) ? 0D : Double.parseDouble(str.toString()));
        } else if (tt.equals(Long.class)) {
            ttttt = tt.cast(TextUtils.isEmpty(str) ? 0L : Long.parseLong(str.toString()));
        } else if (tt == String.class) {
            ttttt = tt.cast(str);
        }
        return ttttt;
    }


    /**
     * 跳转到权限设置界面
     */
    public static void getAppDetailSettingIntent(Context context) {

        // vivo 点击设置图标>加速白名单>我的app
        //      点击软件管理>软件管理权限>软件>我的app>信任该软件
        Intent appIntent = context.getPackageManager().getLaunchIntentForPackage("com.iqoo.secure");
        if (appIntent != null) {
            context.startActivity(appIntent);
            //            floatingView = new SettingFloatingView(context, "SETTING", getApplication(), 0);
            //            floatingView.createFloatingView();
            return;
        }

        // oppo 点击设置图标>应用权限管理>按应用程序管理>我的app>我信任该应用
        //      点击权限隐私>自启动管理>我的app
        appIntent = context.getPackageManager().getLaunchIntentForPackage("com.oppo.safe");
        if (appIntent != null) {
            context.startActivity(appIntent);
            //            floatingView = new SettingFloatingView(context, "SETTING", getApplication(), 1);
            //            floatingView.createFloatingView();
            return;
        }

        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", context.getPackageName());
        }
        context.startActivity(intent);
    }


    /**
     * 获取状态栏高度,在页面还没有显示出来之前
     *
     * @param a
     * @return
     */
    public static int getStateBarHeight(Activity a) {
        int result = 0;
        int resourceId = a.getResources().getIdentifier("status_bar_height",
                "dimen", "android");
        if (resourceId > 0) {
            result = a.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    /**
     * 判断时间是否在时间段内
     *
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }


    public static String timeCorrect(String time) {

        try {

            time = time + "";
            time = time.replace(".", ":");
            time = time.replace("：", ":");

            String sss[] = time.split("-");

            String s1[] = sss[0].split(":");
            String s2[] = sss[1].split(":");

            return substringTime(s1[0], true) + ":" + substringTime(s1[1], false) + "-" + substringTime(s2[0], true) + ":" + substringTime(s2[1], false);

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String substringTime(String ss, boolean isStartsWith) {
        if (TextUtils.isEmpty(ss)) {
            return "";
        } else if (ss.length() == 1) {
            return isStartsWith ? "0" + ss : ss + "0";
        } else if (ss.length() == 2) {
            return ss;
        } else if (ss.length() > 2) {
            return ss.substring(0, 2);
        }
        return "";
    }


    //方便显示View
    public static void switchView(Map<String, View> viewMap, String tag) {
        switchView(viewMap, tag, 0);
    }


    public static void switchView(Map<String, View> viewMap, String tag, long duration) {


        for (Map.Entry<String, View> entry : viewMap.entrySet()) {
            String key = entry.getKey();
            View view = entry.getValue();
            if (key.equals(tag)) {

                if (duration > 0) {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1f);
                    anim.setDuration(duration);// 动画持续时间
                    anim.start();
                }
                view.setVisibility(View.VISIBLE);
            } else {
                view.setVisibility(View.GONE);
            }
        }
    }


    //调整屏幕亮度的方法
    public static void setWindowBrightness(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.screenBrightness = brightness;
        window.setAttributes(lp);
    }


    //    /**手机震动*/
    //    public static void shock(long milliseconds){
    //
    //        Vibrator vibrator = (Vibrator) GwtKeyApp.getInstance().getSystemService(GwtKeyApp.VIBRATOR_SERVICE);
    //        vibrator.vibrate(milliseconds);
    //    }


    public static double getDouble(String doubleStr) {
        try {
            return Double.valueOf(doubleStr);
        } catch (Exception e) {
        }
        return 0;
    }


    //方便类型强转
    public static <T> T getMyView(Object object) {
        return (T) object;
    }

    /**
     * 跳转到手机拨号界面
     *
     * @param context 上下文
     * @param mobile  拨号号码
     */
    public static void intentCall(Context context, String mobile) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + mobile);
        intent.setData(data);
        context.startActivity(intent);
    }

    //特殊的加密方式，针对这里
    public static String encryptStr(String str) {
        String s = "";
        try {
            s = DesUtil.encryptDESByECB(str, DesUtil.DESKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    //解密
    public static String decryptStr(String str) {
        String s = "";
        try {
            s = DesUtil.decryptDES(str, DesUtil.DESKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }


    public static String getImageUrlPath(String path) {

        if (TextUtils.isEmpty(path)) {
            return "";
        } else {
            try {
                path = path.replace(" ", "");
                path = path.replace("\"", "");
                path = path.split(";")[0];
                path = path.startsWith("http") ? path : URLs.SKUIMG + path;
            } catch (Exception e) {
                path = path;
            }
        }
        if (TextUtils.isEmpty(path)) {
            path = "";
        }
        return path;
    }

    /**
     * 生成我的二维码
     *
     * @param content
     * @return
     */
    public static Bitmap generateQRCode(Context mContext, String content, int width, int height) {
        Log.d("QR", "QR" + content);
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix matrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height);
            return bitMatrix2Bitmap(matrix);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static Bitmap bitMatrix2Bitmap(BitMatrix matrix) {
        int w = matrix.getWidth();
        int h = matrix.getHeight();
        int[] rawData = new int[w * h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                int color = Color.WHITE;
                if (matrix.get(i, j)) {
                    color = Color.BLACK;
                }
                rawData[i + (j * w)] = color;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(rawData, 0, w, 0, 0, w, h);
        return bitmap;
    }

    /**
     * 格式化店铺营业时间
     *
     * @param openTime  开店时间
     * @param closeTime 休息时间
     * @return
     */
    public static String formatBusinessTime(String openTime, String closeTime) {
        String formatTime;
        boolean isTheNextDay = false;
        try {//"次日"
            String[] sss = closeTime.split("\\.");
            int finalCloseTime = Integer.parseInt(sss[0]);
            isTheNextDay = finalCloseTime >= 24;
            finalCloseTime = finalCloseTime >= 24 ? +(finalCloseTime - 24) : finalCloseTime;
            formatTime = openTime + "-" + finalCloseTime + ":" + sss[1];
        } catch (Exception e) {
            formatTime = "";
            e.printStackTrace();
        }
        String finalFormatTime = SkuUtils.timeCorrect(formatTime);
        StringBuilder sb = new StringBuilder(finalFormatTime);
        if (isTheNextDay) {
            int j = finalFormatTime.indexOf("-");
            sb.insert(j + 1, "次日");
            finalFormatTime = sb.toString();
        }
        return finalFormatTime;
    }

    /**
     * 格式化店铺配送时间
     *
     * @param openTime  开店时间
     * @param closeTime 休息时间
     * @return
     */
    public static String formatDeliveryTime(String openTime, String closeTime) {
        String formatTime;
        boolean isTheNextDay;
        try {//"次日"
            String[] openStr = openTime.split(":");
            String openHours = openStr[0];
            String openMinutes = openStr[1];
            String[] closeStr = closeTime.split(":");
            String closeHours = closeStr[0];
            String closeMinutes = closeStr[1];
            isTheNextDay = Integer.parseInt(closeHours) <= Integer.parseInt(openHours);
            formatTime = timeAddZero(openHours) + ":" + timeAddZero(openMinutes) + "-" +
                    (isTheNextDay ? "次日" : "") + timeAddZero(closeHours) + ":" + timeAddZero(closeMinutes);
        } catch (Exception e) {
            formatTime = "";
            e.printStackTrace();
        }
        return formatTime;
    }

    // 在不规范的时间前加0
    private static String timeAddZero(String time) {
        if (!time.startsWith("0") && Integer.parseInt(time) < 10) {
            return "0" + time;
        } else {
            return time;
        }
    }


    //获取键值对数据
    public static String getAccountInfo(String keyName) {
        if (TextUtils.isEmpty(keyName)) {
            return null;
        }
        try {
            List<Info> noteBeans = SQLite.select()
                    .from(Info.class)
                    .where(Info_Table.keyName.is(keyName))
                    .queryList();
            return noteBeans.get(0).getValue();
        } catch (Exception e) {
        }
        return null;
    }

    //删除数据
    public static void delAccountInfo(String keyName) {
        if (TextUtils.isEmpty(keyName)) {
            return;
        }
        try {
            SQLite.delete(Info.class)
                    .where(Info_Table.keyName.eq(keyName))
                    .execute();
        } catch (Exception e) {
        }
    }

    //保存键值对数据到数据库
    public static void setAccountInfo(String keyName, String Value) {
        if (TextUtils.isEmpty(keyName)) {
            return;
        }
        Info userModel = new Info();
        userModel.setKeyName(keyName);
        userModel.setValue(Value);
        userModel.save();
        userModel.update();
    }

    // webview加载富文本，对屏幕适配
    public static String getHtmlData(String bodyHTML) {
        String head = "<head>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> "
                + "<style>img{max-width: 100%; width:100%; height:auto;}*{margin:0px;}*{word-break:break-all;}</style>"
                + "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

}
