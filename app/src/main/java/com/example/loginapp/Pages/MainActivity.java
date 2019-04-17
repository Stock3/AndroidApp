package com.example.loginapp.Pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.loginapp.R;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button btn;
    private EditText email, pass;

    private static final String email_txt_a = "admin@gmail.com";
    private static final String pass_txt_a = "admin";

    private static final String email_txt_u = "user@gmail.com";
    private static final String pass_txt_u = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login ();
    }

    public void login (){
        btn = (Button) findViewById(R.id.button);
        email = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);

        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(email_txt_a.equals(String.valueOf(email.getText())) &&  pass_txt_a.equals(String.valueOf(pass.getText()))){
                            Intent intent = new Intent(".AdminPage");
                            startActivity(intent);
                        }
                        else if(email_txt_u.equals(String.valueOf(email.getText())) &&  pass_txt_u.equals(String.valueOf(pass.getText()))){
                            Intent intent = new Intent(".UserPage");
                            startActivity(intent);
                        }
                        else
                            Toast.makeText(
                                    MainActivity.this, "Не вірно введений логін або пароль",
                                    Toast.LENGTH_LONG
                            ).show();
                            email.setText("");
                            pass.setText("");
                    }
                }
        );

    }
}
