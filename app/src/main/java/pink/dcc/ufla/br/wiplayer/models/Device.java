package pink.dcc.ufla.br.wiplayer.models;

public class Device {

    private int id;
    private String name;
    private Group group;

    public Device(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
