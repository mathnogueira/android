package pink.dcc.ufla.br.wiplayer.utils.routing;

import java.io.Serializable;

/**
 * Created by barba when 7/20/17.
 */

public interface DataReceiver extends Serializable {

    void onDataReceive(RouteData data);

}
