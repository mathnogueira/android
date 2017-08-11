package pink.dcc.ufla.br.wiplayer.presenters;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.services.SongService;

public class SongsPresenter {

    private List<Song> songList;
    private Song playingSong;
    private SongService songService;

    public SongsPresenter() {
        songService = new SongService();
        songList = songService.getSongList();
    }

    public List<Song> getSongs() {
        return songList;
    }

    public void setPlayingSong(Song song, Device device) {
        if (playingSong != null) {
            playingSong.setPlaying(false);
        }
        playingSong = song;
        playingSong.setPlaying(true);

        songService.setPlayingSong(song, device);
    }

}
