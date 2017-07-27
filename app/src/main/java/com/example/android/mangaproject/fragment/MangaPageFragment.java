package com.example.android.mangaproject.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.example.android.mangaproject.R;
import com.example.android.mangaproject.model.MangaPage;
import com.example.android.mangaproject.rest.ApiClient;
import com.example.android.mangaproject.rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import uk.co.senab.photoview.PhotoView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MangaPageFragment extends Fragment {

    private static final String TAG = MangaPageFragment.class.getSimpleName();
    ApiInterface apiService;
    MangaPage mangaPage;
    @BindView(R.id.pb_manga_page)
    ProgressBar pbMangaPage;
    Unbinder unbinder;
    @BindView(R.id.pv_mange_page)
    PhotoView pvMangePage;
    private String BASE_URL_IMAGE = "https://cdn.mangaeden.com/mangasimg/";
    private String URL;
    private int position;

    public MangaPageFragment() {
        // Required empty public constructor
    }

    public static MangaPageFragment newInstance(String URL) {
        Bundle args = new Bundle();
        args.putString("URL", URL);
        MangaPageFragment fragment = new MangaPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiService = ApiClient.getClient().create(ApiInterface.class);

        Bundle bundle = getArguments();
        if (bundle != null) {
            URL = bundle.getString("URL");
        }

    }

    private void setupValue() {
        Glide.with(this)
                .load(BASE_URL_IMAGE + URL)
                .into(pvMangePage);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manga_page, container, false);
        unbinder = ButterKnife.bind(this, view);
        setupValue();
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
    }
}
