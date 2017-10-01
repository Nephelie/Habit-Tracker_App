package com.example.android.habittrackerapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.habittrackerapp.Data.HabitContract.HabitEntry;
import com.example.android.habittrackerapp.Data.HabitDbHelper;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertHabit();
        readHabit();
    }

    HabitDbHelper habitDbHelper = new HabitDbHelper(this);

    public Cursor readHabit() {

        SQLiteDatabase db = habitDbHelper.getReadableDatabase();

        String[] projection = {HabitEntry._ID,
                HabitEntry.COLUMN_HABIT_NAME,
                HabitEntry.COLUMN_HABIT_DURATION,
                HabitEntry.COLUMN_HABIT_REPETITIONS_PER_DAY};

        Cursor cursor = db.query(HabitEntry.TABLE_NAME, projection,
                null,
                null,
                null,
                null,
                null);

        try {
            int columnIndexId = cursor.getColumnIndex(HabitEntry._ID);
            int columnIndexName = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_NAME);
            int columnIndexDuration = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_DURATION);
            int columnIndexRepetitions = cursor.getColumnIndex(HabitEntry.COLUMN_HABIT_REPETITIONS_PER_DAY);

            while (cursor.moveToNext()) {
                int currentId = cursor.getInt(columnIndexId);
                String currentName = cursor.getString(columnIndexName);
                int currentDuration = cursor.getInt(columnIndexDuration);
                int currentRepetitions = cursor.getInt(columnIndexRepetitions);

                Log.i(LOG_TAG, currentId + " " + currentName + " " + currentDuration + " " + currentRepetitions);
            }
        } finally {
            cursor.close();
        }return cursor;
    }

    private void insertHabit() {

        SQLiteDatabase db = habitDbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HabitEntry.COLUMN_HABIT_NAME, "Walking the dog");
        values.put(HabitEntry.COLUMN_HABIT_REPETITIONS_PER_DAY, HabitEntry.HABIT_REPETITIONS_TWO);
        values.put(HabitEntry.COLUMN_HABIT_DURATION, 20);

        db.insert(HabitEntry.TABLE_NAME, null, values);
    }

}

