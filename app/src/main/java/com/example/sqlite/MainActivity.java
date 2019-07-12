package com.example.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        Log.d("DB Count:", String.valueOf(db.getContactsCount()));

        Log.d("Insert: ", "Insertin...");
        db.addContact(new Contact("Paul", "83895954039"));
        db.addContact(new Contact("Jim", "832222039"));
        db.addContact(new Contact("Maki", "838394439"));
        db.addContact(new Contact("Makoto", "838352259"));

        // Read them back
        Log.d("Reading: " , " reading all contacts...");
        List<Contact> contactList = db.getAllContacts();

        //Get 1 contact
        Contact oneContact = db.getContact(1);
//
//        //Update contact
//        int newContact = db.updateContact(oneContact);
//
//        Log.d("One Contact: ", "Updated Row: " + String.valueOf(newContact ) + "Name: " + oneContact.getName() + "Phone: " + oneContact.getPhoneNumber());
        db.deleteContact(oneContact);
        for (Contact c : contactList) {
            String log = "ID: " + c.getId() + " , Name: " + c.getName() + ", Phone: " + c.getPhoneNumber();

            Log.d("Name: " , log);
        }
    }
}
