package com.example.data;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;

import com.example.data.model.Contact;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DatabaseHandeler databaseHandeler = new DatabaseHandeler(getApplicationContext());
        

        Contact contact = new Contact();
        contact.setName("Anthonymicheal");
        contact.setPhoneNumber("090999");
       // databaseHandeler.addContact(contact);
        //Log.d(TAG, "onCreate: added");
        List<Contact> contactList = databaseHandeler.getAllContact();
        for (Contact contact1: contactList){
            Log.d(TAG, "onCreate: "+contact1.getName());
        }
      
        
        




    }
}
