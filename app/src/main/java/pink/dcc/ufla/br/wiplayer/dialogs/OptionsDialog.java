package pink.dcc.ufla.br.wiplayer.dialogs;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.Arrays;
import java.util.List;


public class OptionsDialog extends ListDialog {

    private ArrayAdapter<String> options;

    public OptionsDialog(String title, Context context) {
        super(title, context);
    }

    public OptionsDialog setOptions(List<String> options) {
        setDialogOptions(options);
        return this;
    }

    public OptionsDialog setOptions(String[] options) {
        List<String> optionsList = Arrays.asList(options);
        setDialogOptions(optionsList);
        return this;
    }

    private void setDialogOptions(List<String> options) {
        this.options = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, options);
        setAdapter(this.options);
    }

}
