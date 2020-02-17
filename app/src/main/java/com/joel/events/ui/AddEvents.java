package com.joel.events.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.joel.events.Constants;
import com.joel.events.R;
import com.joel.events.interfaces.EventsApi;
import com.joel.events.models.EventsSearchResponse;
import com.joel.events.services.EventsClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddEvents extends AppCompatActivity implements View.OnClickListener {

//    private SharedPreferences mSharedPreferences;
//    private SharedPreferences.Editor mEditor;

    private DatabaseReference mSearchedEventReference;
    private ValueEventListener mSearchedEventReferenceListener;

    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.addEventButton) Button mAddEvent;
    @BindView(R.id.eventEditText) EditText mEventText;
    @BindView(R.id.savedRestaurantsButton) Button mSavedRestaurantsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSearchedEventReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_SEARCHED_CATEGORY);



        mSearchedEventReferenceListener = mSearchedEventReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot eventSnapshot : dataSnapshot.getChildren()){
                    String event = eventSnapshot.getValue().toString();
                    Log.d("Locations updated", "location: " + event);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_events);

        ButterKnife.bind(this);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mEditor = mSharedPreferences.edit();

        mAddEvent.setOnClickListener(this);
        mSavedRestaurantsButton.setOnClickListener(this);




    }

    @Override
    public void onClick(View v){
        if(v == mAddEvent){
            String event = mEventText.getText().toString();
            saveLocationToFirebase(event);

//            if(!(event).equals("")) {
//                addToSharedPreferences(event);
//            }

            Intent intent = new Intent(AddEvents.this, EventDisplay.class );
            intent.putExtra("event",event);
            startActivity(intent);

        }

        if (v == mSavedRestaurantsButton) {
            Intent intent = new Intent(AddEvents.this, SavedRestaurantListActivity.class);
            startActivity(intent);
        }


    }

    public void saveLocationToFirebase(String event) {
        mSearchedEventReference.push().setValue(event);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSearchedEventReference.removeEventListener(mSearchedEventReferenceListener);
    }

//    private void addToSharedPreferences(String event) {
//        mEditor.putString(Constants.PREFERENCES_EVENT_KEY, event).apply();
//    }
}
