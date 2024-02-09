package com.example.assignment;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {


    final static String DATABASE_NAME = "RecordedNotes.db";

    private final static int DATABASE_VERSION = 3;

   private final static String TABLE_NOTES = "NotesRecord";
    private final static String COLUMN_ID  = "id";
    private  final static String Column_TITLE = "Title";
    private final static String COLUMN_NOTES = "Notes";



    private final static String Create_Table  = " CREATE TABLE " + TABLE_NOTES +"(" + COLUMN_ID + " PRIMARY KEY AUTOINCREMENT, " + Column_TITLE + "TEXT" +
        COLUMN_NOTES +" TEXT " + ")";




    public Database(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Create_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(" DROP TABLE IF EXISTS " + Create_Table);
        db.close();

    }

    public void AddRecord(String Title, String Notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Column_TITLE, Title);
        values.put(COLUMN_NOTES, Notes);
        db.insert(TABLE_NOTES,null,values);
        db.close();

    }
    public void DeleteRecord(Long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTES, COLUMN_ID + " = ? ", new String[]{String.valueOf(id)});
        db.close();

    }

    public int EditRecord(long id, String Title, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Column_TITLE, Title);
        values.put(Column_TITLE,name);
        return db.update(TABLE_NOTES, values, COLUMN_ID + " =?", new String[]{String.valueOf(id)} );


    }
    public void getAllRecord(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.rawQuery(" SELECT * FROM " + TABLE_NOTES,null);

    }
}
