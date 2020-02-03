package com.joel.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.View;
import android.widget.TextView;
import android.widget.ListView;

public class EventDisplay extends AppCompatActivity {

    @BindView(R.id.eventsText) TextView mEventsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_display);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String events = intent.getStringExtra("event");
        mEventsText.setText("Event name is :" + events);


    }
}
