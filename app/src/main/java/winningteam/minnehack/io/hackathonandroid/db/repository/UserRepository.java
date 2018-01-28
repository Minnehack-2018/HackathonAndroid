package winningteam.minnehack.io.hackathonandroid.db.repository;

import android.content.Context;
import android.support.annotation.NonNull;

import java.lang.ref.WeakReference;

import model.User;
import winningteam.minnehack.io.hackathonandroid.db.AppDatabase;
import winningteam.minnehack.io.hackathonandroid.db.AppExecutors;
import winningteam.minnehack.io.hackathonandroid.db.UserCallback;
import winningteam.minnehack.io.hackathonandroid.db.dao.UserDao;

public class UserRepository {
    private final UserDao mUserDao;
    private static UserRepository INSTANCE;
    private final AppExecutors mAppExecutors;
    private User mCachedUser;

    private UserRepository(UserDao userDao, AppExecutors executors) {
        this.mUserDao = userDao;
        this.mAppExecutors = executors;
    }

    public static UserRepository getInstance(@NonNull Context context, @NonNull AppExecutors executors) {
        if (INSTANCE == null) {
            synchronized (UserRepository.class) {
                if (INSTANCE == null) {
                    AppDatabase database = AppDatabase.getInstance(context);
                    INSTANCE = new UserRepository(database.userDao(), executors);
                }
            }
        }
        return INSTANCE;
    }

    void getUser(@NonNull final UserCallback callback) {
        final WeakReference<UserCallback> userCallbackWeakReference = new WeakReference<>(callback);
        mAppExecutors.diskIO().execute(() -> {
            final User user = mUserDao.getUser();
            mAppExecutors.mainThread().execute(() -> {
                final UserCallback userCallback = userCallbackWeakReference.get();
                if (userCallback == null) {
                    userCallback.onDataNotAvailable();
                } else {
                    mCachedUser = user;
                    userCallback.onUserLoaded(mCachedUser);
                }
            });
        });
    }

    void updateUser(@NonNull final User user, @NonNull UserCallback callback) {
        final WeakReference<UserCallback> userCallbackWeakReference = new WeakReference<>(callback);
        mAppExecutors.diskIO().execute(() -> {
            mUserDao.insertUser(user);
            mAppExecutors.mainThread().execute(() -> {
                UserCallback userCallback = userCallbackWeakReference.get();
                if (userCallback != null) {
                    userCallback.onUserUpdated(user);
                }
            });
        });

    }
}
