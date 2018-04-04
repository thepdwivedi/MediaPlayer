package com.dbrothers.pankaj_pc.mediaplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj-PC on 4/4/2018.
 */

public class SongsListDatabase {
    public static List<AudioModel> songList=new ArrayList<>();
    public static List<AudioModel> getSongList() {
        return songList;
    }

    public static void setSongList(List<AudioModel> songList) {
        SongsListDatabase.songList = songList;
    }


}
