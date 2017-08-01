package pink.dcc.ufla.br.wiplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import butterknife.OnLongClick;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.presenters.DevicesPresenter;

public class DevicesFragment extends Fragment {

    @BindView(R.id.list_connected_devices)
    ListView connectedDevicesView;

    @BindView(R.id.list_waiting_devices)
    ListView waitingDevicesView;

    private DevicesPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containers, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_devices, containers, false);

        ButterKnife.bind(this, view);

        startupFragment();

        return view;
    }

    private void startupFragment() {
        connectedDevicesView.setLongClickable(true);
        waitingDevicesView.setLongClickable(true);

        presenter = new DevicesPresenter();
        presenter.loadDevices();
        updateListView();
    }

    private void updateListView() {
        // Popula as listas
        List<Device> connectedDevices = presenter.getConnectedDevices();
        List<Device> waitingDevices = presenter.getWaitingDevices();

        ArrayAdapter<Device> connectedDevicesAdapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, connectedDevices);
        ArrayAdapter<Device> waitingDevicesAdapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, waitingDevices);

        connectedDevicesView.setAdapter(connectedDevicesAdapter);
        waitingDevicesView.setAdapter(waitingDevicesAdapter);
    }

    @OnItemLongClick(R.id.list_waiting_devices)
    public boolean openWaitingDevicePopupMenu(View view) {
        return false;
    }

    @OnItemLongClick(R.id.list_connected_devices)
    public boolean openConnectedDevicePopupMenu(View view) {
        Log.e("hehe", "haha");
        return false;
    }

}
