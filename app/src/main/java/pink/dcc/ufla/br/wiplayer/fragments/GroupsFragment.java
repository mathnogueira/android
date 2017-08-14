package pink.dcc.ufla.br.wiplayer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.actions.NavigationActions;
import pink.dcc.ufla.br.wiplayer.activities.SongSelectionActivity;
import pink.dcc.ufla.br.wiplayer.adapters.GroupAdapter;
import pink.dcc.ufla.br.wiplayer.models.Group;
import pink.dcc.ufla.br.wiplayer.models.Song;
import pink.dcc.ufla.br.wiplayer.presenters.GroupsPresenter;
import pink.dcc.ufla.br.wiplayer.dialogs.InputDialog;
import pink.dcc.ufla.br.wiplayer.utils.ServerUtils;

public class GroupsFragment extends BaseFragment {

    private GroupsPresenter presenter;
    private GroupAdapter adapter;
    private Group selectedGroup;

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

        setupRouter();

        return view;
    }

    @OnClick(R.id.btn_new_group)
    public void addGroup(View view) {
        InputDialog dialog = new InputDialog(R.string.give_name_group, getActivity())
                .setPositiveAnswerListener(answer -> {
                    presenter.createGroup(answer);
                    adapter.notifyDataSetChanged();
                });

        dialog.build().show();
    }

    @OnItemClick(R.id.device_group_list)
    public void onGroupSelected(int position) {
        selectedGroup = presenter.getGroups().get(position);
        routeManager.get(NavigationActions.SELECT_SONG_FOR_GROUP)
                .inject("group", selectedGroup);

        routeManager.dispatch(NavigationActions.SELECT_SONG_FOR_GROUP);
    }

    private void setupRouter() {
        routeManager.navigateTo(SongSelectionActivity.class)
                .when(NavigationActions.SELECT_SONG_FOR_GROUP)
                .then(data -> {
                    Song song = (Song) data.retrieve("song");
                    presenter.playSongOn(song, selectedGroup);
                    selectedGroup = null;
                    adapter.notifyDataSetChanged();
                });
    }


    @OnClick(R.id.volume_down)
    public void volumeDown() {
        ServerUtils.socket.emit("volumeDown");
    }

    @OnClick(R.id.volume_mute)
    public void volumeMute() {
        ServerUtils.socket.emit("mute");
    }

    @OnClick(R.id.volume_up)
    public void volumeUp() {
        ServerUtils.socket.emit("volumeUp");
    }
}
