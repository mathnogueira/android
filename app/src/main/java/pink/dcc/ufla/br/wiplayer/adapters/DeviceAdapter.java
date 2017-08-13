package pink.dcc.ufla.br.wiplayer.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.utils.windows.InputDialog;

public class DeviceAdapter extends BaseAdapter {

    private List<Device> devices;
    private LayoutInflater inflater;
    private Context context;

    public DeviceAdapter(Context context, List<Device> devices) {
        this.devices = devices;
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public Object getItem(int position) {
        return devices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row =  inflater.inflate(R.layout.layout_device_list, null);

        TextView deviceNameTextView = (TextView) row.findViewById(R.id.device_name);
        TextView deviceGroupTextView = (TextView) row.findViewById(R.id.device_group_name);
        ImageButton renameButton = (ImageButton) row.findViewById(R.id.rename_device_btn);

        Device device = devices.get(position);
        deviceNameTextView.setText(device.getName());
        if (device.getGroup() != null) {
            deviceGroupTextView.setText(device.getGroup().getName());
        }

        renameButton.setOnClickListener(v -> {
            InputDialog dialog = new InputDialog("Rename the device", context)
                    .setPositiveAnswerListener(device::setName);

            dialog.build().show();
        });

        return row;
    }
}
