package pink.dcc.ufla.br.wiplayer.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;


public class FragmentReplacer {

    private FragmentManager manager;
    private int container;
    private SparseArray<Fragment> registeredEvents;

    public FragmentReplacer(FragmentManager manager, int container) {
        this.manager = manager;
        this.container = container;
        registeredEvents = new SparseArray<>();
    }

    public void dispatch(int event) {
        Fragment fragment = registeredEvents.get(event);
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(container, fragment);
        transaction.commit();
    }

    public void replaceOn(int event, Fragment fragment) {
        registeredEvents.put(event, fragment);
    }

    public void defaultFragment(int defaultFragment) {
        dispatch(defaultFragment);
    }
}
