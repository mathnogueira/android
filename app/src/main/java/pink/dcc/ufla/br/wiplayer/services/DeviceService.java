package pink.dcc.ufla.br.wiplayer.services;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;

public class DeviceService extends BaseService {

    public List<Device> listDevices() {
        return null;
    }

    public List<Device> listActiveDevices() {
        List<Device> activeDevices = new ArrayList<>();
        activeDevices.add(new Device("Sony Bravia 72\""));
        activeDevices.add(new Device("Nexus 5"));
        activeDevices.add(new Device("Moto G4"));
        activeDevices.add(new Device("Autofalante JBL"));
        activeDevices.add(new Device("Moto Z"));

        return activeDevices;
    }
    
    private static DeviceService instance;
    
    private DeviceService() {}
    
    public static DeviceService getInstance() {
        if (instance == null) {
            instance = new DeviceService();
        }
        return instance;
    }
}
