package pink.dcc.ufla.br.wiplayer.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.services.GroupService;
import pink.dcc.ufla.br.wiplayer.utils.callbacks.OnGroupSelectedListener;


public class GroupSelectionDialog extends Dialog {

    private ArrayAdapter<Group> groupAdapter;
    private OnGroupSelectedListener groupSelectedListener;
    private List<Group> availableGroups;
    private GroupService service;

    public GroupSelectionDialog(@NonNull Context context) {
        super(context);

        service = GroupService.getInstance();
        availableGroups = service.listGroups();

        groupAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, service.listGroups());
    }

    public void setOnGroupSelectedListener(OnGroupSelectedListener listener) {
        groupSelectedListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.layout_device_selection_dialog);

        ListView devicesListView = (ListView) findViewById(R.id.active_players_list);
        devicesListView.setAdapter(groupAdapter);

        devicesListView.setOnItemClickListener((adapterView, view, i, l) -> {
            Group selectedGroup = availableGroups.get(i);
            dismiss();
            if (groupSelectedListener != null) {
                groupSelectedListener.onGroupSelected(selectedGroup);
            }
        });
    }
}
