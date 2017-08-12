package pink.dcc.ufla.br.wiplayer.fragments;

import android.support.v4.app.Fragment;

import pink.dcc.ufla.br.wiplayer.utils.routing.RouteManager;


public abstract class BaseFragment extends Fragment {

    protected RouteManager routeManager;

    public void setRouteManager(RouteManager routeManager) {
        this.routeManager = routeManager;
    }
}
