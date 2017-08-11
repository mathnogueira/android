package pink.dcc.ufla.br.wiplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import pink.dcc.ufla.br.wiplayer.dialogs.DeviceSelectionDialog;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.presenters.SongsPresenter;
import pink.dcc.ufla.br.wiplayer.services.SongService;

public class SongsFragment extends Fragment {

    @BindView(R.id.list_available_songs)
    ListView songsListView;

    private SongsPresenter presenter;
    private SongAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containers, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_songs, containers, false);

        presenter = new SongsPresenter();

        ButterKnife.bind(this, view);

        setupSongList();

        return view;
    }

    @OnItemClick(R.id.list_available_songs)
    public void selectSong(int position) {
        Song song = presenter.getSongs().get(position);
        DeviceSelectionDialog dialog = new DeviceSelectionDialog(getContext());
        dialog.setOnDeviceSelectedListener(device -> {
            presenter.setPlayingSong(song, device);
            adapter.notifyDataSetChanged();
        });
        dialog.show();
//        presenter.setPlayingSong(song);
//        adapter.notifyDataSetChanged();
    }

    private void setupSongList() {
        adapter = new SongAdapter(getActivity(), presenter.getSongs());
        songsListView.setAdapter(adapter);
    }
}
