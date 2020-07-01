package net.storeapp.SubCategory;

import android.content.Intent;
import android.os.Bundle;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSubCategory extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener {

    private RecyclerView subCategoryRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private SubCategoryRecyclerAdapter adapter;
    private List<SubCategory> subCategory ;
    private List<Category> category ;
    private SubCategory addsubCategory ;
    private Category singleCategory ;
    private SubCategoryApiInterface apiInterface;
    private CategoryApiInterface categoryApiInterface;
    EditText subCategoryName;
    Spinner spinnerCategory;
    String spinnerCategoryStr;
    String subCategoryNameStr;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sub_category);

        Bundle i = getIntent().getExtras();


        subCategoryRecycler = (RecyclerView) findViewById(R.id.subCategoryListRecycler);
        layoutManager  = new LinearLayoutManager(this);
        subCategoryRecycler.setLayoutManager(layoutManager);
        subCategoryRecycler.setHasFixedSize(true);


        apiInterface = ApiClient.getApiClient().create(SubCategoryApiInterface.class);


        Call <List<SubCategory>> call = apiInterface.getSubCategory();

        call.enqueue(new Callback<List<SubCategory>>() {
            @Override
            public void onResponse(Call <List<SubCategory>> call, Response <List<SubCategory>> response) {

                subCategory = response.body();
                adapter = new SubCategoryRecyclerAdapter(subCategory);
                subCategoryRecycler.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <List<SubCategory>> call, Throwable t) {
                Toast.makeText(ListSubCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        loadSpinnerData();
        subCategoryName = findViewById(R.id.subCategoryName);
        addBtn = findViewById(R.id.addSubCategory);
        spinnerCategory = findViewById(R.id.spinnerSubCategory);
        spinnerCategory.setOnItemSelectedListener(this);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        subCategoryNameStr = subCategoryName.getText().toString();
        categoryApiInterface = ApiClient.getApiClient().create(CategoryApiInterface.class);

        Call <Category> categoryCall = categoryApiInterface.getCategoryByName(spinnerCategoryStr);

        categoryCall.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call <Category> call, Response <Category> response) {

                singleCategory = response.body();
                SubCategory subCategory = new SubCategory(subCategoryNameStr,singleCategory);
                Call <SubCategory> subCategoryCall = apiInterface.addSubCategory(subCategory);

                subCategoryCall.enqueue(new Callback<SubCategory>() {
                    @Override
                    public void onResponse(Call <SubCategory> call, Response <SubCategory> response) {

                        addsubCategory = response.body();

                        Toast.makeText(ListSubCategory.this, addsubCategory.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ListSubCategory.this, ListSubCategory.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call <SubCategory> call, Throwable t) {
                        Toast.makeText(ListSubCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onFailure(Call <Category> call, Throwable t) {
                Toast.makeText(ListSubCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }

    private void loadSpinnerData() {
        categoryApiInterface = ApiClient.getApiClient().create(CategoryApiInterface.class);


        Call <List<Category>> call = categoryApiInterface.getCategory();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call <List<Category>> call, Response <List<Category>> response) {

                category = response.body();
                List<String> labels = new ArrayList<>();
                for(Category cat : category){
                    labels.add(cat.getName());
                }
                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(ListSubCategory.this,android.R.layout.simple_spinner_item, labels);

                // Drop down layout style - list view with radio button
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                spinnerCategory.setAdapter(dataAdapter);
            }

            @Override
            public void onFailure(Call <List<Category>> call, Throwable t) {
                Toast.makeText(ListSubCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
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
