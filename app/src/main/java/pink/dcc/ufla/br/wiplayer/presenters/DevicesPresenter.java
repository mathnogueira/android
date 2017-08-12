package pink.dcc.ufla.br.wiplayer.presenters;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;

public class DevicesPresenter {

    private List<Device> devices;

    public void loadDevices() {
        devices = new ArrayList<>();

        devices.add(new Device("Nexus 5"));
        devices.add(new Device("Moto G4"));
        devices.add(new Device("Moto Z"));

        devices.add(new Device("Sony Bravia TV"));
        devices.add(new Device("Autofalante JBL"));
    }

    public List<Device> getDevices() {
        return devices;
    }

}
