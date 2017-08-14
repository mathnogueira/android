package pink.dcc.ufla.br.wiplayer.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.utils.callbacks.OnItemSelectedListener;

public class ListDialog {

    protected Context context;
    private String title;
    private OnItemSelectedListener listener;
    private BaseAdapter adapter;
    private AlertDialog dialog;

    public ListDialog(String title, Context context) {
        this.title = title;
        this.context = context;
    }

    public ListDialog(int titleStringResource, Context context) {
        this.title = context.getString(titleStringResource);
        this.context = context;
    }

    public ListDialog setOnItemSelectedListener(OnItemSelectedListener listener) {
        this.listener = listener;
        return this;
    }

    public ListDialog setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
        return this;
    }

    public AlertDialog build() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(buildView())
                .setTitle(title);

        dialog = builder.create();
        return dialog;
    }

    private View buildView() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.dialog_list, null);

        ListView listView = (ListView) view.findViewById(R.id.dialog_list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            if (listener != null) {
                listener.onItemSelected(position);
            }
            dialog.dismiss();
        });

        return view;
    }

}
