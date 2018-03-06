package com.example.td.testmvp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.td.testmvp.R;
import com.example.td.testmvp.impl.LoginPresentImpl;
import com.example.td.testmvp.model.Book;
import com.example.td.testmvp.present.LoginPresent;
import com.example.td.testmvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {
    LoginPresent present;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
        findViewById(R.id.button).setOnClickListener(this);
        present = new LoginPresentImpl(this);
    }
    @Override
    public void onClick(View v) {
        present.login();
    }
    @Override
    public void loginData(Book s) {
        tv.setText(s.toString());
//        Toast.makeText(this, s.toString(), Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onError(String s) {
        tv.setText(s);
//        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
