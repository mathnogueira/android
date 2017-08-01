package pink.dcc.ufla.br.wiplayer.utils.windows;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.utils.OnPositionAnswerListener;

public class InputDialog {


    private final String title;
    private final Activity activity;
    private OnPositionAnswerListener listener;

    public InputDialog(String title, Activity activity) {
        this.title = title;
        this.activity = activity;
    }

    public InputDialog setPositiveAnswerListener(OnPositionAnswerListener listener) {
        this.listener = listener;
        return this;
    }

    public AlertDialog build() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(buildView())
                .setPositiveButton("OK", (dialog, which) -> {
                    EditText inputText = (EditText) ((Dialog) dialog).findViewById(R.id.dialog_input_text);
                    String answer = inputText.getText().toString();
                    if (!answer.isEmpty()) {
                        listener.onPositiveAnswer(answer);
                    }
                })
                .setNegativeButton("NO", (dialog, which) -> {

                });

        return builder.create();
    }

    private View buildView() {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.dialog_input, null);
        return view;
    }

}
