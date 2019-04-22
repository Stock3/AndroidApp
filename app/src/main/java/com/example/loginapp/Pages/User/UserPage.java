package com.example.loginapp.Pages.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loginapp.R;

public class UserPage extends AppCompatActivity {

    private Button chat_btn;
    private Button maps_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
        chat();
        maps();
    }

    private void maps() {
        maps_btn = (Button) findViewById(R.id.maps_btn);
        maps_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".MapsActivity");
                startActivity(intent);
            }
        });
    }

    private void chat() {
        chat_btn = (Button) findViewById(R.id.chat_btn);
        chat_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(".ChatPage");
                startActivity(intent);
            }
        });
    }
}
