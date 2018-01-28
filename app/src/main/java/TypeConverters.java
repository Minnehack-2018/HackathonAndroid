import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import model.WarmUpImage;

public class TypeConverters{

    @TypeConverter
    public static List<WarmUpImage> stringToWarmUpImage(String json) {
        if (json == null) {
            return Collections.emptyList();
        }

        Type type = new TypeToken<List<WarmUpImage>>() {}.getType();
        return new Gson().fromJson(json, type);
    }

    @TypeConverter
    public static String WarmUpImagesToString(List<WarmUpImage> data) {
        Type type = new TypeToken<List<WarmUpImage>>() {}.getType();
        return new Gson().toJson(data, type);
    }
}
