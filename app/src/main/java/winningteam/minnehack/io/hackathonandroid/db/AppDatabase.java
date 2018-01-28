package winningteam.minnehack.io.hackathonandroid.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import model.User;
import model.WarmUp;
import winningteam.minnehack.io.hackathonandroid.db.dao.UserDao;
import winningteam.minnehack.io.hackathonandroid.db.dao.WarmUpDao;

@Database(entities = {WarmUp.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE = "warm-up.db";
    private static AppDatabase INSTANCE = null;

    public abstract UserDao userDao();
    public abstract WarmUpDao warmupDao();

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destoryInstance() {
        INSTANCE = null;
    }
}
