package pink.dcc.ufla.br.wiplayer.utils.routing;

import java.io.Serializable;

/**
 * Created by barba when 7/20/17.
 */

public class RouteContext implements Serializable {

    private Class destination;
    private RouteData data;
    private DataReceiver callback;
    private int eventId;
    private RouteData callbackData;

    public RouteContext(Class destination) {
        this.destination = destination;
        data = new RouteData();
        callbackData = new RouteData();
    }

    public RouteContext inject(String name, Object resource) {
        data.add(name, resource);
        return this;
    }

    public RouteContext when(int eventId) {
        this.eventId = eventId;
        return this;
    }

    public RouteContext then(DataReceiver callback) {
        this.callback = callback;
        return this;
    }

    public RouteContext addResult(String name, Object resource) {
        callbackData.add(name, resource);
        return this;
    }

    public RouteData getData() {
        return data;
    }

    public DataReceiver getCallback() {
        return callback;
    }

    public int getEventId() {
        return eventId;
    }

    public RouteData getCallbackData() {
        return callbackData;
    }

    public Class getDestination() {
        return destination;
    }

    public void setData(RouteData data) {
        this.data = data;
    }
}
