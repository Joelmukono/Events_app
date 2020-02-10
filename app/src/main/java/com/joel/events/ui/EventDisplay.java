package com.joel.events.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

import com.joel.events.Category;
import com.joel.events.adapters.EventsAdapter;
import com.joel.events.R;
import com.joel.events.interfaces.EventsApi;
import com.joel.events.models.EventsSearchResponse;
import com.joel.events.services.EventsClient;

import java.util.List;

public class EventDisplay extends AppCompatActivity {

    private static final String TAG = EventDisplay.class.getSimpleName();

    @BindView(R.id.eventsText) TextView mEventsText;
    @BindView(R.id.eventList) ListView mEventsList;
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_display);

        ButterKnife.bind(this);

        EventsApi client = EventsClient.getClient();


        Call<EventsSearchResponse> call = client.getCategories("name");

        call.enqueue(new Callback<EventsSearchResponse>() {
            @Override
            public void onResponse(Call<EventsSearchResponse> call, Response<EventsSearchResponse> response) {
                if (response.isSuccessful()) {
                    List<Category> categoryList = response.body().getCategories();
                    String[] categry = new String[categoryList.size()];

                    for (int i = 0; i < categry.length; i++) {
                        categry[i] = categoryList.get(i).getName();
                    }

                    ArrayAdapter adapter = new EventsAdapter(EventDisplay.this, android.R.layout.simple_list_item_1, categry);
                    mEventsList.setAdapter(adapter);


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
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRestaurants() {
        mEventsList.setVisibility(View.VISIBLE);
        mEventsText.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }



}
