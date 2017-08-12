package pink.dcc.ufla.br.wiplayer.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.models.Song;

public class GroupAdapter extends BaseAdapter {

    private List<Group> groups;
    private LayoutInflater inflater;

    public GroupAdapter(Context context, List<Group> groups) {
        this.groups = groups;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return groups.size();
    }

    @Override
    public Object getItem(int position) {
        return groups.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = inflater.inflate(R.layout.layout_group_list, null);

        TextView groupNameTextView = (TextView) row.findViewById(R.id.group_name_textview);
        TextView currentSongTextView = (TextView) row.findViewById(R.id.current_song_textview);
        TextView numberDevicesTextView = (TextView) row.findViewById(R.id.number_devices_textview);

        Group group = groups.get(position);

        Song currentSong = group.getCurrentPlayingSong();
        groupNameTextView.setText(group.getName());
        if (currentSong != null) {
            currentSongTextView.setText(String.format("Playing %s by %s", currentSong.getName(), currentSong.getAuthor()));
        } else {
            currentSongTextView.setText(R.string.idle_message);
        }
        numberDevicesTextView.setText(String.format("%d devices", group.getDevices().size()));

        return row;
    }
}
