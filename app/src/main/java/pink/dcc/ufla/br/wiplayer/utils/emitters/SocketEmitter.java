package pink.dcc.ufla.br.wiplayer.utils.emitters;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.services.DeviceService;
import pink.dcc.ufla.br.wiplayer.services.SongService;

/**
 * Created by rafael on 13/08/17.
 */



public class SocketEmitter {



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
            List<Song> songsList = new ArrayList<>();
            /*for (int i = 0 ; i < songs.length; i++) {
                Log.e("err", songs[i].getAuthor());
                songsList.add(songs[i]);
                songsList.get(i).getTitle();
            }*/

            SongService songService = SongService.getInstance();
            songService.setSongs(songs);
        }
    };


    public static Emitter.Listener playSong = new Emitter.Listener() {
        @Override
        public void call(Object... args) {

        }
    };
}
