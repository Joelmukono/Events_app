package com.joel.events.adapters;



import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.joel.events.models.Category;
import com.joel.events.ui.EventDetailFragment;



import java.util.List;
import java.util.ArrayList;

public class EventPagerAdapter extends FragmentPagerAdapter {

    private List<Category> mCategory;

    public EventPagerAdapter(FragmentManager fm, int behavior, List<Category> categories) {
        super(fm, behavior);
        mCategory= categories;
    }

    @Override
    public Fragment getItem(int position) {
        return EventDetailFragment.newInstance(mCategory.get(position));
    }

    @Override
    public int getCount() {
        return mCategory.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mCategory.get(position).getName();
    }
}