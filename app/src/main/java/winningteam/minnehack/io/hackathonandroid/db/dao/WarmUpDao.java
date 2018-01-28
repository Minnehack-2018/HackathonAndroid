package winningteam.minnehack.io.hackathonandroid.db.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import model.WarmUp;

public interface WarmUpDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWarmUp(WarmUp warmUp);

    @Query("SELECT * FROM warmups WHERE id = :id")
    void getWarmUp(String id);
}
