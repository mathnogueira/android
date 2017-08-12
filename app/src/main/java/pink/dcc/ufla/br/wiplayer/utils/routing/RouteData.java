package pink.dcc.ufla.br.wiplayer.utils.routing;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by barba when 7/20/17.
 */

public class RouteData implements Serializable {

    private Map<String, Object> data;

    public RouteData() {
        data = new HashMap<>();
    }

    public RouteData add(String resourceName, Object resource) {
        data.put(resourceName, resource);
        return this;
    }

    public RouteData add(String resourceName, int resource) {
        return add(resourceName, Integer.valueOf(resource));
    }

    public RouteData add(String resourceName, double resource) {
        return add(resourceName, Double.valueOf(resource));
    }

    public RouteData add(String resourceName, boolean resource) {
        return add(resourceName, Boolean.valueOf(resource));
    }

    public Object retrieve(String resourceName) {
        return data.get(resourceName);
    }

    public void replace(String resourceName, Object resource) {
        Object oldObject = data.get(resourceName);
        if (oldObject != null) {
            data.remove(oldObject);
        }

        add(resourceName, resource);
    }

    public void clear() {
        data = new HashMap<>();
    }
}
