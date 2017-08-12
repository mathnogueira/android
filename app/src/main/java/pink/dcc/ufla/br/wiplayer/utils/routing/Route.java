package pink.dcc.ufla.br.wiplayer.utils.routing;

import java.io.Serializable;

/**
 * Created by barba when 7/20/17.
 */

public class Route<T extends IDataInjectable> implements Serializable {

    private Class destination;

    public void setDestination(Class destinationActivity) {
        this.destination = destinationActivity;
    }

    public Class getDestination() {
        return destination;
    }
}
