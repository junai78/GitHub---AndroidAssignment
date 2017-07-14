package com.coursework.newinti.androidassignment;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by jshar on 12-Jul-17.
 */

public class History extends AppCompatActivity {
    //private MySQLiteHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_layout);

        //can't understand how to configure the List<E>
        /*
        database = new MySQLiteHelper(this);
        database.open();

        List<> values = database.getAllData();

        ArrayAdapter<> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, values);
        setListAdapter(adapter);
        */
    }
}


