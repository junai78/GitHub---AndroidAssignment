package com.coursework.newinti.androidassignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by jshar on 12-Jul-17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    SQLiteDatabase database;

    private static final String DATABASE_NAME = "result.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_RESULT= "calculator_result";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_RESULT = "result";

    //Database creation sql statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_RESULT + " ( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_RESULT
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESULT);
        onCreate(db);
    }

    public void open() throws SQLException {
        database = this.getWritableDatabase();
    }

    public boolean insertData(String result) {
        database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_RESULT, result);
        long resultData = database.insert(MySQLiteHelper.TABLE_RESULT, null, contentValues);

        if (resultData == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        Cursor getResult = database.rawQuery("select * from " + TABLE_RESULT, null);
        return getResult;
    }
}
