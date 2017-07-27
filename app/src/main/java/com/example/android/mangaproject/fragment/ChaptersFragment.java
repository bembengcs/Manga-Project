package com.example.android.mangaproject.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.mangaproject.activity.MangaDetailActivity;
import com.example.android.mangaproject.activity.MangaReadActivity;
import com.example.android.mangaproject.adapter.ChaptersAdapter;
import com.example.android.mangaproject.model.MangaDetail;
import com.example.android.mangaproject.R;
import com.example.android.mangaproject.rest.ApiClient;
import com.example.android.mangaproject.rest.ApiInterface;
import com.example.android.mangaproject.util.GridSpacingItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ChaptersFragment extends Fragment implements ChaptersAdapter.OnItemClickListener {

    @BindView(R.id.rv_item_list_chapter)
    RecyclerView rvItemListChapter;

    Unbinder unbinder;
    private ChaptersAdapter adapter;
    private List<List<Object>> chapters;
    ApiInterface apiService;
    public Context context;
    private String mMangaId;

    public ChaptersFragment() {
        // Required empty public constructor
    }

    public static ChaptersFragment newInstance(String mangaId) {
        Bundle args = new Bundle();
        args.putString("i", mangaId);
        ChaptersFragment fragment = new ChaptersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = ApiClient.getClient().create(ApiInterface.class);

        Bundle bundle = getArguments();
        if (bundle != null) {
            mMangaId = bundle.getString("i");
        }
    }

    private void loadData() {
        Call<MangaDetail> call = apiService.getMangaDetail(mMangaId);
        call.enqueue(new Callback<MangaDetail>() {
            @Override
            public void onResponse(Call<MangaDetail> call, Response<MangaDetail> response) {
                if (response.isSuccessful()) {
                    chapters = response.body().getChapters();
                    setUpValue(chapters);
                    Log.i(TAG, "chapters : " + chapters);
//                    Toast.makeText(getContext(), "load chapters", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "Error to get manga chapters by id");
                }
            }


            @Override
            public void onFailure(Call<MangaDetail> call, Throwable t) {
                Log.e(TAG, t.toString());
//                t.printStackTrace();
            }
        });
    }

    private void setUpValue(List<List<Object>> chapters) {
        rvItemListChapter.setLayoutManager(new LinearLayoutManager(context));
        adapter = new ChaptersAdapter(chapters, context, this);
        rvItemListChapter.setAdapter(adapter);
    }

    @Override
    public void onItemClick(int position, Object o) {
        Intent intent = new Intent(getContext(), MangaReadActivity.class);
        intent.putExtra("o", o.toString());
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chapters, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
    }


}
