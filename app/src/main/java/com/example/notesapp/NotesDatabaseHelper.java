package com.example.notesapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// класс наследуется SQLiteOpenHelper затем  имплементируем два  методы(onCreate, onUpgrade)
// затем создаем  контруктор
public class NotesDatabaseHelper extends SQLiteOpenHelper {

    private static final  String DB_NAME = "notes.db";// название базы  данных
    private static final int DB_VERSION = 2; // версия базы данных

    public NotesDatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) { //вызывается  при  создании базы данных
        sqLiteDatabase.execSQL(NotesContract.NotesEntry.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { // для удаление и обновление
        sqLiteDatabase.execSQL(NotesContract.NotesEntry.DROP_COMMAND);//удаляем старую базу данных
        onCreate(sqLiteDatabase);//затем обновляем и добавляем  базу данных
    }
}
