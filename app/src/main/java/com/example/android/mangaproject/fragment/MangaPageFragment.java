package com.example.android.mangaproject.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.android.mangaproject.R;
import com.example.android.mangaproject.model.Events;
import com.example.android.mangaproject.model.MangaPage;
import com.example.android.mangaproject.rest.ApiClient;
import com.example.android.mangaproject.rest.ApiInterface;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    @BindView(R.id.pb_manga_page)
    ProgressBar pbMangaPage;
    Unbinder unbinder;
    @BindView(R.id.pv_mange_page)
    PhotoView pvMangePage;
    private String BASE_URL_IMAGE = "https://cdn.mangaeden.com/mangasimg/";
    private String URL;
    private MangaPage mangaPage;
    private int pbCounter;

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
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        EventBus.getDefault().post(new Events.MangaReadyEvent(0));
                        return false;
                    }
                })
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
        Log.i(TAG, String.valueOf(event.getCounter()));
    }

}
