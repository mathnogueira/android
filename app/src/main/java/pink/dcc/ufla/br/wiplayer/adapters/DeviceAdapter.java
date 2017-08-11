package pink.dcc.ufla.br.wiplayer.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.List;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.models.Device;

public class DeviceAdapter extends ArrayAdapter<Device> {

    private List<Device> devices;
    private LayoutInflater inflater;

    public DeviceAdapter(Context context, List<Device> devices) {
        super(context, android.R.layout.simple_list_item_1, devices);
        this.devices = devices;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

//    @Override
//    public int getCount() {
//        return devices.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return devices.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        View row = inflater.inflate(R.layout.layout_device_list, null);
//
//        return row;
//    }
}
