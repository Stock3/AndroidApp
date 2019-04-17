package com.example.loginapp.Pages.Admin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


import com.example.loginapp.App;
import com.example.loginapp.Model.CategoryDto;
import com.example.loginapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryPage extends AppCompatActivity {

    private Button btnAddCategory;
    private Button btnGetCategoryList;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_page);

        btnAddCategory = (Button) findViewById(R.id.btnAddCategory);
        btnGetCategoryList = (Button) findViewById(R.id.btnGetCategoryList);
        listView = (ListView) findViewById(R.id.listView);

        btnAddCategory.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick (View v){
                        Intent intent = new Intent(".CategoryPageCRUD");
                        startActivity(intent);
                    }
                }
        );

        App.getCategoryAPI().getCategoryList().enqueue(new Callback<List<CategoryDto>>() {

            @Override
            public void onResponse(Call<List<CategoryDto>> call, Response<List<CategoryDto>> response) {
                if (response != null) {
                    /*List<CategoryDto> listCat = response.body();

                    List<String> cat = new ArrayList<>();
                    for (CategoryDto o:listCat) {
                        cat.add(o.getName());
                    }

                    ArrayAdapter<String> adapterCat = new ArrayAdapter<String>(CategoryPage.this, android.R.layout.simple_list_item_2, cat);
                    listView.setAdapter(adapterCat);*/

                    Toast.makeText(getApplicationContext(), response.body().get(0).getName(), Toast.LENGTH_LONG).show();
                }
            }


            @Override
            public void onFailure(Call<List<CategoryDto>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Шось пішло не так", Toast.LENGTH_LONG).show();
                System.out.println(t.getMessage());
            }
        });
    }
}
