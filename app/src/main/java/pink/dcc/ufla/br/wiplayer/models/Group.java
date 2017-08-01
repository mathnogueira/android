package pink.dcc.ufla.br.wiplayer.models;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private String name;
    private List<Device> devices;

    public Group(String groupName) {
        name = groupName;
        devices = new ArrayList<>();
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice(Device device) {
        devices.add(device);
    }
}
