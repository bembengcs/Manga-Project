package com.example.android.mangaproject.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.android.mangaproject.R;
import com.example.android.mangaproject.adapter.TabsPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MangaDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.pager)
    ViewPager pager;

    String mMangaId;
    private String TAG = MangaDetailActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_manga);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mMangaId = getIntent().getStringExtra("i");
        setupViewPager(pager);
        tabs.setupWithViewPager(pager);
    }

    private void setupViewPager(ViewPager pager) {
        TabsPagerAdapter mAdapter = new TabsPagerAdapter(getSupportFragmentManager(), mMangaId);
        pager.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
