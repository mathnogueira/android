package pink.dcc.ufla.br.wiplayer.utils.routing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RouteManager {

    private List<RouteContext> routes;
    private Context context;
    private RouteContext activeRoute;
    private DataTransferService dataTransferService;

    private static final String SHARED_DATA_ENTRY_NAME = "$RouteManager$.RouteData";

    public RouteManager(Context context) {
        this.context = context;
        routes = new ArrayList<>();
        dataTransferService = DataTransferService.getInstance();
    }

    public void listenForData(Activity activity, IDataInjectable listener) {
        Intent intent = activity.getIntent();
        listenAndInjectBundle(intent, listener);
    }

    public void listenForData(Activity activity) {
        Intent intent = activity.getIntent();
        IDataInjectable listener = (IDataInjectable) activity;
        listenAndInjectBundle(intent, listener);
    }

    public RouteContext navigateTo(Class destination) {
        RouteContext route = new RouteContext(destination);
        routes.add(route);
        return route;
    }

    public RouteData result() {
        if (activeRoute == null) {
            Log.e("RouteManager", "No active route to return a result");
            return new RouteData();
        }

        dataTransferService.setData(activeRoute.getCallbackData());
        return activeRoute.getCallbackData();
    }

    public void dispatch(int event) {
        dispatch(event, null, null);
    }

    public void listenForResults() {
        RouteData data = dataTransferService.getData();

        if (activeRoute != null && data != null) {
            DataReceiver callback = activeRoute.getCallback();
            if (callback != null) {
                callback.onDataReceive(data);
                activeRoute = null; // Dados já foram consumidos
                data.clear();
            }
        }
    }

    public RouteContext get(int eventId) {
        return findRouteByEventId(eventId);
    }

    private void dispatch(int event, String resourceName, Object resource) {
        RouteContext routeToExecute = findRouteByEventId(event);
        if (routeToExecute == null) return;

        RouteData routeData = routeToExecute.getData();
        if (resourceName != null && resource != null) {
            routeData.replace(resourceName, resource);
        }
        executeRoute(routeToExecute);
    }

    private RouteContext findRouteByEventId(int eventId) {
        for (RouteContext route : routes) {
            if (route.getEventId() == eventId) {
                return route;
            }
        }
        return null;
    }

    private void executeRoute(RouteContext route) {
        activeRoute = route;
        Intent intent = new Intent(context, route.getDestination());
        intent.putExtra(SHARED_DATA_ENTRY_NAME, route.getData());
            context.startActivity(intent);
    }

    private void listenAndInjectBundle(Intent intent, IDataInjectable listener) {
        Bundle bundle = intent.getExtras();
        Serializable bundleContent = bundle != null ? bundle.getSerializable(SHARED_DATA_ENTRY_NAME) : null;

        if (bundleContent != null) {
            RouteContext context = new RouteContext(null);
            RouteData routeData = (RouteData) bundleContent;
            context.setData(routeData);
            activeRoute = context;
            listener.inject(context.getData());
        }
    }

}
