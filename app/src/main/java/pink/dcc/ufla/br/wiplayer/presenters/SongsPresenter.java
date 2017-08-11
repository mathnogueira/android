package pink.dcc.ufla.br.wiplayer.presenters;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Song;

public class SongsPresenter {

    private List<Song> songList;
    private Song playingSong;

    public SongsPresenter() {
        songList = new ArrayList<>();
        songList.add(new Song("Afterline", "Testament", 258));
        songList.add(new Song("Hotel California", "Eagles", 217));
        songList.add(new Song("Take on me", "Ah-ha", 312));
        songList.add(new Song("Afterline", "Testament", 258));
        songList.add(new Song("Hotel California", "Eagles", 217));
        songList.add(new Song("Take on me", "Ah-ha", 312));
        songList.add(new Song("Afterline", "Testament", 258));
        songList.add(new Song("Hotel California", "Eagles", 217));
        songList.add(new Song("Take on me", "Ah-ha", 312));
        songList.add(new Song("Afterline", "Testament", 258));
        songList.add(new Song("Hotel California", "Eagles", 217));
        songList.add(new Song("Take on me", "Ah-ha", 312));
    }

    public List<Song> getSongs() {
        return songList;
    }

    public void setPlayingSong(Song song) {
        if (playingSong != null) {
            playingSong.setPlaying(false);
        }
        playingSong = song;
        playingSong.setPlaying(true);
    }

}
