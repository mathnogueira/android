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
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.adapters.DeviceAdapter;
import pink.dcc.ufla.br.wiplayer.dialogs.GroupSelectionDialog;
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.presenters.DevicesPresenter;
import pink.dcc.ufla.br.wiplayer.utils.windows.InputDialog;

public class DevicesFragment extends BaseFragment {

    @BindView(R.id.device_list)
    public ListView deviceListView;

    private DeviceAdapter adapter;
    private DevicesPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containers, Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_devices, containers, false);

        ButterKnife.bind(this, view);

        startupFragment();

        return view;
    }

    private void startupFragment() {
        presenter = new DevicesPresenter();
        presenter.loadDevices();
        adapter = new DeviceAdapter(getContext(), presenter.getDevices());

        deviceListView.setAdapter(adapter);
    }

    @OnItemClick(R.id.device_list)
    public void onDeviceSelected(int position) {
        Device device = presenter.getDevices().get(position);
        GroupSelectionDialog dialog = new GroupSelectionDialog(getContext());

        dialog.setOnGroupSelectedListener(group -> {
            presenter.addDeviceToGroup(device, group);
            adapter.notifyDataSetChanged();
        });

        dialog.show();
    }



}
