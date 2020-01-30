package com.example.zadanie3auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import javax.xml.transform.Templates;
//drugi panel
public class AfterLoginActivity extends AppCompatActivity {

    TextView textView;
    String username;
    String isadmin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        textView = findViewById(R.id.afterTv);
        username = getIntent().getStringExtra("username");
        isadmin = getIntent().getStringExtra("isadmin");


        textView.setText(isadmin + ": " + username);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
}
