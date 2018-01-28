package winningteam.minnehack.io.hackathonandroid.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import model.User;
import model.WarmUp;
import winningteam.minnehack.io.hackathonandroid.db.dao.UserDao;
import winningteam.minnehack.io.hackathonandroid.db.dao.WarmUpDao;

@Database(entities = {WarmUp.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract WarmUpDao warmupDao();
}
