package pink.dcc.ufla.br.wiplayer.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;

import pink.dcc.ufla.br.wiplayer.fragments.BaseFragment;
import pink.dcc.ufla.br.wiplayer.utils.routing.RouteManager;


public class FragmentReplacer {

    private FragmentManager manager;
    private int container;
    private SparseArray<Fragment> registeredEvents;
    private RouteManager routeManager;

    public FragmentReplacer(FragmentManager manager, int container) {
        this.manager = manager;
        this.container = container;
        registeredEvents = new SparseArray<>();
    }

    public void dispatch(int event) {
        BaseFragment fragment = (BaseFragment) registeredEvents.get(event);
        replace(fragment);
    }

    public void replaceOn(int event, BaseFragment fragment) {
        registeredEvents.put(event, fragment);
    }

    public void defaultFragment(int defaultFragment) {
        dispatch(defaultFragment);
    }

    public void setRouteManager(RouteManager routeManager) {
        this.routeManager = routeManager;
    }

    public void replace(BaseFragment fragment) {
        fragment.setRouteManager(routeManager);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }
}
