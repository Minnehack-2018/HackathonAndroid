package winningteam.minnehack.io.hackathonandroid.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import winningteam.minnehack.io.hackathonandroid.model.Sport;

@Dao
public interface SportDao {
    @Query("SELECT * FROM sports")
    LiveData<List<Sport>> loadAllSports();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Sport> sports);

    @Query("select * from sports where id = :sportId")
    LiveData<Sport> loadSport(int sportId);

    @Query("select * from sports where id = :sportId")
    Sport loadSportSync(int sportId);
}
