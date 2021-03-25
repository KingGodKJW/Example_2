package com.example.example_2;

import android.content.ContentValues;
import android.content.Context;

import net.sqlcipher.Cursor;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteOpenHelper;



public class DBHelper extends SQLiteOpenHelper {

    private static DBHelper instance;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "LoginSample.db";
    public static final String TABLE_NAME = "User";
    public static final String COLUMN_NAME1 = "ID";
    public static final String COLUMN_NAME2 = "PW";
    public static final String COLUMN_NAME3 = "NAME";
    public static final String COLUMN_NAME4 = "EMAIL";
    public static final String PASS_PHRASE = "!@#123";
    private static String SQL_CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_NAME1 + " TEXT PRIMARY KEY," +
            COLUMN_NAME2 + " TEXT," +
            COLUMN_NAME3 + " TEXT," +
            COLUMN_NAME4 + " TEXT)";
    private static String SQL_DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    static public synchronized DBHelper getInstance(Context context){
        if(instance==null)
            instance = new DBHelper(context);
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLE);
        onCreate(db);
    }

    public void register(String Id,String Pw,String Name,String Email){
        SQLiteDatabase db = instance.getWritableDatabase(PASS_PHRASE);
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME1,Id);
        cv.put(COLUMN_NAME2,Pw);
        cv.put(COLUMN_NAME3,Name);
        cv.put(COLUMN_NAME4,Email);
        db.insert(TABLE_NAME,null,cv);
        db.close();
    }

    public Cursor Login(String Id, String Pw){
        SQLiteDatabase db = instance.getReadableDatabase(PASS_PHRASE);
        Cursor cursor = db.rawQuery(String.format("Select * from %s where ID = '%s' AND PW = '%s';",TABLE_NAME,Id,Pw),null);



        /*
        User user = new User();

        user.setID(cursor.getString(0).toString());
        user.setPW(cursor.getString(1).toString());
        user.setNAME(cursor.getString(2).toString());
        user.setEMAIL(cursor.getString(3).toString());

        cursor.close();
        */

        db.close();

        return cursor;

    }


}
