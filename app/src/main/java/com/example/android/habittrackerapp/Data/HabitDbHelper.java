package com.example.android.habittrackerapp.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habittrackerapp.Data.HabitContract.HabitEntry;

public class HabitDbHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "my_habits.db";
    public static final int DATABASE_VERSION = 1;

    public HabitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_HABIT_TABLE = "CREATE TABLE" + HabitEntry.TABLE_NAME + "("
                + HabitEntry._ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitEntry.COLUMN_HABIT_NAME + "TEXT NOT NULL, "
                + HabitEntry.COLUMN_HABIT_REPETITIONS_PER_DAY + "INTEGER NOT NULL, "
                + HabitEntry.COLUMN_HABIT_DURATION + "INTEGER NOT NULL DEFAULT 0);";
        db.execSQL(SQL_CREATE_HABIT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
