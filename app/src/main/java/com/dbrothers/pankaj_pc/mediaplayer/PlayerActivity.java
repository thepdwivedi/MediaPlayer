package com.dbrothers.pankaj_pc.mediaplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {
    List<AudioModel> songList;
    int position=0;
    TextView songName;
    MediaPlayer myPlayer;
    Button play,pause,next,prev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        play=(Button) findViewById(R.id.btnplay);
        play.setOnClickListener(this);
        pause=(Button) findViewById(R.id.btnpause);
        pause.setOnClickListener(this);
        next=(Button) findViewById(R.id.btnnext);
        next.setOnClickListener(this);
        prev=(Button) findViewById(R.id.btnprevious);
        prev.setOnClickListener(this);

        songList=SongsListDatabase.getSongList();
        position=getIntent().getIntExtra("position",0);
        songName=(TextView) findViewById(R.id.songName);
        songName.setText((CharSequence) songList.get(position).getaName());
        myPlayer = MediaPlayer.create(this, Uri.parse(songList.get(position).getaPath()));
        myPlayer.setLooping(true); // Set loopingmyPlayer.start();
        myPlayer.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnplay:
                try {
                    myPlayer.reset();
                    myPlayer.setDataSource(songList.get(position).getaPath());
                    myPlayer.prepare();
                    myPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnpause:
                myPlayer.stop();
                break;
            case R.id.btnnext:
                position++;
                position=position>songList.size()?songList.size()-1:position;
                songName.setText((CharSequence) songList.get(position).getaName());
                try {
                    myPlayer.reset();
                    myPlayer.setDataSource(songList.get(position).getaPath());
                    myPlayer.prepare();
                    myPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btnprevious:
                position--;
                position=position<0?0:position;
                songName.setText((CharSequence) songList.get(position).getaName());
                try {
                    myPlayer.reset();
                    myPlayer.setDataSource(songList.get(position).getaPath());
                    myPlayer.prepare();
                    myPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
