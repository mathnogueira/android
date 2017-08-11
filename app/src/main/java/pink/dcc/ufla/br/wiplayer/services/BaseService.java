package pink.dcc.ufla.br.wiplayer.services;

import com.github.nkzawa.socketio.client.Socket;

import pink.dcc.ufla.br.wiplayer.utils.ServerUtils;

public abstract class BaseService {

    protected Socket socket;

    public BaseService() {
        socket = ServerUtils.openServerSocket();
    }
}
