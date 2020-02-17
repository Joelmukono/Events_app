package com.joel.events.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.joel.events.Constants;
import com.joel.events.R;
import com.joel.events.adapters.FirebaseEventViewHolder;
import com.joel.events.models.Category;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SavedRestaurantListActivity extends AppCompatActivity {
    private DatabaseReference mRestaurantReference;
    private FirebaseRecyclerAdapter<Category, FirebaseEventViewHolder> mFirebaseAdapter;

    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_display);
        ButterKnife.bind(this);

        mRestaurantReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_CATEGORIES);

        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Category> options = new FirebaseRecyclerOptions.Builder<Category>().setQuery(mRestaurantReference,Category.class).build();

        mFirebaseAdapter = new FirebaseRecyclerAdapter<Category, FirebaseEventViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseEventViewHolder firebaseEventViewHolder, int i, @NonNull Category category) {
                firebaseEventViewHolder.bindEvents(category);

            }
            @NonNull
            @Override
            public FirebaseEventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_list_display,parent,false);
                return  new FirebaseEventViewHolder(view);

            }

        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAdapter!= null) {
            mFirebaseAdapter.stopListening();
        }
    }
}
