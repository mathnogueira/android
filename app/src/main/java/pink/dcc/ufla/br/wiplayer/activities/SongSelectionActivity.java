package pink.dcc.ufla.br.wiplayer.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.fragments.SongsFragment;
import pink.dcc.ufla.br.wiplayer.utils.FragmentReplacer;
import pink.dcc.ufla.br.wiplayer.utils.RouteManagedActivity;

public class SongSelectionActivity extends RouteManagedActivity {

    private SongsFragment songsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_selection);

        initializeRouter();

        songsFragment = new SongsFragment();
        songsFragment.setOnSongSelectedListener(song -> finish());
        setupFragment();
    }

    private void setupFragment() {
        FragmentReplacer fragmentReplacer = new FragmentReplacer(getSupportFragmentManager(), R.id.song_selection_fragment_placement);
        fragmentReplacer.setRouteManager(routeManager);
        fragmentReplacer.replace(songsFragment);
    }
}
