package pink.dcc.ufla.br.wiplayer.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.utils.TimeUtils;

public class SongAdapter extends BaseAdapter {

    private List<Song> songList;
    private LayoutInflater inflater;

    public SongAdapter(Activity activity, List<Song> songs) {
        songList = songs;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return songList.size();
    }

    @Override
    public Object getItem(int i) {
        return songList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Song song = songList.get(i);
        return song.isPlaying() ? getPlayingSongView(song, viewGroup) : getSongView(song, viewGroup);
    }

    private View getPlayingSongView(Song song, ViewGroup viewGroup) {
        View row = inflater.inflate(R.layout.layout_song_playing_list, viewGroup, false);
        TextView songNameContainer = (TextView) row.findViewById(R.id.song_name);
        TextView artistNameContainer = (TextView) row.findViewById(R.id.artist_name);
        songNameContainer.setText(song.getTitle());
        artistNameContainer.setText(song.getAuthor());

        return row;
    }

    private View getSongView(Song song, ViewGroup viewGroup) {
        View row = inflater.inflate(R.layout.layout_song_list, viewGroup, false);
        TextView songNameContainer = (TextView) row.findViewById(R.id.song_name);
        TextView artistNameContainer = (TextView) row.findViewById(R.id.artist_name);
        TextView songDurationContainer = (TextView) row.findViewById(R.id.song_duration);

        songNameContainer.setText(song.getTitle());
        artistNameContainer.setText(song.getAuthor());
        songDurationContainer.setText(TimeUtils.formatTime(song.getDuration()));

        return row;
    }
}
