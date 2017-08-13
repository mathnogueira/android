package pink.dcc.ufla.br.wiplayer.utils.windows;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import pink.dcc.ufla.br.wiplayer.R;
import pink.dcc.ufla.br.wiplayer.utils.callbacks.OnPositionAnswerListener;

public class InputDialog {


    private final String title;
    private final Context context;
    private OnPositionAnswerListener listener;

    public InputDialog(String title, Context context) {
        this.title = title;
        this.context = context;
    }

    public InputDialog(int titleResourceId, Context context) {
        String title = context.getString(titleResourceId);
        this.title = title;
        this.context = context;
    }

    public InputDialog setPositiveAnswerListener(OnPositionAnswerListener listener) {
        this.listener = listener;
        return this;
    }

    public AlertDialog build() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setView(buildView())
                .setTitle(title)
                .setPositiveButton(R.string.label_ok, (dialog, which) -> {
                    EditText inputText = (EditText) ((Dialog) dialog).findViewById(R.id.dialog_input_text);
                    String answer = inputText.getText().toString();
                    if (!answer.isEmpty()) {
                        listener.onPositiveAnswer(answer);
                    }
                })
                .setNegativeButton(R.string.label_cancel, (dialog, which) -> {

                });

        return builder.create();
    }

    private View buildView() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.dialog_input, null);

        EditText editText = (EditText) view.findViewById(R.id.dialog_input_text);
        editText.postDelayed(() -> {
            editText.setFocusableInTouchMode(true);
            editText.requestFocus();
            ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(editText, 0);
        }, 250);

        return view;
    }

}
