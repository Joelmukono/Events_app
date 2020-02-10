package com.joel.events.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.joel.events.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddEvents extends AppCompatActivity implements View.OnClickListener {



    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.addEventButton) Button mAddEvent;
    @BindView(R.id.eventEditText) EditText mEventText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        ButterKnife.bind(this);

        mAddEvent.setOnClickListener(this);


    }

    @Override
    public void onClick(View v){
        if(v == mAddEvent){
            String event = mEventText.getText().toString();
            Intent intent = new Intent(AddEvents.this, EventDisplay.class );
            intent.putExtra("event",event);
            startActivity(intent);

        }

    }
}
