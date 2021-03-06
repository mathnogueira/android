package pink.dcc.ufla.br.wiplayer.services;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Group;

public class GroupService extends BaseService {

    private List<Group> fakeGroups;

    public List<Group> listGroups() {
        return fakeGroups;
    }

    public void addGroup(Group group) {
        fakeGroups.add(group);
    }

    private static GroupService instance;

    private GroupService() {
        fakeGroups = new ArrayList<>();

        Group group = new Group("Rock");
        Group group4 = new Group("Sertanejo");
        Group group5 = new Group("Funk");

        fakeGroups.add(group);
        fakeGroups.add(group4);
        fakeGroups.add(group5);
    }

    public static GroupService getInstance() {
        if (instance == null) {
            instance = new GroupService();
        }
        return instance;
    }

}
