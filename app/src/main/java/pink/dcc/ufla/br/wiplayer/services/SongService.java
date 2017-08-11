package pink.dcc.ufla.br.wiplayer.services;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Song;

public class SongService extends BaseService {

    public void setPlayingSong(Song song, Device device) {
        Log.e("SONG", "Playing " + song.getName() + " on " + device.getName());
        socket.emit("song", song);
    }

    public List<Song> getSongList() {
        List<Song> songs = new ArrayList<>();

        songs.add(new Song("Californication", "Red Hot Chilli Peppers", 329));
        songs.add(new Song("What I've Done", "Linkin Park", 205));
        songs.add(new Song("One", "Metallica", 447));
        songs.add(new Song("I'm Broken", "Pantera", 265));
        songs.add(new Song("Psychosocial", "Slipknot", 283));
        songs.add(new Song("Livin 'On A Prayer", "Bon Jovi", 250));
        songs.add(new Song("Temptation", "Slayer", 205));

        return songs;
    }
}
