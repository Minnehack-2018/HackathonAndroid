package winningteam.minnehack.io.hackathonandroid.db.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import winningteam.minnehack.io.hackathonandroid.db.AppDatabase;
import winningteam.minnehack.io.hackathonandroid.model.WarmUp;

public class WarmupRepository {
    private static WarmupRepository sInstance;
    private final AppDatabase mDatabase;


    public WarmupRepository(final AppDatabase database) {
        mDatabase = database;

    }

    public static WarmupRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (WarmupRepository.class) {
                if (sInstance == null) {
                    sInstance = new WarmupRepository(database);
                }
            }
        }
        return sInstance;
    }


    public LiveData<List<WarmUp>> loadWarmup(final int sportId) {
        return mDatabase.warmUpDao().loadWarmUps(sportId);
    }
}
