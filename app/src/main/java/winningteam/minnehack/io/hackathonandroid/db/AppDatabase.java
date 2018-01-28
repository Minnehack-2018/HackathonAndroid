package winningteam.minnehack.io.hackathonandroid.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import winningteam.minnehack.io.hackathonandroid.db.dao.SportDao;
import winningteam.minnehack.io.hackathonandroid.db.dao.UserDao;
import winningteam.minnehack.io.hackathonandroid.db.dao.WarmUpDao;
import winningteam.minnehack.io.hackathonandroid.model.Sport;
import winningteam.minnehack.io.hackathonandroid.model.User;
import winningteam.minnehack.io.hackathonandroid.model.WarmUp;

@Database(entities = {WarmUp.class, User.class, Sport.class}, version = 1 ,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "warm-up.db";
    private static AppDatabase sInstance;


    public abstract SportDao sportDao();

    public abstract WarmUpDao warmUpDao();

    public abstract UserDao userDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors) {
        if (sInstance == null) {
            synchronized (AppDatabase.class) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors);
                    sInstance.updateDatabaseCreated(context.getApplicationContext());
                }
            }
        }
        return sInstance;
    }


    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors) {
        return Room.inMemoryDatabaseBuilder(appContext, AppDatabase.class)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {

                            AppDatabase database = AppDatabase.getInstance(appContext, executors);
                            List<Sport> sports = DataGenerator.generateSports();
                            List<WarmUp> warmUps =
                                    DataGenerator.generateWarmUpsForSports(sports);

                            insertData(database, sports, warmUps);
                            // notify that the database was created and it's ready to be used
                            database.setDatabaseCreated();
                        });
                    }
                }).build();
    }

    /**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     */
    private void updateDatabaseCreated(final Context context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database, final List<Sport> sports,
                                   final List<WarmUp> warmUps) {
        database.runInTransaction(() -> {
            database.sportDao().insertAll(sports);
            database.warmUpDao().insertAll(warmUps);
        });
    }



    public LiveData<Boolean> getDatabaseCreated() {
        return mIsDatabaseCreated;
    }
}
