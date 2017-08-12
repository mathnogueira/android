package pink.dcc.ufla.br.wiplayer.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import pink.dcc.ufla.br.wiplayer.actions.NavigationActions;
import pink.dcc.ufla.br.wiplayer.fragments.DevicesFragment;
import pink.dcc.ufla.br.wiplayer.fragments.GroupsFragment;
import pink.dcc.ufla.br.wiplayer.fragments.HomeFragment;
import pink.dcc.ufla.br.wiplayer.fragments.SongsFragment;
import pink.dcc.ufla.br.wiplayer.utils.FragmentReplacer;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.utils.RouteManagedActivity;

public class MainActivity extends RouteManagedActivity {

    private FragmentReplacer fragmentReplacer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        initializeRouter();
        configureReplacer();
    }

    private void configureReplacer() {
        fragmentReplacer = new FragmentReplacer(getSupportFragmentManager(), R.id.fragment_content);
        fragmentReplacer.setRouteManager(routeManager);

        fragmentReplacer.replaceOn(NavigationActions.NAVIGATE_HOME, new HomeFragment());
        fragmentReplacer.replaceOn(NavigationActions.NAVIGATE_MUSIC, new SongsFragment());
        fragmentReplacer.replaceOn(NavigationActions.NAVIGATE_DEVICES, new DevicesFragment());
        fragmentReplacer.replaceOn(NavigationActions.NAVIGATE_GROUPS, new GroupsFragment());

        fragmentReplacer.defaultFragment(NavigationActions.NAVIGATE_GROUPS);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int action = 0;
            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    action = NavigationActions.NAVIGATE_HOME;
//                    break;
                case R.id.navigation_music:
                    action = NavigationActions.NAVIGATE_MUSIC;
                    break;
                case R.id.navigation_devices:
                    action = NavigationActions.NAVIGATE_DEVICES;
                    break;
                case R.id.navigation_groups:
                    action = NavigationActions.NAVIGATE_GROUPS;
                    break;
            }

            fragmentReplacer.dispatch(action);
            return true;
        }

    };

    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        return true;
    }

}
