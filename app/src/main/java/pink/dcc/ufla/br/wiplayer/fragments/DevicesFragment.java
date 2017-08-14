package pink.dcc.ufla.br.wiplayer.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;

import org.json.JSONObject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemLongClick;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.adapters.DeviceAdapter;
import pink.dcc.ufla.br.wiplayer.dialogs.GroupSelectionDialog;
import pink.dcc.ufla.br.wiplayer.dialogs.InputDialog;
import pink.dcc.ufla.br.wiplayer.dialogs.OptionsDialog;
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.presenters.DevicesPresenter;
import pink.dcc.ufla.br.wiplayer.dialogs.ListDialog;
import pink.dcc.ufla.br.wiplayer.services.DeviceService;
import pink.dcc.ufla.br.wiplayer.utils.ServerUtils;

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

    @OnItemLongClick(R.id.device_list)
    public boolean onDeviceLongPress(int position) {
        final Device selectedDevice = presenter.getDevices().get(position);
        OptionsDialog dialog = new OptionsDialog("Device", getContext());
        dialog.setOptions(new String[] {"Rename device", "Set group"});
        dialog.setOnItemSelectedListener(selectedOptionPosition -> {
            switch (selectedOptionPosition) {
                case 0: renameDevice(selectedDevice); break;
                case 1: onDeviceSelected(position); break;
            }
        });

        dialog.build().show();


        return true;
    }

    private void renameDevice(Device device) {
        InputDialog dialog = new InputDialog("Rename the device", getContext())
                .setPositiveAnswerListener(device::setName)
                .setDefaultValue(device.getName());



        dialog.build().show();



    }



}
