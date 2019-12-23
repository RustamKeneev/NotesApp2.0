package com.example.notesapp;

import android.provider.BaseColumns;

public class NotesContract {
    public static final class  NotesEntry implements BaseColumns {
      public static final String TABLE_NAME = "notes"; //название таблицы
      public static final String COLUMN_TITLE = "title"; // заголовок столбец таблицы
      public static final String COLUMN_DESCRIPTION = "description"; // описание столбец таблицы
      public static final String COLUMN_DAY_OF_WEEK = "day_of_week"; // День недели столбец таблицы
      public static final String COLUMN_PRIORITY = "priority"; // парядок столбец таблицы

      //Типы данных
      public static final String TYPE_TEXT = "TEXT";
      public static final String TYPE_INTEGER = "INTEGER";

      //команда  для создание таблицу
      public static final String CREATE_COMMAND = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
              "(" + _ID + " " + TYPE_INTEGER + " PRIMARY KEY AUTOINCREMENT, " + COLUMN_TITLE +
              " " + TYPE_TEXT + ", " + COLUMN_DESCRIPTION + " " +  TYPE_TEXT + ", " + COLUMN_DAY_OF_WEEK +
              " " + TYPE_INTEGER + ", " + COLUMN_PRIORITY + " " + TYPE_INTEGER + ")";

      //команда для удаление таблицы
      public static final String DROP_COMMAND = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
