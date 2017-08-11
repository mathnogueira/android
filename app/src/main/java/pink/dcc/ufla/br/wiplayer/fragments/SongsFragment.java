package pink.dcc.ufla.br.wiplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.adapters.SongAdapter;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.presenters.SongsPresenter;

public class SongsFragment extends Fragment {

    @BindView(R.id.list_available_songs)
    ListView songsListView;

    private List<Song> songList;
    private Song playingSong;
    private SongsPresenter presenter;
    private SongAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containers, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_songs, containers, false);

        presenter = new SongsPresenter();

        ButterKnife.bind(this, view);
        songList = presenter.getSongs();

        setupSongList();

        return view;
    }

    @OnItemClick(R.id.list_available_songs)
    public void selectSong(int position) {
        if (playingSong != null) {
            playingSong.setPlaying(false);
        }
        playingSong = songList.get(position);
        playingSong.setPlaying(true);
        adapter.notifyDataSetChanged();
    }

    private void setupSongList() {
        adapter = new SongAdapter(getActivity(), songList);
        songsListView.setAdapter(adapter);
    }
}
