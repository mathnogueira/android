package pink.dcc.ufla.br.wiplayer.services;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.utils.ServerUtils;

public class DeviceService extends BaseService {

    private List<Device> devices;

    public List<Device> getDevices() {
        return devices;
    }
    
    private static DeviceService instance;

    private DeviceService() {  }

    public void setDevices (Device devices[]) {
        this.devices = new ArrayList<>();
        for (int i = 0 ; i < devices.length; i ++) {
            this.devices.add(devices[i]);
        }

    }


    public void addDevice(String id) {
        Gson gson = new Gson();

        Device newDevice = new Device(id,id);
        devices.add(newDevice);
        String json = gson.toJson(newDevice);
        try {
            JSONObject data = new JSONObject(json);
            socket.emit("registerReceptor", data);
        }catch (Throwable tx) {
            Log.e("My App", "Could not parse malformed JSON:");
        }
    }


    public void renameDevice (String id, String name) {
        Device device = new Device(id, name);
        Gson gson = new Gson();
        String json = gson.toJson(device);
        try {
            JSONObject data = new JSONObject(json);
            socket.emit("renameReceptor", data);
        }catch (Throwable tx) {
            Log.e("My App", "Could not parse malformed JSON:");
        }
    }

    public void renameDevice(Device device) {
        Gson gson = new Gson();
        String json = gson.toJson(device);
        try {
            JSONObject data = new JSONObject(json);
            socket.emit("renameReceptor", data);
        }catch (Throwable tx) {
            Log.e("My App", "Could not parse malformed JSON:");
        }
    }

    public static DeviceService getInstance() {
        if (instance == null) {
            instance = new DeviceService();
        }
        return instance;
    }

    public void addDeviceToGroup(Device device, Group group) {
        device.setGroup(group);
        group.addDevice(device);
    }
}
