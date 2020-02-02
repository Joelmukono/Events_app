package com.joel.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class EventDisplay extends AppCompatActivity {
    private ListView meventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_display);
        meventList = (ListView) findViewById(R.id.eventList);
        Intent intent = getIntent();
        String events = intent.getStringExtra("event");

    }
}
