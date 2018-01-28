package winningteam.minnehack.io.hackathonandroid;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import winningteam.minnehack.io.hackathonandroid.model.WarmUpImage;

public class TypeConverters{

    @TypeConverter
    public static WarmUpImage stringToWarmUpImage(String json) {
        if (json == null) {
            return null;
        }

        Type type = new TypeToken<WarmUpImage>() {}.getType();
        return new Gson().fromJson(json, type);
    }

    @TypeConverter
    public static String WarmUpImagesToString(WarmUpImage data) {
        Type type = new TypeToken<WarmUpImage>() {}.getType();
        return new Gson().toJson(data, type);
    }
}
