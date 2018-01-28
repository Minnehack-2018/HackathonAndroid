package winningteam.minnehack.io.hackathonandroid.db.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import java.util.List;

import winningteam.minnehack.io.hackathonandroid.model.User;
import winningteam.minnehack.io.hackathonandroid.db.AppDatabase;

public class UserRepository {
    private static UserRepository sInstance;
    private final AppDatabase mDatabase;
    private MediatorLiveData<List<User>> mObservableUsers;


    public UserRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableUsers = new MediatorLiveData<>();

        mObservableUsers.addSource(mDatabase.userDao().loadAllUsers(), users -> {
            if (mDatabase.getDatabaseCreated().getValue() != null) {
                mObservableUsers.postValue(users);
            }
        });
    }

    public static UserRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (UserRepository.class) {
                if (sInstance == null) {
                    sInstance = new UserRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<User>> loadUsers() {
        return mObservableUsers;
    }

    public void insertUser(User user){
        mDatabase.userDao().insertUser(user);
    }




}
