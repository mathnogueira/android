package pink.dcc.ufla.br.wiplayer.presenters;

import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.services.DeviceService;

public class DevicesPresenter {

    private List<Device> devices;
    private DeviceService service;

    public DevicesPresenter() {
        service = DeviceService.getInstance();
    }

    public void loadDevices() {
        devices = service.getDevices();
    }

    public List<Device> getDevices() {
        return devices;
    }

}
