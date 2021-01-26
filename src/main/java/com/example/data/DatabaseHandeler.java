package com.example.data;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.util.Xml;


import androidx.annotation.Nullable;

import com.example.data.model.Contact;
import com.example.data.util.Util;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandeler extends SQLiteOpenHelper {
    public DatabaseHandeler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String creat_table = "CREATE TABLE contacts(id INTEGER PRIMARY KEY, name TEXT, phoneNumber TEXT)";
        db.execSQL(creat_table);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop_table = "DROP TABLE IF EXISTS contacts";
        db.execSQL(drop_table);
        onCreate(db);


    }




  public void addContact(Contact contact) {
      SQLiteDatabase db = this.getWritableDatabase();

      ContentValues values = new ContentValues();

      values.put("name", contact.getName());
      values.put("phoneNumber", contact.getPhoneNumber());

      db.insert("contacts", null, values);

  }


  public List<Contact> getAllContact(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Contact> contactList = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM contacts",null);

        if (cursor.moveToFirst()){

            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPhoneNumber(cursor.getString(2));
                contactList.add(contact);
            }while (cursor.moveToNext());
        }
        return contactList;
  }


  public Contact getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("contacts",new String[]{"id","name","phoneNumber"},"id =?",new String[]{String.valueOf(id)},null,null,null);
      if (cursor != null)
          cursor.moveToFirst();

          Contact contact = new Contact();

          contact.setId(Integer.parseInt(cursor.getString(0)));
          contact.setName(cursor.getString(0));
          contact.setPhoneNumber(cursor.getString(2));
          return contact;



  }




}
