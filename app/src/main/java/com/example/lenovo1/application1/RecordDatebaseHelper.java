package com.example.lenovo1.application1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.LinkedList;

/**
 * Created by lenovo1 on 2019/4/3.
 */
public class RecordDatebaseHelper extends SQLiteOpenHelper{

    private static String TAG = "RecordDatebaseHelper";

    public static final String DB_NAME = "Record";

    private static final String CREATE_RECORD_DB = "create table Record ("//创建数据库
            + "id integer primary key autoincrement, "
            + "uuid text, "
            + "type integer, "
            + "category text, "
            + "remark text, "
            + "name text, "
            + "time integer, "
            + "date date )";


    public RecordDatebaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        Log.d(TAG,"DatabaseHelper init!");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_RECORD_DB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //可以用swith语句升级数据库
    }

    public void addRecord(RecordBean bean){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("uuid", bean.getUuid());
        values.put("type", bean.getType());
        values.put("category", bean.getCategory());
        values.put("remark", bean.getRemark());
        values.put("name", bean.getName());
        values.put("date", bean.getDate());
        values.put("time", bean.getTimeStamp());
        db.insert(DB_NAME,null,values);
        values.clear();
        Log.d(TAG,bean.getUuid() + " added");
        //db.close();
    }//增

    public void removeRecord(String uuid){//删除一笔账目
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DB_NAME,"uuid = ?",new String[]{uuid});
    }//删除

    public void editRecord(String uuid,RecordBean record){//编辑账目
        removeRecord(uuid);
        record.setUuid(uuid);
        addRecord(record);
        //先删除旧的，新的过来，把新的uuid设成旧的需要修改的，最后再添加到数据库中
    }//改

    public LinkedList<RecordBean> readRecords(String dateStr){

        LinkedList<RecordBean> records = new LinkedList<>();//初始化数组

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT * from Record where date = ? order by time asc",new String[]{dateStr});//?代表所需要查找的时间日期

        if (cursor.moveToFirst()){

            do {

                String uuid = cursor.getString(cursor.getColumnIndex("uuid"));//取id对应的列
                int type = cursor.getInt(cursor.getColumnIndex("type"));
                String category = cursor.getString(cursor.getColumnIndex("category"));
                String remark = cursor.getString(cursor.getColumnIndex("remark"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                long timeStamp = cursor.getLong(cursor.getColumnIndex("time"));


                RecordBean record = new RecordBean();
                record.setUuid(uuid);
                record.setType(type);
                record.setCategory(category);
                record.setRemark(remark);
                record.setName(name);
                record.setDate(date);
                record.setTimeStamp(timeStamp);

                records.add(record);

            }while (cursor.moveToNext());

        }
        cursor.close();
        return records;
    }//查

    public LinkedList<String> getAvaliableDate(){

        LinkedList<String> dates = new LinkedList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select DISTINCT * from Record order by date asc",new String[]{});
        if (cursor.moveToFirst()){
            do {
                String date = cursor.getString(cursor.getColumnIndex("date"));

                if (!dates.contains(date)){
                    dates.add(date);
                }

            }while (cursor.moveToNext());
        }
        cursor.close();
        return dates;
    }//查
}
