package pink.dcc.ufla.br.wiplayer.presenters;

import android.util.Log;

import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.services.GroupService;

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
        group.setCurrentPlayingSong(song);
    }
}
