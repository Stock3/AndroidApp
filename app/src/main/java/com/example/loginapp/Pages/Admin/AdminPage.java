package com.example.loginapp.Pages.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.loginapp.R;

public class AdminPage extends AppCompatActivity {

    private Button reg_btn;
    private Button category_btn;
    private Button product_btn;
    private Button chat_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        registration();
        category();
        product();
        chat();
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

    public void registration(){
        reg_btn = (Button) findViewById(R.id.reg_btn);

        reg_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick (View v){
                        Intent intent = new Intent(".RegistrationPage");
                        startActivity(intent);
                    }
                }
        );
    }

    public void category(){
        category_btn = (Button) findViewById(R.id.category_btn);

        category_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(".CategoryPage");
                        startActivity(intent);
                    }
                }
        );
    }

    public void product(){
        product_btn = (Button) findViewById(R.id.product_btn);

        product_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(".ProductPage");
                        startActivity(intent);
                    }
                }
        );
    }
}
