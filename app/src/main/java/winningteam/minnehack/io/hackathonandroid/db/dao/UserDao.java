package winningteam.minnehack.io.hackathonandroid.db.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import model.User;

public interface UserDao {
    @Insert
    public void insertUser(User user);

    @Update
    public void updateUser(User user);
}
