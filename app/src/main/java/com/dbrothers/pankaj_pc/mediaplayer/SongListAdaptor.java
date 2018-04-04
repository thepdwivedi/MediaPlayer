package com.dbrothers.pankaj_pc.mediaplayer;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pankaj-PC on 4/4/2018.
 */

public class SongListAdaptor extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private Context context;
    private MainActivity mainActivity;
    private List<AudioModel> songList=new ArrayList<AudioModel>();

    public SongListAdaptor(MainActivity mainActivity, List<AudioModel> songs) {
        // TODO Auto-generated constructor stub


        context=mainActivity;
        this.mainActivity=mainActivity;
        songList=songs;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return songList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
    private class Holder {
        TextView name;


    }
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder1;
        View rowView1=convertView;
        if(rowView1==null){
            holder1=new Holder();
            rowView1 = inflater.inflate(R.layout.song_row, null);
            holder1.name=(TextView) rowView1.findViewById(R.id.songName);

            rowView1.setTag(holder1);
        }else{
            //holder=(Holder) rowView.getTag();
            holder1=(Holder) rowView1.getTag();
        }



        holder1.name.setText(position+1+":"+songList.get(position).getaName());

        rowView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //  mainActivity.Gotobook(schoolMasters.get(position));

                Log.e("ListView ...", "....."+songList.get(position));
             mainActivity.gotoPlayer(position);



            }
        });
        return rowView1;
    }
}