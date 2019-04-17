package com.example.loginapp.Pages.Admin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.loginapp.App;
import com.example.loginapp.Model.OrganizationDto;
import com.example.loginapp.Model.RegistrationFormDto;
import com.example.loginapp.Model.RoleDto;
import com.example.loginapp.Model.UserRegistrationDto;
import com.example.loginapp.R;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationPage extends AppCompatActivity {

    private Spinner organizationSpinner;
    private Spinner roleSpinner;
    private Button btnReg;
    private EditText editTextName, editTextSurname, editTextEmail;
    private List<OrganizationDto> organizationList;
    private List<RoleDto> roleList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        organizationSpinner = findViewById(R.id.spinner_organization);
        roleSpinner = findViewById(R.id.spinner_role);
        btnReg = findViewById(R.id.btnReg);
        editTextSurname = findViewById(R.id.editTextSurname);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);

        App.getRegistrationAPI().getRegistrationFormDto().enqueue(new Callback<RegistrationFormDto>() {
          @Override
          public void onResponse(Call<RegistrationFormDto> call, Response<RegistrationFormDto> response) {
              if (response != null) {

                  RegistrationFormDto form = response.body();
                  organizationList = form.getOrganizations();
                  roleList = form.getRoles();

                  List<String> org = new ArrayList<>();
                  for (OrganizationDto o:organizationList) {
                      org.add(o.getName());
                  }

                  List<String> role = new ArrayList<>();
                  for (RoleDto r:roleList) {
                      role.add(r.getName());
                  }

                  ArrayAdapter<String> adapterOrg = new ArrayAdapter<String>(RegistrationPage.this, R.layout.support_simple_spinner_dropdown_item, org);
                  adapterOrg.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                  organizationSpinner.setAdapter(adapterOrg);
                  organizationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                      @Override
                      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                          //Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                      }

                      @Override
                      public void onNothingSelected(AdapterView<?> adapterView) {
                          Toast.makeText(getBaseContext(), "Будь ласка, вкажіть свою організацію ", Toast.LENGTH_LONG).show();
                      }
                  });

                  ArrayAdapter<String> adapterRole = new ArrayAdapter<String>(RegistrationPage.this, R.layout.support_simple_spinner_dropdown_item, role);
                  adapterRole.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                  roleSpinner.setAdapter(adapterRole);
                  roleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                      @Override
                      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                          //Toast.makeText(getBaseContext(), adapterView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
                      }

                      @Override
                      public void onNothingSelected(AdapterView<?> adapterView) {
                          Toast.makeText(getBaseContext(), "Будь ласка, вкажіть свою посаду ", Toast.LENGTH_LONG).show();
                      }
                  });
              }
          }

          @Override
          public void onFailure(Call<RegistrationFormDto> call, Throwable t) {
              Toast.makeText(getApplicationContext(), "Шось пішло не так", Toast.LENGTH_LONG).show();
              System.out.println(t.getMessage());
          }
      });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString();
                String surname = editTextSurname.getText().toString();
                String email = editTextEmail.getText().toString();
                if (name.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Заповніть будь ласка ім'я", Toast.LENGTH_LONG).show();
                }
                else if (surname.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Заповніть будь ласка прізвище", Toast.LENGTH_LONG).show();
                }
                else if (email.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Заповніть будь ласка email", Toast.LENGTH_LONG).show();
                }
                else {
                    String org = organizationSpinner.getSelectedItem().toString();
                    String role = roleSpinner.getSelectedItem().toString();

                    OrganizationDto selectedOrg = null;
                    RoleDto selectedRole = null;
                    for (OrganizationDto o:organizationList) {
                        if (o.getName().equals(org)){
                            selectedOrg = o;
                        }
                    }

                    for (RoleDto r:roleList) {
                        if (r.getName().equals(role)){
                            selectedRole = r;
                        }
                    }

                    if ((selectedOrg != null) && (selectedRole != null)){
                        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
                        userRegistrationDto.setName(name);
                        userRegistrationDto.setSurname(surname);
                        userRegistrationDto.setEmail(email);
                        userRegistrationDto.setOrganizationId(selectedOrg.getId());
                        userRegistrationDto.setRoleId(selectedRole.getId());

                        /*App.getRegistrationAPI().registrationUser(userRegistrationDto).enqueue(new Callback<Response<ResponseEntity<Object>>>() {
                            @Override
                            public void onResponse(Call<Response<ResponseEntity<Object>>> call, Response<Response<ResponseEntity<Object>>> response) {
                                Toast.makeText(getApplicationContext(), "Ви успішно зареєструвались.Активуйте ваш акаунт через електронну пошту.", Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onFailure(Call<Response<ResponseEntity<Object>>> call, Throwable t) {
                                Toast.makeText(getApplicationContext(), "Ви успішно зареєструвались.Активуйте ваш акаунт через електронну пошту.", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });*/
                    }
                }
            }
        });


        /*//Тест ліст
        App.getUserAPI().getUserList().enqueue(new Callback<List<UserDto>>(){

            @Override
            public void onResponse(Call<List<UserDto>> call, Response<List<UserDto>> response) {
                if (response != null) {
                    Toast.makeText(getApplicationContext(), response.body().get(0).getEmail(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<UserDto>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Шось пішло не так", Toast.LENGTH_LONG).show();
                System.out.println(t.getMessage());
            }
        });*/



    }
}
