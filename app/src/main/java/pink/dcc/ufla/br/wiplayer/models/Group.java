package pink.dcc.ufla.br.wiplayer.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {

    private String name;
    private List<Device> devices;
    private Song currentPlayingSong;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song getCurrentPlayingSong() {
        return currentPlayingSong;
    }

    public void setCurrentPlayingSong(Song currentPlayingSong) {
        this.currentPlayingSong = currentPlayingSong;
    }

    @Override
    public String toString() {
        return name;
    }
}
