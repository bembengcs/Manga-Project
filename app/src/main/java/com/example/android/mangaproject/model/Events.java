package com.example.android.mangaproject.model;

/**
 * Created by bembengcs on 7/28/2017.
 */

public class Events {
    public static class MangaReadyEvent {
        private final int i;

        public MangaReadyEvent(int i) {
            this.i = i;
        }

        public int getCounter(){
            return i;
        }
    }
}
