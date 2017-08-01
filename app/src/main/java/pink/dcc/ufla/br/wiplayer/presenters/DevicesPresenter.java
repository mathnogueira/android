package pink.dcc.ufla.br.wiplayer.presenters;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;

public class DevicesPresenter {

    private List<Device> connectedDevices;
    private List<Device> waitingDevices;

    public void loadDevices() {
        connectedDevices = new ArrayList<>();
        waitingDevices = new ArrayList<>();

        connectedDevices.add(new Device("Nexus 5"));
        connectedDevices.add(new Device("Moto G4"));
        connectedDevices.add(new Device("Moto Z"));

        waitingDevices.add(new Device("Sony Bravia TV"));
        waitingDevices.add(new Device("Autofalante JBL"));
    }

    public List<Device> getConnectedDevices() {
        return connectedDevices;
    }

    public List<Device> getWaitingDevices() {
        return waitingDevices;
    }
}
