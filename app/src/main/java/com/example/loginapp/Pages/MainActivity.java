package com.example.loginapp.Pages;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.loginapp.App;
import com.example.loginapp.Model.AuthenticationTokenDto;
import com.example.loginapp.Model.MessageResponseDto;
import com.example.loginapp.Model.UserAuthorizationDto;
import com.example.loginapp.Pages.Admin.RegistrationPage;
import com.example.loginapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Button btn;
    private EditText EmailEditText, PassEditText;

    private static final String emailAdmin = "admin@gmail.com";
    private static final String passAdmin = "admin";

    /*
    private static final String email_txt_u = "user@gmail.com";
    private static final String pass_txt_u = "user";*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        EmailEditText = findViewById(R.id.edtEmail);
        PassEditText = findViewById(R.id.edtPass);

        btn.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*if(email_txt_a.equals(String.valueOf(email.getText())) &&  pass_txt_a.equals(String.valueOf(pass.getText()))){
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
                        pass.setText("");*/

                    String email = EmailEditText.getText().toString();
                    String pass = PassEditText.getText().toString();
                    if (email.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Заповніть будь ласка email", Toast.LENGTH_LONG).show();
                    }
                    else if (pass.isEmpty()){
                        Toast.makeText(getApplicationContext(), "Будь ласка введіть пароль", Toast.LENGTH_LONG).show();
                    }
                    else if (emailAdmin.equals(String.valueOf(EmailEditText.getText())) &&  passAdmin.equals(String.valueOf(PassEditText.getText()))){
                            Intent intent = new Intent(".AdminPage");
                            startActivity(intent);
                    } else {
                        UserAuthorizationDto loginDto = new UserAuthorizationDto();
                        loginDto.setEmail(email);
                        loginDto.setPassword(pass);

                        App.getUserAPI().loginUser(loginDto).enqueue(new Callback<AuthenticationTokenDto>() {
                            @Override
                            public void onResponse(Call<AuthenticationTokenDto> call, Response<AuthenticationTokenDto> response) {
                                AuthenticationTokenDto mesResponse = response.body();
                                if (mesResponse != null){
                                    Toast.makeText(MainActivity.this, "Ви успішно авторизовані", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(".UserPage");
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "onResponce, but body is null", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<AuthenticationTokenDto> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "Щось пішло не так", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            }
        );
    }

}
