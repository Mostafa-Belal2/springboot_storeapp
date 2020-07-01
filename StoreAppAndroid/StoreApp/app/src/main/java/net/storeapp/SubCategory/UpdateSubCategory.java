package net.storeapp.SubCategory;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import net.storeapp.Category.Category;
import net.storeapp.Category.CategoryApiInterface;
import net.storeapp.Common.ApiClient;
import net.storeapp.R;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateSubCategory extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    EditText username;
    Button update,delete;
    SubCategoryApiInterface apiInterface;
    CategoryApiInterface categoryApiInterface;
    int id =0;
    String usernameStr,spinnerCategoryStr;
    Spinner spinnerCategory;
    Category category;
    List<Category> listSpinnerCategory;

    SubCategory responseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_sub_category);


        loadSpinnerData();
        username = findViewById(R.id.subCategoryName);
        spinnerCategory = findViewById(R.id.spinnerSubCategory);
        update = findViewById(R.id.updateBtb);
        delete = findViewById(R.id.deleteBtb);

        spinnerCategory.setOnItemSelectedListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        Bundle i =getIntent().getExtras();
        id =  i.getInt("id");
        Log.i("getIdData",id+"");
        apiInterface = ApiClient.getApiClient().create(SubCategoryApiInterface.class);

        Call<SubCategory> call = apiInterface.getSubCategoryById(id);

        call.enqueue(new Callback<SubCategory>() {
            @Override
            public void onResponse(Call <SubCategory> call, Response<SubCategory> response) {

                responseData = response.body();
                username.setText(responseData.getName());
                for (int i=0;i<listSpinnerCategory.size();i++){
                if(responseData.getCategory().getName().equalsIgnoreCase(listSpinnerCategory.get(i).getName()))
                    spinnerCategory.setSelection(i);
                }

            }

            @Override
            public void onFailure(Call <SubCategory> call, Throwable t) {
                Toast.makeText(UpdateSubCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.updateBtb:
                usernameStr = username.getText().toString().trim();
                categoryApiInterface = ApiClient.getApiClient().create(CategoryApiInterface.class);

                Call<Category> call = categoryApiInterface.getCategoryByName(spinnerCategoryStr);

                call.enqueue(new Callback<Category>() {
                    @Override
                    public void onResponse(Call <Category> call, Response<Category> response) {

                        category = response.body();
                        apiInterface = ApiClient.getApiClient().create(SubCategoryApiInterface.class);
                        SubCategory subCategory = new SubCategory(id,usernameStr,category);
                        Call<SubCategory> passengerCall = apiInterface.updateSubCategory(subCategory);
                        passengerCall.enqueue(new Callback<SubCategory>() {
                            @Override
                            public void onResponse(Call<SubCategory> call, Response<SubCategory> response) {
                                responseData = response.body();
                                Toast.makeText(UpdateSubCategory.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(UpdateSubCategory.this, ListSubCategory.class);
                                startActivity(intent);
                            }

                            @Override
                            public void onFailure(Call<SubCategory> call, Throwable t) {
                                Toast.makeText(UpdateSubCategory.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        });

                    }

                    @Override
                    public void onFailure(Call <Category> call, Throwable t) {
                        Toast.makeText(UpdateSubCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

                break;

            case R.id.deleteBtb:
                apiInterface = ApiClient.getApiClient().create(SubCategoryApiInterface.class);
                Call<SubCategory> Call = apiInterface.deleteSubCategory(id);
                Call.enqueue(new Callback<SubCategory>() {
                    @Override
                    public void onResponse(Call<SubCategory> call, Response<SubCategory> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateSubCategory.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateSubCategory.this, ListSubCategory.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<SubCategory> call, Throwable t) {
                        Toast.makeText(UpdateSubCategory.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;
        }



    }
    private void loadSpinnerData() {
        categoryApiInterface = ApiClient.getApiClient().create(CategoryApiInterface.class);


        Call <List<Category>> call = categoryApiInterface.getCategory();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call <List<Category>> call, Response <List<Category>> response) {

                listSpinnerCategory = response.body();
                List<String> labels = new ArrayList<>();
                for(Category cat : listSpinnerCategory){
                    labels.add(cat.getName());
                }
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(UpdateSubCategory.this,android.R.layout.simple_spinner_item, labels);

                // Drop down layout style - list view with radio button
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                spinnerCategory.setAdapter(dataAdapter);
            }

            @Override
            public void onFailure(Call <List<Category>> call, Throwable t) {
                Toast.makeText(UpdateSubCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinnerCategoryStr = spinnerCategory.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
