package pink.dcc.ufla.br.wiplayer.services;

import com.github.nkzawa.socketio.client.Socket;

import pink.dcc.ufla.br.wiplayer.models.Song;

public class SongService {

    private Socket socket;

    public SongService(Socket socket) {
        this.socket = socket;
    }

    public void setPlayingSong(Song song) {
        socket.emit("song", song);
    }
}
