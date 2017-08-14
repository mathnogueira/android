package pink.dcc.ufla.br.wiplayer.models;

import android.util.Log;

import java.io.Serializable;

import pink.dcc.ufla.br.wiplayer.services.DeviceService;

public class Device implements Serializable {

    private String id;
    private String name;
    private Group group;

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Log.e("erro", this.name + name);

        DeviceService deviceService = DeviceService.getInstance();
        deviceService.renameDevice(this.id, name);
        this.name = name;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return name;
    }
}
