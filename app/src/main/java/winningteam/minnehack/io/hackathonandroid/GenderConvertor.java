package winningteam.minnehack.io.hackathonandroid;

import android.arch.persistence.room.TypeConverter;

import winningteam.minnehack.io.hackathonandroid.model.GenderType;

public class GenderConvertor {
    @TypeConverter
    public static GenderType toGender(String type) {
        return GenderType.valueOf(type);
    }

    @TypeConverter
    public static String toString(GenderType type) {
        return  type.name();
    }
}
