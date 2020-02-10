package com.joel.events.adapters;
import android.content.Context;

import android.widget.ArrayAdapter;
public class EventsAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mEvents;
    private String[] mCategories;

    public EventsAdapter(Context mContext, int resource, String[] categories){
        super(mContext,resource);
        this.mContext = mContext;
        this.mEvents = mEvents;
        this.mCategories = categories;
    }

    @Override
    public Object getItem(int position){
//        String event = mEvents[position];
        String locations = mCategories[position];
        return String.format(" \nEvent Category: %s",locations);
    }

    @Override
    public int getCount(){
        return mCategories.length;
//        return 21;
    }
}
