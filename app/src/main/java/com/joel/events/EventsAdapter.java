package com.joel.events;
import android.content.Context;

import android.widget.ArrayAdapter;
public class EventsAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mEvents;

    public EventsAdapter(Context mContext, int resource, String[] mEvents){
        super(mContext,resource);
        this.mContext = mContext;
        this.mEvents = mEvents;
    }

    @Override
    public Object getItem(int position){
        String event = mEvents[position];
        return String.format("%s \nAttend",event);
    }

    @Override
    public int getCount(){
        return mEvents.length;
    }
}
