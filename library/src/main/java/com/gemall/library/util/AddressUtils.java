package com.gemall.library.util;

import com.gemall.library.db.AreaInfo;
import com.gemall.library.db.AreaInfo_Table;
import com.gemall.library.db.CityInfo;
import com.gemall.library.db.CityInfo_Table;
import com.gemall.library.db.ProvinceInfo;
import com.gemall.library.db.ProvinceInfo_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AddressUtils {
    private static ArrayList<AddressBean> myProvinceList;
    private static ArrayList<AddressBean> myCityList;

    private static List<String> myProvinceCodeList = new ArrayList<>();
    private static List<String> myCityCodeList = new ArrayList<>();
    private static List<String> myAreaCodeList = new ArrayList<>();

    public static void saveAreaToSql(JSONArray provinceList, List<String> provinceCodeList, List<String> cityCodeList, List<String> areaCodeList){
        myProvinceCodeList.clear();
        myCityCodeList.clear();
        myAreaCodeList.clear();

        myProvinceCodeList.addAll(provinceCodeList);
        myCityCodeList.addAll(cityCodeList);
        myAreaCodeList.addAll(areaCodeList);

        saveProvinceList(provinceList);
        for (AddressBean addressBean : myProvinceList){
            saveCityList(addressBean.getNext());
        }

        for (AddressBean addressBean : myCityList){
            saveAreaList(addressBean.getNext());
        }
    }

    /**
     *  获取数据库缓存的所有省级数据
     */
    public static List<ProvinceInfo> getProvinceList(String provinceCode){
        try{
            if (StringUtils.isUsefulString(provinceCode)){
                return SQLite.select().from(ProvinceInfo.class).where(ProvinceInfo_Table.code.is(provinceCode)).queryList();
            }else {
                return SQLite.select().from(ProvinceInfo.class).queryList();
            }
        }catch (Exception e){
            return null;
        }
    }

    /**
     *  获取数据库缓存的所有市级数据
     */
    public static List<CityInfo> getCityList(String cityCode){
        try{
            if (StringUtils.isUsefulString(cityCode)){
                return SQLite.select().from(CityInfo.class).where(CityInfo_Table.code.is(cityCode)).queryList();
            }else {
                return SQLite.select().from(CityInfo.class).queryList();
            }
        }catch (Exception e){
            return null;
        }
    }

    /**
     *  获取数据库缓存的所有区域级数据
     */
    public static List<AreaInfo> getAreaList(String areaCode){
        try{
            if (StringUtils.isUsefulString(areaCode)){
                return SQLite.select().from(AreaInfo.class).where(AreaInfo_Table.code.is(areaCode)).queryList();
            }else {
                return SQLite.select().from(AreaInfo.class).queryList();
            }
        }catch (Exception e){
            return null;
        }
    }

    /**
     * 保存 省列表 到数据库
     */
    private static void saveProvinceList(JSONArray provinceList) {
        try {
            JSONArray jsonArray = provinceList;

            int length = jsonArray.length();

            myProvinceList = new ArrayList<>(length);

            for (int i = 0; i < length; i++) {
                for (String code : myProvinceCodeList){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (code.equalsIgnoreCase(jsonObject.getString("Code"))){
                        myProvinceList.add(new AddressBean(jsonObject.getString("Name"), jsonObject.getString("Code"), jsonObject));
                        ProvinceInfo provinceInfo = new ProvinceInfo();
                        provinceInfo.setCode(jsonObject.getString("Code"));
                        provinceInfo.setName(jsonObject.getString("Name"));
                        provinceInfo.save();
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存 城市列表 到数据库
     */
    private static void saveCityList(JSONObject jsonObject) {
        try {
            JSONArray listCity = jsonObject.getJSONArray("City");
            int length = listCity.length();

            if (null == myCityList){
                myCityList = new ArrayList<>(length);
            }

            for (int i = 0; i < length; i++) {
                for (String code : myCityCodeList){
                    if (code.equalsIgnoreCase(listCity.getJSONObject(i).getString("Code"))){
                        myCityList.add(new AddressBean(listCity.getJSONObject(i).getString("Name"), listCity.getJSONObject(i).getString("Code"), listCity.getJSONObject(i)));
                        CityInfo cityInfo = new CityInfo();
                        cityInfo.setCode(listCity.getJSONObject(i).getString("Code"));
                        cityInfo.setName(listCity.getJSONObject(i).getString("Name"));
                        cityInfo.save();
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存 区域列表 到数据库
     */
    private static void saveAreaList(JSONObject jsonObject) {
        try {
            JSONArray listArea = jsonObject.getJSONArray("Region");
            int length = listArea.length();
            ArrayList<AddressBean> list = new ArrayList<>(length);

            for (int i = 0; i < length; i++) {
                for (String code : myAreaCodeList){
                    if (code.equalsIgnoreCase(listArea.getJSONObject(i).getString("Code"))){
                        list.add(new AddressBean(listArea.getJSONObject(i).getString("Name"), listArea.getJSONObject(i).getString("Code"), null));
                        CityInfo cityInfo = new CityInfo();
                        cityInfo.setCode(listArea.getJSONObject(i).getString("Code"));
                        cityInfo.setName(listArea.getJSONObject(i).getString("Name"));
                        cityInfo.save();
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static final class AddressBean {

        private String name; // 省、市、区的名称
        private String code;//省、市、区的编号
        private JSONObject next; // 下一级的 Json

        private AddressBean(String name, String code, JSONObject next) {
            this.name = name;
            this.code = code;
            this.next = next;
        }

        private String getName() {
            return name;
        }

        private String getCode() {
            return code;
        }

        private JSONObject getNext() {
            return next;
        }
    }
}
