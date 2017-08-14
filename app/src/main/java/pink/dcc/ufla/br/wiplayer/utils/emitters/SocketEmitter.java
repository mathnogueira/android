package pink.dcc.ufla.br.wiplayer.utils.emitters;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.services.BaseService;
import pink.dcc.ufla.br.wiplayer.services.DeviceService;
import pink.dcc.ufla.br.wiplayer.services.SongService;







public class SocketEmitter extends BaseService{



    public static Emitter.Listener newReceptor = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            DeviceService deviceService = DeviceService.getInstance();
            deviceService.addDevice(args[0].toString());
        }
    };


    public static Emitter.Listener allSongs = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            DeviceService deviceService = DeviceService.getInstance();
            String jsonStr = args[0].toString();
            Log.e("err", args[0].toString());
            Gson gson = new Gson();
            Song songs[] = gson.fromJson(jsonStr, Song[].class);
            SongService songService = SongService.getInstance();
            songService.setSongs(songs);
        }
    };


    public static Emitter.Listener devices = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            String jsonStr = args[0].toString();
            Log.e("Lista devices", args[0].toString());
            Gson gson = new Gson();
            Device devices[] = gson.fromJson(jsonStr, Device[].class);
            DeviceService deviceService = DeviceService.getInstance();
            deviceService.setDevices(devices);
        }
    };
}
