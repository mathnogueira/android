package pink.dcc.ufla.br.wiplayer.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.adapters.DeviceAdapter;
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.services.DeviceService;


public class DeviceSelectionDialog extends Dialog {

    private ListView devicesListView;
    private DeviceAdapter deviceAdapter;
    private List<Device> activeDevices;
    private OnDeviceSelectedListener deviceSelectedListener;
    private DeviceService service;

    public DeviceSelectionDialog(@NonNull Context context) {
        super(context);

        service = new DeviceService();

        activeDevices = service.listActiveDevices();


        deviceAdapter = new DeviceAdapter(context, activeDevices);
    }

    public void setOnDeviceSelectedListener(OnDeviceSelectedListener listener) {
        deviceSelectedListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_device_selection_dialog);

        devicesListView = (ListView) findViewById(R.id.active_players_list);
        devicesListView.setAdapter(deviceAdapter);

        devicesListView.setOnItemClickListener((adapterView, view, i, l) -> {
            Device selectedDevice = activeDevices.get(i);
            dismiss();
            if (deviceSelectedListener != null) {
                deviceSelectedListener.onDeviceSelected(selectedDevice);
            }
        });
    }
}
