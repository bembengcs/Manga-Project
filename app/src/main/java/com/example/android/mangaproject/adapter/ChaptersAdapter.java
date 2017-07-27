package com.example.android.mangaproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.mangaproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by bembengcs on 7/24/2017.
 */



public class ChaptersAdapter extends RecyclerView.Adapter<ChaptersAdapter.ChapterViewHolder> {

    private List<List<Object>> chapters;
    private Context context;
    private OnItemClickListener listener;


    public class ChapterViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_list_chapters)
        TextView tvListChapters;
        @BindView(R.id.chapters_layout)
        LinearLayout chaptersLayout;

        private List<Object> chapters;
        private int position;
        private OnItemClickListener listener;

        public ChapterViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final List<Object> chapters, final int position, final OnItemClickListener listener) {
            this.chapters = chapters;
            this.position = position;
            this.listener = listener;

            chaptersLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(position, chapters.get(3));
                }
            });

            tvListChapters.setText("Chapters " + chapters.get(0));
        }

    }

    public ChaptersAdapter(List<List<Object>> chapters, Context context, OnItemClickListener listener) {
        this.chapters = chapters;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ChapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_chapter, null);
        return new ChapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChapterViewHolder holder, int position) {
        holder.bind(chapters.get(position), position, listener);
    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position, Object o);
    }

}
