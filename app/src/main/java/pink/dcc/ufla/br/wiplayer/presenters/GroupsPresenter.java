package pink.dcc.ufla.br.wiplayer.presenters;

import android.util.Log;

import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.services.GroupService;

public class GroupsPresenter {

    private GroupService service;

    public GroupsPresenter() {
        service = new GroupService();
    }

    public List<Group> listGroups() {
        Log.e("LIST", "listGroups");
        return service.listGroups();
    }

    public void createGroup(String groupName) {
        Group group = new Group(groupName);
        service.addGroup(group);
    }
}
