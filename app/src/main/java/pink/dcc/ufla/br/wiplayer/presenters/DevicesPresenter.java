package pink.dcc.ufla.br.wiplayer.presenters;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;

public class DevicesPresenter {

    private List<Device> connectedDevices;
    private List<Device> waitingDevices;
    private List<Device> unnamedDevices;

    public void loadDevices() {
        connectedDevices = new ArrayList<>();
        waitingDevices = new ArrayList<>();
        unnamedDevices = new ArrayList<>();

        connectedDevices.add(new Device("Nexus 5"));
        connectedDevices.add(new Device("Moto G4"));
        connectedDevices.add(new Device("Moto Z"));

        unnamedDevices.add(new Device("Sony Bravia TV"));
        unnamedDevices.add(new Device("Autofalante JBL"));
    }

    public List<Device> getConnectedDevices() {
        return connectedDevices;
    }

    public List<Device> getWaitingDevices() {
        return waitingDevices;
    }

    public List<Device> getUnnamedDevices() {
        return unnamedDevices;
    }

    public void renameDevice(Device deviceToRename, String newName) {
        deviceToRename.setName(newName);
        unnamedDevices.remove(deviceToRename);
        waitingDevices.add(deviceToRename);
    }

    public void addDeviceToGroup(Device device, Group group) {
        group.addDevice(device);
        device.setGroup(group);

        waitingDevices.remove(device);
        connectedDevices.add(device);
    }
}
