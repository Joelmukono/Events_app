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
    @BindView(R.id.eventList) ListView mEventsList;

    private String[] events = new String[] {"hackerthon","birthday","graduation","openDay",
            "thursday speaker","goCarting","music concert", "movie premere"};

    private  String[] locations = new String[] {"westlands","ngong road","karen","kileleshwa",
            "uthiru","kikuyu","runda","parklands"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_display);

        ButterKnife.bind(this);

        EventsAdapter adapter = new EventsAdapter(this,android.R.layout.simple_list_item_1,events,locations);
        mEventsList.setAdapter(adapter);

        mEventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String event = ((TextView)view).getText().toString();
                Toast.makeText(EventDisplay.this,event,Toast.LENGTH_LONG).show();
            }
        });


        Intent intent = getIntent();
        String events = intent.getStringExtra("event");
        mEventsText.setText("Event name is :" + events);


    }
}
