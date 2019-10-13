package com.logitech.testapp.core.utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Vigneshwaran G on 13/10/19.
 */
public class FileUtils {

    private FileUtils(){
        //Do nothing
    }

    /**
     * Method to get the Json from local file
     * @param context The Context
     * @param fileName The File Name
     * @return The String as Json
     */
    public static String loadJSONFromAsset(Context context, String fileName) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
