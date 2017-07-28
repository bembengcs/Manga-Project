package com.example.android.mangaproject.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.mangaproject.R;
import com.example.android.mangaproject.adapter.ViewPagerAdapter;
import com.example.android.mangaproject.model.Events;
import com.example.android.mangaproject.model.MangaPage;
import com.example.android.mangaproject.rest.ApiClient;
import com.example.android.mangaproject.rest.ApiInterface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MangaReadActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @BindView(R.id.pb_horizontal)
    ProgressBar pbHorizontal;
    @BindView(R.id.vp_manga_read)
    ViewPager vpMangaRead;
    @BindView(R.id.tv_page_indicator)
    TextView tvPageIndicator;
    @BindView(R.id.rl_manga_read)
    RelativeLayout rlMangaRead;
    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    public String o;
    private ApiInterface apiService;
    private MangaPage mangaPage;
    private String TAG = MangaReadActivity.class.getSimpleName();
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manga_read);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        apiService = ApiClient.getClient().create(ApiInterface.class);
        o = getIntent().getStringExtra("o");
        vpMangaRead.addOnPageChangeListener(this);
        loadData();
    }


    private void setupViewPager(List<String> mangaPageUrlList) {
        ViewPagerAdapter mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mangaPageUrlList);
        vpMangaRead.setAdapter(mAdapter);
    }

    private void loadData() {
        Call<MangaPage> call = apiService.getPageImage(o);
        call.enqueue(new Callback<MangaPage>() {
            @Override
            public void onResponse(Call<MangaPage> call, Response<MangaPage> response) {
                if (response.isSuccessful()) {
                    mangaPage = response.body();
                    setUpValue(mangaPage);
                } else {
                    Log.e(TAG, "Error to get manga page");
                }
            }

            @Override
            public void onFailure(Call<MangaPage> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void setUpValue(MangaPage mangaPage) {
        this.mangaPage = mangaPage;

        List<String> mangaPageUrlList = new ArrayList<>();
        for (int i = 0; i < mangaPage.getImages().size(); i++) {
            mangaPageUrlList.add(mangaPage.getImages().get(i).get(1).toString());
        }
        Collections.reverse(mangaPageUrlList);
        setupViewPager(mangaPageUrlList);

        pbHorizontal.setMax(mangaPage.getImages().size());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        List<String> mangaPageList = new ArrayList<>();
        for (int i = 0; i < mangaPage.getImages().size(); i++) {
            mangaPageList.add(mangaPage.getImages().get(i).get(0).toString());
        }
        Collections.reverse(mangaPageList);
        tvPageIndicator.setText("Page " + (position + 1) + " of " + mangaPage.getImages().size());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(Events.MangaReadyEvent event) {
        counter++;
        pbHorizontal.setProgress(counter);
    }
}
