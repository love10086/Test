package com.gemall.library.db;

/**
 * author : g-emall
 * time   : 2019/4/22
 * desc   :
 */

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDataBase.class)
public class SearchInfo extends BaseModel {


    //自增ID
    @Column
    @PrimaryKey(autoincrement = true)
    private int id;

    @Column
    private String keyName;
    @Column
    private String ValueName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getValueName() {
        return ValueName;
    }

    public void setValueName(String valueName) {
        ValueName = valueName;
    }
}
