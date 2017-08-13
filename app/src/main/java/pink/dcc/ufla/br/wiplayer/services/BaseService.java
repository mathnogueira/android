package pink.dcc.ufla.br.wiplayer.services;

import com.github.nkzawa.socketio.client.Socket;

import pink.dcc.ufla.br.wiplayer.utils.ServerUtils;

public abstract class BaseService {

    protected Socket socket;

    public BaseService() {
        ServerUtils server = new ServerUtils();
        this.socket = server.socket;
        this.socket.connect();
    }


}
