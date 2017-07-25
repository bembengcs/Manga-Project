package com.example.android.mangaproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.mangaproject.R;
import com.example.android.mangaproject.model.MangaDetail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bembengcs on 7/24/2017.
 */

public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.ChapterViewHolder> {

    @BindView(R.id.tv_list_chapters)
    TextView tvListChapters;

    private MangaDetail mangaDetail;
    private List<List<Integer>> chapters;
    private int position;
    private Context context;

    public class ChapterViewHolder extends RecyclerView.ViewHolder {

        private List<List<Integer>> chapters;
        private MangaDetail mangaDetail;

        public ChapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(List<List<Integer>> chapters, MangaDetail mangaDetail) {
            this.chapters = chapters;
            this.mangaDetail = mangaDetail;
//            tvListChapters.setText(mangaDetail.getChapters());
        }

    }

    public ChaptersAdapter(List<List<Integer>> chapters, Context context) {
        this.chapters = chapters;
        this.context = context;
    }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_chapter, null);
        return new ChapterViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {
//        holder.bind(chapters);
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

}
