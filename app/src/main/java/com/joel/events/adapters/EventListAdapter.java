package com.joel.events.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.joel.events.models.Category;
import com.joel.events.R;
import com.joel.events.ui.EventDetailActivity;
import com.joel.events.ui.EventDisplay;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder>{
    private List<Category> mEvents;
    private Context mContext;


    public EventListAdapter(Context context,List<Category> categories){
        mContext = context;
        mEvents = categories;
    }

    @Override
    public EventListAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_list_display, parent, false);
        EventViewHolder viewHolder = new EventViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventListAdapter.EventViewHolder holder, int position) {
        holder.bindEvent(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.categoryNameTextView) TextView mCategoryNameTextView;
        @BindView(R.id.categoryShortTextView) TextView mCategoryTextView;
        @BindView(R.id.resourceTextView) TextView mResourceTextView;
        private Context mContext;
        private int mOrientation;

        public EventViewHolder(View itemView) {


            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, EventDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("restaurants", Parcels.wrap(mEvents));
            mContext.startActivity(intent);
        }

        public void bindEvent(Category category) {
            mCategoryNameTextView.setText(category.getName());
            mCategoryTextView.setText(category.getShortName());
            mResourceTextView.setText(category.getResourceUri());
        }
    }


}
