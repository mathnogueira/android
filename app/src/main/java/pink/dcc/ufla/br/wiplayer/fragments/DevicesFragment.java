package pink.dcc.ufla.br.wiplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.presenters.DevicesPresenter;
import pink.dcc.ufla.br.wiplayer.utils.windows.InputDialog;

public class DevicesFragment extends Fragment {

    @BindView(R.id.list_connected_devices)
    ListView connectedDevicesView;

    @BindView(R.id.list_waiting_devices)
    ListView waitingDevicesView;

    @BindView(R.id.list_unnamed_devices)
    ListView unnamedDevicesView;

    @BindView(R.id.connected_devices_title)
    TextView connectedDevicesTitleView;

    @BindView(R.id.waiting_devices_title)
    TextView waitingDevicesTitleView;

    @BindView(R.id.unnamed_devices_title)
    TextView unnamedDevicesTitleView;

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
        List<Device> unnamedDevices = presenter.getUnnamedDevices();

        ArrayAdapter<Device> connectedDevicesAdapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, connectedDevices);
        ArrayAdapter<Device> waitingDevicesAdapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, waitingDevices);
        ArrayAdapter<Device> unnamedDevicesAdapter =
                new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, unnamedDevices);

        connectedDevicesView.setAdapter(connectedDevicesAdapter);
        waitingDevicesView.setAdapter(waitingDevicesAdapter);
        unnamedDevicesView.setAdapter(unnamedDevicesAdapter);

        hideIfNoElements(connectedDevicesTitleView, connectedDevices);
        hideIfNoElements(waitingDevicesTitleView, waitingDevices);
        hideIfNoElements(unnamedDevicesTitleView, unnamedDevices);

    }

    @OnItemClick(R.id.list_unnamed_devices)
    public void onClickUnnamedDevice(AdapterView<?> parent, int position) {
        InputDialog dialog = new InputDialog("Give a name to the device", getActivity())
                .setPositiveAnswerListener(answer -> {
                    Device deviceToRename = presenter.getUnnamedDevices().get(position);
                    presenter.renameDevice(deviceToRename, answer);

                    updateListView();
                });

        dialog.build().show();

    }

    @OnItemClick(R.id.list_waiting_devices)
    public void onClickWaitingDevice(AdapterView<?> parent, int position) {
        Device device = presenter.getWaitingDevices().get(position);
        Group group = new Group("Sertanejo do porão");
        presenter.addDeviceToGroup(device, group);

        updateListView();
    }

    private void hideIfNoElements(View viewToHide, List container) {
        if (container.size() == 0) {
            viewToHide.setVisibility(View.GONE);
        } else {
            viewToHide.setVisibility(View.VISIBLE);
        }
    }

}
