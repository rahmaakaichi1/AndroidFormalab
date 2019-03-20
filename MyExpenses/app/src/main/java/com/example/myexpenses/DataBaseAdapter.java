package com.example.myexpenses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import static android.provider.Contacts.SettingsColumns.KEY;

public class DataBaseAdapter extends SQLiteOpenHelper {


    public DataBaseAdapter(Context context) {
        super(context,"MyExpenses",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create ="create table Expenses(id integer primary key , name text, price Float )";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String delete ="drop table if exists Expenses";
        db.execSQL(delete);
        onCreate(db);
    }

    public void addExpense(Expense e){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("name",e.getName());
        values.put("price",e.getPrice());

        db.insert("Expenses",null,values);

    }
    public void deleteExpense(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Expenses","id ="+id,null);
        db.close();
    }

    public ArrayList<Expense> DisplayExpense(){
        ArrayList<Expense> e = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String all ="SELECT * FROM Expenses";
        Cursor cur = db.rawQuery(all,null);
        if(cur.moveToFirst()){
            do {
                Expense expense = new Expense();
                expense.setName(cur.getString(1));
                expense.setPrice(cur.getFloat(2));
                e.add(expense);
            }while(cur.moveToNext());

        }
        return e ;
    }

    public Float total()
    {   Float s =0f ;

        SQLiteDatabase db=getReadableDatabase();
        String selectall="SELECT * FROM Expenses";
        Cursor cursor= db.rawQuery(selectall,null);
        ArrayList<Expense> d=new ArrayList<>();
        if (cursor.moveToFirst()){
            do{
                s+=cursor.getFloat(2);
            }
            while(cursor.moveToNext());
        }

        return s ;}

}

