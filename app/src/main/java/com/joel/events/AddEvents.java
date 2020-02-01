package com.joel.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;

public class AddEvents extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.addEventButton) Button mAddEvent;
    @BindView(R.id.eventEditText) Button mEventText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        mAddEvent.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        if(v == mAddEvent){
            String event = mEventText.getText().toString();
            Intent intent = new Intent(AddEvents.this,EventDisplay.class );

        }

    }
}
