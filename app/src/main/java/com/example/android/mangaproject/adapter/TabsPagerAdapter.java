package com.example.android.mangaproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.android.mangaproject.fragment.ChaptersFragment;
import com.example.android.mangaproject.fragment.InfoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bembengcs on 7/20/2017.
 */

public class TabsPagerAdapter extends FragmentPagerAdapter {

    String mMangaId;
    String mTitles[] = {"INFO", "CHAPTERS"};

    public TabsPagerAdapter(FragmentManager manager, String mangaId) {
        super(manager);
        mMangaId = mangaId;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return InfoFragment.newInstance(mMangaId);
        } else if (position == 1) {
            return ChaptersFragment.newInstance(mMangaId);
        } else return new Fragment();
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
