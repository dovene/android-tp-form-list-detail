package com.dov.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private AppCompatEditText loginET;
    private AppCompatEditText emailET;
    private AppCompatButton loginButton;
    private AppCompatButton registerButton;
    public static String LOGIN_KEY = "LOGIN_KEY";
    public static String PASS_KEY = "PASS_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViewItems();
    }

    private void setViewItems() {
        loginET = findViewById(R.id.login_ET);
        emailET = findViewById(R.id.mail_ET);
        loginButton = findViewById(R.id.login_BT);
        registerButton = findViewById(R.id.register_BT);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayUserList();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User.getUsers().add(new User(loginET.getText().toString(), emailET.getText().toString() ));
                startProfileActivity();
            }
        });
    }

    private void startProfileActivity() {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        intent.putExtra(LOGIN_KEY, loginET.getText().toString());
        intent.putExtra(PASS_KEY, emailET.getText().toString());
        startActivity(intent);
    }

    private void displayUserList() {
        Intent intent = new Intent(MainActivity.this, UsersActivity.class);
        startActivity(intent);
    }

}