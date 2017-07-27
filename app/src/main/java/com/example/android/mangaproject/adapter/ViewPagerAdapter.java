package com.example.android.mangaproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.android.mangaproject.fragment.MangaPageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bembengcs on 7/25/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> mPageURL = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager, List<String> mPageURL) {
        super(manager);
        this.mPageURL = mPageURL;
    }


    @Override
    public Fragment getItem(int position) {
        return MangaPageFragment.newInstance(mPageURL.get(position));
    }

    @Override
    public int getCount() {
        return mPageURL.size();
    }

}
