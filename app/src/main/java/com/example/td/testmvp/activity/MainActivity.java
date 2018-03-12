package com.example.td.testmvp.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.td.testmvp.R;
import com.example.td.testmvp.impl.BookPresentImpl;
import com.example.td.testmvp.model.Book;
import com.example.td.testmvp.present.BookPresent;
import com.example.td.testmvp.view.BookView;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements BookView {
    BookPresent present;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        present = new BookPresentImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
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

    @OnClick(R.id.button)
    public void onViewClicked() {
        present.login();
    }
}
