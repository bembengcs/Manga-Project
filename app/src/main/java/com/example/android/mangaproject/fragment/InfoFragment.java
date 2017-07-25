package com.example.android.mangaproject.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.mangaproject.model.MangaDetail;
import com.example.android.mangaproject.activity.MangaDetailActivity;
import com.example.android.mangaproject.R;
import com.example.android.mangaproject.rest.ApiClient;
import com.example.android.mangaproject.rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoFragment extends Fragment {

    private static final String TAG = MangaDetailActivity.class.getSimpleName();
    @BindView(R.id.iv_manga_poster)
    ImageView ivMangaPoster;
    @BindView(R.id.tv_manga_title)
    TextView tvMangaTitle;
    @BindView(R.id.tv_manga_author)
    TextView tvMangaAuthor;
    @BindView(R.id.tv_manga_chapters)
    TextView tvMangaChapters;
    @BindView(R.id.tv_manga_status)
    TextView tvMangaStatus;
    @BindView(R.id.tv_manga_ranking)
    TextView tvMangaRanking;
    @BindView(R.id.tv_manga_last_chaptes_date)
    TextView tvMangaLastChaptesDate;
    @BindView(R.id.tv_manga_genre)
    TextView tvMangaGenre;
    @BindView(R.id.tv_description)
    TextView tvDescription;
    @BindView(R.id.info_fragment)
    FrameLayout infoFragment;
    Unbinder unbinder;

    ApiInterface apiService;
    private MangaDetail mangaDetail;

    public InfoFragment() {

    }

    public InfoFragment(String i) {
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
                    mangaDetail = response.body();
                    setUpValue(mangaDetail);
                    Toast.makeText(getContext(), "onResponse", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e(TAG, "Error to get manga detail");
                }
            }

            @Override
            public void onFailure(Call<MangaDetail> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void setUpValue(MangaDetail mangaDetail) {
        this.mangaDetail = mangaDetail;

        Toast.makeText(getContext(), "setUpValue", Toast.LENGTH_SHORT).show();

        Glide.with(this)
                .load(mangaDetail.getImageURL())
                .override(245, 350)
                .centerCrop()
                .placeholder(R.drawable.searching)
                .error(R.drawable.error_not_found)
                .into(ivMangaPoster);
        ivMangaPoster.setAdjustViewBounds(true);

        tvMangaTitle.setText(mangaDetail.getTitle());
        tvMangaAuthor.setText(mangaDetail.getAuthor());
        tvMangaLastChaptesDate.setText(mangaDetail.getChaptersLen());
        tvMangaStatus.setText(mangaDetail.getStatus());
        tvDescription.setText(mangaDetail.getDescription());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
