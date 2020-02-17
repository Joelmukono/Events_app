package com.joel.events.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.joel.events.Constants;
import com.joel.events.R;
import com.joel.events.models.Category;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.restaurantImageView) ImageView mImageLabel;
    @BindView(R.id.categoryNameTextView) TextView mNameLabel;
    @BindView(R.id.websiteLink) TextView mWebsiteLabel;
    @BindView(R.id.saveCategoryButton) TextView mSaveRestaurantButton;

    private Category mCategory;


    public EventDetailFragment() {
        // Required empty public constructor
    }

    public static EventDetailFragment newInstance(Category restaurant) {
        EventDetailFragment restaurantDetailFragment = new EventDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("category", Parcels.wrap(restaurant));
        restaurantDetailFragment.setArguments(args);
        return restaurantDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCategory = Parcels.unwrap(getArguments().getParcelable("category"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail,container,false);
        ButterKnife.bind(this,view);


        List<String> categories = new ArrayList<>();



        mNameLabel.setText(mCategory.getName());
        mNameLabel.setText(android.text.TextUtils.join(", ", categories));
        mWebsiteLabel.setText(mCategory.getResourceUri());

        mNameLabel.setOnClickListener(this);
        mNameLabel.setOnClickListener(this);
        mWebsiteLabel.setOnClickListener(this);

        mSaveRestaurantButton.setOnClickListener(this);


        return view;
    }

    public void onClick(View v){

        if (v == mSaveRestaurantButton) {
            DatabaseReference restaurantRef = FirebaseDatabase
                    .getInstance()
                    .getReference(Constants.FIREBASE_CHILD_CATEGORIES);
            restaurantRef.push().setValue(mCategory);
            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }

    }



}
