package com.example.android.habittrackerapp.Data;


import android.provider.BaseColumns;

public class HabitContract {

    private HabitContract() {
        //An empty private constructor makes sure that the class is not going to be initialised.
}

    public static class HabitEntry implements BaseColumns {

        public static final String TABLE_NAME = "habits";

        public static final String COLUMN_HABIT_NAME = "Name";
        public static final String COLUMN_HABIT_REPETITIONS_PER_DAY = "Repetitions";
        public static final String COLUMN_HABIT_DURATION = "Minutes";


        public static final int HABIT_REPETITION_NONE = 0;
        public static final int HABIT_REPETITION_ONE = 1;
        public static final int HABIT_REPETITIONS_TWO = 2;
        public static final int HABIT_REPETITIONS_THREE = 3;
        public static final int HABIT_REPETITIONS_MORE_THAN_THREE = 4;
    }
}
