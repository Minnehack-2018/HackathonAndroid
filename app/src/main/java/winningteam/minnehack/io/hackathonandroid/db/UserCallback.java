package winningteam.minnehack.io.hackathonandroid.db;

import android.support.annotation.MainThread;

import winningteam.minnehack.io.hackathonandroid.model.User;

public interface UserCallback {

    @MainThread
    void onUserUpdated(User user);

    @MainThread
    void onDataNotAvailable();

    @MainThread
    void onUserLoaded(User user);
}
