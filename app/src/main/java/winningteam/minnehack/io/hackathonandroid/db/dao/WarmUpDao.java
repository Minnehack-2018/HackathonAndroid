package winningteam.minnehack.io.hackathonandroid.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import winningteam.minnehack.io.hackathonandroid.model.Sport;
import winningteam.minnehack.io.hackathonandroid.model.WarmUp;

@Dao
public interface WarmUpDao {
    @Query("select * from warmups where sportId = :sportId")
    List<WarmUp> loadWarmUpSync(int sportId);

    @Query("SELECT * FROM warmups WHERE sportId = :sportId")
    LiveData<List<WarmUp>> loadWarmUps(int sportId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<WarmUp> warmsUps);
}
