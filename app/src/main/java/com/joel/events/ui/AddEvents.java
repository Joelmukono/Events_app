package com.joel.events.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.joel.events.Constants;
import com.joel.events.R;
import com.joel.events.interfaces.EventsApi;
import com.joel.events.models.EventsSearchResponse;
import com.joel.events.services.EventsClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddEvents extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.addEventButton) Button mAddEvent;
    @BindView(R.id.eventEditText) EditText mEventText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        mAddEvent.setOnClickListener(this);




    }

    @Override
    public void onClick(View v){
        if(v == mAddEvent){
            String event = mEventText.getText().toString();
            if(!(event).equals("")) {
                addToSharedPreferences(event);
            }

            Intent intent = new Intent(AddEvents.this, EventDisplay.class );
            intent.putExtra("event",event);
            startActivity(intent);

        }

    }

    private void addToSharedPreferences(String event) {
        mEditor.putString(Constants.PREFERENCES_EVENT_KEY, event).apply();
    }
}
