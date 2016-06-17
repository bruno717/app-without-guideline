package edu.bruno.applicationwithoutguideline;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by bruno.oliveira on 6/16/16.
 */
public class DialogsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_dialogs_button_progress)
    public void showProgressDialog(View v) {
        new MaterialDialog.Builder(this)
                .title("Título")
                .content("Teste do progress dialog Sesc.")
                .autoDismiss(true)
                .progress(true, 0)
                .show();
    }

    @OnClick(R.id.activity_dialogs_button_text_input)
    public void showTextInputDialog(View v) {
        new MaterialDialog.Builder(this)
                .title("Título")
                .content("Teste input text dialog.")
                .negativeText("CANCELAR")
                .cancelable(false)
                .input("teste hint", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        Toast.makeText(DialogsActivity.this, "input: " + input, Toast.LENGTH_SHORT).show();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(DialogsActivity.this, "CANCELAR", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    @OnClick(R.id.activity_dialogs_button_number_input)
    public void showNumberInputDialog(View v) {
        new MaterialDialog.Builder(this)
                .title("Título")
                .content("Teste input number dialog.")
                .negativeText("CANCELAR")
                .cancelable(false)
                .inputType(InputType.TYPE_CLASS_NUMBER)
                .input("teste hint", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        Toast.makeText(DialogsActivity.this, "input: " + input, Toast.LENGTH_SHORT).show();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(DialogsActivity.this, "CANCELAR", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    @OnClick(R.id.activity_dialogs_button_password_input)
    public void showPasswordInputDialog(View v) {
        new MaterialDialog.Builder(this)
                .title("Título")
                .content("Teste input password dialog.")
                .negativeText("CANCELAR")
                .cancelable(false)
                .inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)
                .input("teste hint", "", new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        Toast.makeText(DialogsActivity.this, "input: " + input, Toast.LENGTH_SHORT).show();
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        Toast.makeText(DialogsActivity.this, "CANCELAR", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}
