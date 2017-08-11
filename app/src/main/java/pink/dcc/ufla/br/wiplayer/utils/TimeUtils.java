package pink.dcc.ufla.br.wiplayer.utils;

public class TimeUtils {

    public static String formatTime(int duration) {
        int minutes = duration / 60;
        int seconds = duration % 60;

        return minutes + ":" + StringUtils.padNumber(seconds, 2);
    }
}
