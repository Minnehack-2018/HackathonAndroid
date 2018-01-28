package winningteam.minnehack.io.hackathonandroid.db.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import java.util.List;

import winningteam.minnehack.io.hackathonandroid.db.AppDatabase;
import winningteam.minnehack.io.hackathonandroid.model.Sport;

public class SportRepository {
    private static SportRepository sInstance;
    private final AppDatabase mDatabase;
    private MediatorLiveData<List<Sport>> mObservableSports;


    public SportRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableSports = new MediatorLiveData<>();

        mObservableSports.addSource(mDatabase.sportDao().loadAllSports(), sports -> {
            if (mDatabase.getDatabaseCreated().getValue() != null) {
                mObservableSports.postValue(sports);
            }
        });
    }

    public static SportRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (SportRepository.class) {
                if (sInstance == null) {
                    sInstance = new SportRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<Sport>> getSports() {
        return mObservableSports;
    }

    public LiveData<Sport> loadSport(final int sportId) {
        return mDatabase.sportDao().loadSport(sportId);
    }
}
