package pink.dcc.ufla.br.wiplayer.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import pink.dcc.ufla.br.wiplayer.utils.routing.IDataInjectable;
import pink.dcc.ufla.br.wiplayer.utils.routing.RouteData;
import pink.dcc.ufla.br.wiplayer.utils.routing.RouteManager;

public class RouteManagedActivity extends AppCompatActivity implements IDataInjectable {

    protected RouteManager routeManager;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void initializeRouter() {
        routeManager = new RouteManager(this);
        routeManager.listenForData(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        routeManager.listenForResults();
    }

    @Override
    public void inject(RouteData data) {

    }

}
