package com.joel.events.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.View;
import android.widget.TextView;

import com.joel.events.Constants;
import com.joel.events.models.Category;
import com.joel.events.adapters.EventListAdapter;
import com.joel.events.adapters.EventsAdapter;
import com.joel.events.R;
import com.joel.events.interfaces.EventsApi;
import com.joel.events.models.EventsSearchResponse;
import com.joel.events.services.EventsClient;

import java.util.List;

public class EventDisplay extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentCategory;

//    private SharedPreferences mSharedPreferences;
//    private String mRecentAddress;

    private static final String TAG = EventDisplay.class.getSimpleName();

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;

    private EventListAdapter mAdapter;

    public List<com.joel.events.models.Category> categories;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event_display);

        ButterKnife.bind(this);

//        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
//        mRecentAddress = mSharedPreferences.getString(Constants.PREFERENCES_EVENT_KEY, null);
//        if (mRecentAddress != null) {
//            getRestaurants(mRecentAddress);
//        }
        Intent intent = getIntent();
        String event = intent.getStringExtra("event");

        getEvent(event);


        EventsApi client = EventsClient.getClient();


        Call<EventsSearchResponse> call = client.getCategories("name");

        call.enqueue(new Callback<EventsSearchResponse>() {
            @Override
            public void onResponse(Call<EventsSearchResponse> call, Response<EventsSearchResponse> response) {
                hideProgressBar();
                if (response.isSuccessful()) {
                    categories = response.body().getCategories();
                    mAdapter = new EventListAdapter(EventDisplay.this,categories);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EventDisplay.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);
                    showEvents();

                }else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<EventsSearchResponse> call, Throwable t) {
                Log.e(TAG, "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();

            }


        });

    }



    private  void getEvent(String location){
        final EventsClient yelpBusinessesSearchResponse = new EventsClient();

        yelpBusinessesSearchResponse.getClient();
    }

    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showEvents() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
    private void addToSharedPreferences(String location) {
        mEditor.putString(Constants.PREFERENCES_EVENT_KEY, location).apply();
    }



}
