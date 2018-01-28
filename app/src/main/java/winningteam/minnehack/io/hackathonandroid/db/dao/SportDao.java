package winningteam.minnehack.io.hackathonandroid.db.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import model.Sport;

public interface SportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertSport(Sport sport);

    @Query("SELECT * FROM sport WHERE id = :id")
    Sport getSport(String id);
}
