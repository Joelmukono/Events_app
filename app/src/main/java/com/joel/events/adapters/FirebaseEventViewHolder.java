package com.joel.events.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.joel.events.Constants;
import com.joel.events.R;
import com.joel.events.models.Category;
import com.joel.events.ui.EventDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.BindView;

public class FirebaseEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseEventViewHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindEvents(Category category){
        TextView categoryNameView = (TextView) mView.findViewById(R.id.categoryNameTextView);
        TextView websiteLink = (TextView) mView.findViewById(R.id.websiteLink);


        categoryNameView.setText(category.getName());
        websiteLink.setText(category.getResourceUri());
    }

    @Override
    public void onClick(View view){
        final ArrayList<Category> events = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_CATEGORIES);

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    events.add(snapshot.getValue(Category.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent(mContext, EventDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("restaurants", Parcels.wrap(events));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
