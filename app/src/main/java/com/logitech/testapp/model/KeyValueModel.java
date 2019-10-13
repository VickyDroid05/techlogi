package com.logitech.testapp.model;

/**
 * Created by Vigneshwaran G on 13/10/19.
 */
public class KeyValueModel {

    private String mKey;
    private String mvalue;

    public KeyValueModel(String mKey, String mValue) {
        this.mKey = mKey;
        this.mvalue = mValue;
    }

    public String getKey() {
        return mKey;
    }

    public String getvalue() {
        return mvalue;
    }
}
