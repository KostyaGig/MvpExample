package com.kostya.mvpsampleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kostya.mvpsampleexample.login_interface.IAuthView;
import com.kostya.mvpsampleexample.presenter.AuthPresenter;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements IAuthView {

    private ProgressDialog pd;

    private EditText edEmail,edPassword;
    private Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AuthPresenter presenter = new AuthPresenter(this);

        init();
        initProgressDialog();

        btnOk.setOnClickListener(view ->
                {
                    presenter.validateData(edEmail.getText().toString().trim(),edPassword.getText().toString().trim());
                }
                );


    }

    private void init() {

        edEmail = findViewById(R.id.ed_email);
        edPassword = findViewById(R.id.ed_password);

        btnOk = findViewById(R.id.btn_ok);
    }

    private void initProgressDialog() {

        pd = new ProgressDialog(this);
        pd.setTitle("Вход в систему");
        pd.setMessage("Загрзка,пожалуйста подождите");
        pd.setCancelable(false);
    }

    @Override
    public void showResult(String message) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void success(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failure(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress() {
        pd.show();
    }

    @Override
    public void hideProgress() {
        pd.dismiss();
    }

}