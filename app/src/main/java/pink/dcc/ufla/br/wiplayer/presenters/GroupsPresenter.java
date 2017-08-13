package pink.dcc.ufla.br.wiplayer.presenters;

import android.util.Log;

import org.json.JSONObject;

import java.io.StringReader;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.services.GroupService;
import pink.dcc.ufla.br.wiplayer.utils.ServerUtils;


public class GroupsPresenter {

    private GroupService service;
    private List<Group> groups;

    public GroupsPresenter() {
        service = GroupService.getInstance();
    }

    public List<Group> getGroups() {
        if (groups == null) {
            groups = service.listGroups();
        }
        return groups;
    }

    public List<Group> listGroups() {
        Log.e("LIST", "listGroups");
        return service.listGroups();
    }

    public void createGroup(String groupName) {
        Group group = new Group(groupName);
        service.addGroup(group);
    }

    public void playSongOn(Song song, Group group) {
        List<Device> devices =  group.getDevices();
        String devicesID = "receptors: [";
        group.setCurrentPlayingSong(song);
       for (int i = 0; i < devices.size(); i++) {
            devicesID = devicesID + "'"+devices.get(i).getId()+"'";
           if (i != devices.size() - 1)
            devicesID = devicesID + ",";
        }
        devicesID = devicesID + "]";

        String jsonToParse =  "{ musicID: "+ song.getId() + ", " +
                devicesID + ", junctions: [] }";
        try {
            JSONObject data = new JSONObject(jsonToParse);
            ServerUtils.socket.emit("playOnClick", data);
        }catch (Throwable tx) {
            Log.e("My App", "Could not parse malformed JSON:");
        }
    }
}
