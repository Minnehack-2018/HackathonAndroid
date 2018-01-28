package winningteam.minnehack.io.hackathonandroid;

import android.annotation.SuppressLint;
import android.app.Application;

import winningteam.minnehack.io.hackathonandroid.db.AppDatabase;
import winningteam.minnehack.io.hackathonandroid.db.AppExecutors;
import winningteam.minnehack.io.hackathonandroid.db.repository.UserRepository;

public class App extends Application {
    private AppExecutors mAppExecutors;

    @Override
    public void onCreate() {
        super.onCreate();

        mAppExecutors = new AppExecutors();
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this, mAppExecutors);
    }

    public UserRepository getUserRepository() {
        return UserRepository.getInstance(getDatabase());
    }
}
