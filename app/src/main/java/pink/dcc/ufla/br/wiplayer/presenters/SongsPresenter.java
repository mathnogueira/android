package pink.dcc.ufla.br.wiplayer.presenters;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Song;

public class SongsPresenter {

    public List<Song> getSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song("Afterline", "Testament", 258));
        songs.add(new Song("Hotel California", "Eagles", 217));
        songs.add(new Song("Take on me", "Ah-ha", 312));
        songs.add(new Song("Afterline", "Testament", 258));
        songs.add(new Song("Hotel California", "Eagles", 217));
        songs.add(new Song("Take on me", "Ah-ha", 312));
        songs.add(new Song("Afterline", "Testament", 258));
        songs.add(new Song("Hotel California", "Eagles", 217));
        songs.add(new Song("Take on me", "Ah-ha", 312));
        songs.add(new Song("Afterline", "Testament", 258));
        songs.add(new Song("Hotel California", "Eagles", 217));
        songs.add(new Song("Take on me", "Ah-ha", 312));
        
        return songs;
    }

}
