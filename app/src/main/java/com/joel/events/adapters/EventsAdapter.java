package com.joel.events.adapters;
import android.content.Context;

import android.widget.ArrayAdapter;
public class EventsAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mEvents;
    private String[] mLocations;

    public EventsAdapter(Context mContext, int resource, String[] mEvents, String[] mLocations){
        super(mContext,resource);
        this.mContext = mContext;
        this.mEvents = mEvents;
        this.mLocations = mLocations;
    }

    @Override
    public Object getItem(int position){
        String event = mEvents[position];
        String locations = mLocations[position];
        return String.format("%s \nHappening in: %s",event,locations);
    }

    @Override
    public int getCount(){
        return mEvents.length;
    }
}
