package pink.dcc.ufla.br.wiplayer.services;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;

public class DeviceService extends BaseService {

    private List<Device> devices;

    public List<Device> getDevices() {
        return devices;
    }
    
    private static DeviceService instance;

    private DeviceService() {
        devices = new ArrayList<>();
        devices.add(new Device("Sony Bravia 72\""));
        devices.add(new Device("Nexus 5"));
        devices.add(new Device("Moto G4"));
        devices.add(new Device("Autofalante JBL"));
        devices.add(new Device("Moto Z"));
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
