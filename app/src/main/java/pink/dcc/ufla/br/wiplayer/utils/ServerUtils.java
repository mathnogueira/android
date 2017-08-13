package pink.dcc.ufla.br.wiplayer.utils;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class ServerUtils {

    public static Socket socket;

    public ServerUtils() {
        try {
            Socket socket = IO.socket("http://192.168.0.104:3500");
            this.socket = socket;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
