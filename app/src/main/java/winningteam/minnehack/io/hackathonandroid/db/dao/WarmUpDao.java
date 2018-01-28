package winningteam.minnehack.io.hackathonandroid.db.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import model.WarmUp;

public interface WarmUpDao {
    @Insert
    void insertWarmUp(WarmUp warmUp);

    @Update
    void updateWarmUp(WarmUp warmUp);
}
