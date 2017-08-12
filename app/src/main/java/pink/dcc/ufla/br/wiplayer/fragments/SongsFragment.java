package pink.dcc.ufla.br.wiplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.adapters.SongAdapter;
import pink.dcc.ufla.br.wiplayer.dialogs.GroupSelectionDialog;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.presenters.SongsPresenter;
import pink.dcc.ufla.br.wiplayer.utils.callbacks.OnSongSelectedListener;

public class SongsFragment extends BaseFragment {

    @BindView(R.id.list_available_songs)
    ListView songsListView;

    private SongsPresenter presenter;
    private SongAdapter adapter;
    private OnSongSelectedListener listener;

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
        routeManager.result()
                .add("song", song);

        if (listener != null) {
            listener.onSongSelected(song);
        }

//        GroupSelectionDialog dialog = new GroupSelectionDialog(getContext());
//        dialog.setOnGroupSelectedListener(group -> {
//            presenter.setPlayingSong(song, group);
//            adapter.notifyDataSetChanged();
//        });
//        dialog.show();
    }

    public void setOnSongSelectedListener(OnSongSelectedListener listener) {
        this.listener = listener;
    }

    private void setupSongList() {
        adapter = new SongAdapter(getActivity(), presenter.getSongs());
        songsListView.setAdapter(adapter);
    }
}
