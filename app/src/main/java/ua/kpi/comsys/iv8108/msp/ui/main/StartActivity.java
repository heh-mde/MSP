package ua.kpi.comsys.iv8108.msp.ui.main;

import android.app.Application;

import androidx.room.Room;

import ua.kpi.comsys.iv8108.msp.ui.database.BooksDatabase;

public class StartActivity extends Application {

    public static StartActivity instance;
    private BooksDatabase database;

    @Override
    public void onCreate() {

        super.onCreate();
        instance = this;

        database = Room.databaseBuilder(this, BooksDatabase.class, "database").build();

        database = Room.databaseBuilder(this, BooksDatabase.class, "database")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static StartActivity getInstance() {
        return instance;
    }

    public BooksDatabase getDatabase() {
        return database;
    }
}
