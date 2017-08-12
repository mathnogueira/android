package pink.dcc.ufla.br.wiplayer.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.Toast;

import java.util.Random;

import pink.dcc.ufla.br.wiplayer.R;

/**
 * Created by barba on 8/12/17.
 */

public class MusicPlayerReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Random random = new Random();
        int randomNumber = random.nextInt(300) + 300;
        Handler handler = new Handler();
        
        handler.postDelayed(() -> {
            MediaPlayer mediaPlayer = MediaPlayer.create(context, R.raw.splash);
            mediaPlayer.start();
        }, randomNumber * 1000);
    }
}
