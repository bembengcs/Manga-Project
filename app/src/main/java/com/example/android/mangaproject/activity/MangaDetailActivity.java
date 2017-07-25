package com.example.android.mangaproject.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.android.mangaproject.R;
import com.example.android.mangaproject.adapter.TabsPagerAdapter;
import com.example.android.mangaproject.fragment.ChaptersFragment;
import com.example.android.mangaproject.fragment.InfoFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MangaDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.pager)
    ViewPager pager;

    public String i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_manga);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupViewPager(pager);
        tabs.setupWithViewPager(pager);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            if (bundle == null) {
                i = null;
            } else {
                i = bundle.getString("i");
            }
        } else {
            i = (String) savedInstanceState.getSerializable(i);
        }
    }

    private void setupViewPager(ViewPager pager) {
        TabsPagerAdapter mAdapter = new TabsPagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(new InfoFragment(), "INFO");
        mAdapter.addFragment(new ChaptersFragment(), "CHAPTERS");
        pager.setAdapter(mAdapter);
    }
}
