package pink.dcc.ufla.br.wiplayer.utils;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class ServerUtils {

    public static Socket openServerSocket() {
        try {
            Socket socket = IO.socket("http://localhost/");
            socket.connect();

            return socket;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
