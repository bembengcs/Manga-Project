package com.example.android.mangaproject.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.mangaproject.model.Manga;
import com.example.android.mangaproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bembengcs on 7/19/2017.
 */

public class MangasAdapter extends RecyclerView.Adapter<MangasAdapter.MangaViewHolder> {

    private List<Manga> mangas;
    private Context context;
    private OnItemClickListener listener;


    public class MangaViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_manga_poster)
        ImageView ivMangaPoster;
        @BindView(R.id.tv_manga_title)
        TextView ivMangaTitle;
        @BindView(R.id.card_view)
        CardView cardView;
        private int position;
        private Manga manga;

        @OnClick(R.id.card_view)

        public void onViewClicked() {
            listener.onItemClick(position, manga.getI());
        }

        public MangaViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Manga manga, int position) {
            this.manga = manga;
            this.position = position;
            // set title
            ivMangaTitle.setText(manga.getT());
            // set image
            ivMangaPoster.setAdjustViewBounds(true);
            Glide.with(context)
                    .load(manga.getIm())
                    .override(245, 350)
                    .centerCrop()
                    .placeholder(R.drawable.searching)
                    .error(R.drawable.error_not_found)
                    .into(ivMangaPoster);
        }
    }

    public MangasAdapter(List<Manga> mangas, Context context, OnItemClickListener listener) {
        this.mangas = mangas;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public MangaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_manga, null);
        return new MangaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MangaViewHolder holder, int position) {
        holder.bind(mangas.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mangas.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position, String mangaId);
    }
}
