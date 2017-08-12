package pink.dcc.ufla.br.wiplayer.services;

import java.util.ArrayList;
import java.util.List;

import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.models.Song;

public class GroupService extends BaseService {

    private List<Group> fakeGroups;

    public GroupService() {
        fakeGroups = new ArrayList<>();

        Song song = new Song("Altar of Sacrifice", "Slayer", 216);

        Group group = new Group("Rock");
        group.setCurrentPlayingSong(song);

        Group group2 = new Group("Metal");
        group2.setCurrentPlayingSong(song);

        Group group3 = new Group("Folk");
        group3.setCurrentPlayingSong(song);

        Group group4 = new Group("Sertanejo");
        group4.setCurrentPlayingSong(song);

        Group group5 = new Group("Funk");
        group5.setCurrentPlayingSong(song);

        fakeGroups.add(group);
        fakeGroups.add(group2);
        fakeGroups.add(group3);
        fakeGroups.add(group4);
        fakeGroups.add(group5);
    }

    public List<Group> listGroups() {
        return fakeGroups;
    }

    public void addGroup(Group group) {
        fakeGroups.add(group);
    }

}
