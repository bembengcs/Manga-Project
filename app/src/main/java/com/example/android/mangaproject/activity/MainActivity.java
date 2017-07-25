package com.example.android.mangaproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.android.mangaproject.util.GridSpacingItemDecoration;
import com.example.android.mangaproject.model.Manga;
import com.example.android.mangaproject.adapter.MangasAdapter;
import com.example.android.mangaproject.model.MangasResponse;
import com.example.android.mangaproject.R;
import com.example.android.mangaproject.rest.ApiClient;
import com.example.android.mangaproject.rest.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MangasAdapter.OnItemClickListener {

    @BindView(R.id.rv_list_manga)
    RecyclerView rvListManga;

    private static final String TAG = MainActivity.class.getSimpleName();
    private MangasAdapter adapter;
    private List<Manga> list_manga;
    ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        apiService = ApiClient.getClient().create(ApiInterface.class);
        loadData();
    }

    private void loadData() {
        Call<MangasResponse> call = apiService.getManga(0, 100);
        call.enqueue(new Callback<MangasResponse>() {
            @Override
            public void onResponse(Call<MangasResponse> call, Response<MangasResponse> response) {
                if (response.isSuccessful()) {
                    list_manga = response.body().getManga();
                    setUpValue(list_manga);
                } else {
                    Log.e(TAG, "Error to get item_list_manga");
                }
            }

            @Override
            public void onFailure(Call<MangasResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    private void setUpValue(List<Manga> list_manga) {
        rvListManga.setLayoutManager(new GridLayoutManager(this, 3));
        rvListManga.addItemDecoration(new GridSpacingItemDecoration(this, 3, 0, true));

        adapter = new MangasAdapter(list_manga, MainActivity.this, this);
        rvListManga.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(int position, String i) {
        Intent intent = new Intent(this, MangaDetailActivity.class);
        intent.putExtra("i", i);
        startActivity(intent);
    }
}