package com.example.android.mangaproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.mangaproject.adapter.ChaptersAdapter;
import com.example.android.mangaproject.model.MangaDetail;
import com.example.android.mangaproject.R;
import com.example.android.mangaproject.rest.ApiClient;
import com.example.android.mangaproject.rest.ApiInterface;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class ChaptersFragment extends Fragment {

    @BindView(R.id.rv_item_list_chapter)
    RecyclerView rvItemListChapter;

    Unbinder unbinder;
    private ChaptersAdapter adapter;
    private List<List<Integer>> chapters;
    ApiInterface apiService;

    public ChaptersFragment() {
        // Required empty public constructor
    }

    public ChaptersFragment(String i) {
        Bundle bundle = new Bundle();
        bundle.putString("i", i);
        InfoFragment fragment = new InfoFragment();
        fragment.setArguments(bundle);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiService = ApiClient.getClient().create(ApiInterface.class);
        loadData();
    }

    private void loadData() {
        Call<MangaDetail> call = apiService.getMangaDetail(getActivity().getIntent().getStringExtra("i"));
        call.enqueue(new Callback<MangaDetail>() {
            @Override
            public void onResponse(Call<MangaDetail> call, Response<MangaDetail> response) {
                if (response.isSuccessful()) {
                    chapters = response.body().getChapters();

                    setUpValue(chapters, getContext());

                } else {
                    Log.e(TAG, "Error to get manga chapters by id");
                }
            }


            @Override
            public void onFailure(Call<MangaDetail> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void setUpValue(List<List<Integer>> chapters, Context context) {
        adapter = new ChaptersAdapter(chapters, context);
        rvItemListChapter.setAdapter(adapter);
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
}
