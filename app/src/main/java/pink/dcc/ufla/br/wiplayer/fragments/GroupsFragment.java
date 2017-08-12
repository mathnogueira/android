package pink.dcc.ufla.br.wiplayer.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.adapters.GroupAdapter;
import pink.dcc.ufla.br.wiplayer.models.Device;
import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.presenters.GroupsPresenter;
import pink.dcc.ufla.br.wiplayer.utils.windows.InputDialog;

public class GroupsFragment extends Fragment {

    private GroupsPresenter presenter;
    private GroupAdapter adapter;

    @BindView(R.id.device_group_list)
    ListView groupsListView;

    public GroupsFragment() {
        presenter = new GroupsPresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groups, container, false);

        ButterKnife.bind(this, view);

        adapter = new GroupAdapter(getContext(), presenter.listGroups());
        groupsListView.setAdapter(adapter);

        return view;
    }

    @OnClick(R.id.btn_new_group)
    public void addGroup(View view) {
        InputDialog dialog = new InputDialog("Give a name to the group", getActivity())
                .setPositiveAnswerListener(answer -> {
                    presenter.createGroup(answer);
                    adapter.notifyDataSetChanged();
                });

        dialog.build().show();
    }

}
