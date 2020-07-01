package net.storeapp.Category;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.storeapp.Common.ApiClient;
import net.storeapp.R;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCategory extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView categoryRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private CategoryRecyclerAdapter adapter;
    private List<Category> category ;
    private Category addCategory ;
    private CategoryApiInterface apiInterface;
    EditText categoryName;
    String categoryNameStr;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_category);

        Bundle i = getIntent().getExtras();


        categoryRecycler = (RecyclerView) findViewById(R.id.categoryListRecycler);
        layoutManager  = new LinearLayoutManager(this);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryRecycler.setHasFixedSize(true);


        apiInterface = ApiClient.getApiClient().create(CategoryApiInterface.class);


        Call <List<Category>> call = apiInterface.getCategory();

        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call <List<Category>> call, Response <List<Category>> response) {

                category = response.body();
                adapter = new CategoryRecyclerAdapter(category);
                categoryRecycler.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <List<Category>> call, Throwable t) {
                Toast.makeText(ListCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        categoryName = findViewById(R.id.categoryName);
        addBtn = findViewById(R.id.addCategory);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        categoryNameStr = categoryName.getText().toString();
        Category category = new Category(categoryNameStr);
        Call <Category> call = apiInterface.addCategory(category);

        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call <Category> call, Response <Category> response) {

                addCategory = response.body();

                Toast.makeText(ListCategory.this, addCategory.getAction(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListCategory.this, ListCategory.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call <Category> call, Throwable t) {
                Toast.makeText(ListCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
