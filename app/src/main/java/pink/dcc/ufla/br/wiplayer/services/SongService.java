package pink.dcc.ufla.br.wiplayer.services;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.utils.emitters.SocketEmitter;

public class SongService extends BaseService {

    private List<Song> songs;

    public void setPlayingSong(Song song, Group group) {
        Log.e("SONG", "Playing " + song.getTitle() + " on " + group.getName());
        socket.emit("mute");
    }

    public List<Song> getSongList() {
        return this.songs;
    }




    public void setSongs(Song songs[]) {
        this.songs = new ArrayList<>();
        for (int i = 0; i < songs.length; i++) {
            this.songs.add(songs[i]);
            this.songs.get(i).getAuthor();
        }
    }


    private static SongService instance;
    
    private SongService() {}
    
    public static SongService getInstance() {
        if (instance == null) {
            instance = new SongService();
        }
        return instance;
    }
}
