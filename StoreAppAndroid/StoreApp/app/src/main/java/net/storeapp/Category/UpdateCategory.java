package net.storeapp.Category;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.storeapp.Common.ApiClient;
import net.storeapp.R;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateCategory extends AppCompatActivity implements View.OnClickListener  {

    EditText username;
    Button update,delete;
    CategoryApiInterface apiInterface;
    int id =0;
    String usernameStr;
    Category responseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_category);


        username = findViewById(R.id.categoryName);
        update = findViewById(R.id.updateBtb);
        delete = findViewById(R.id.deleteBtb);

        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        Bundle i =getIntent().getExtras();
        id =  i.getInt("id");
        Log.i("getIdData",id+"");
        apiInterface = ApiClient.getApiClient().create(CategoryApiInterface.class);

        Call<Category> call = apiInterface.getCategoryById(id);

        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call <Category> call, Response<Category> response) {

                responseData = response.body();
                username.setText(responseData.getName());
            }

            @Override
            public void onFailure(Call <Category> call, Throwable t) {
                Toast.makeText(UpdateCategory.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.updateBtb:
                usernameStr = username.getText().toString().trim();

                apiInterface = ApiClient.getApiClient().create(CategoryApiInterface.class);
                Category category = new Category(id,usernameStr);
                Call<Category> passengerCall = apiInterface.updateCategory(category);
                passengerCall.enqueue(new Callback<Category>() {
                    @Override
                    public void onResponse(Call<Category> call, Response<Category> response) {
                        responseData = response.body();
//                        Toast.makeText(UpdateCategory.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateCategory.this, ListCategory.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Category> call, Throwable t) {
                        Toast.makeText(UpdateCategory.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;

            case R.id.deleteBtb:
                apiInterface = ApiClient.getApiClient().create(CategoryApiInterface.class);
                Call<Category> Call = apiInterface.deleteCategory(id);
                Call.enqueue(new Callback<Category>() {
                    @Override
                    public void onResponse(Call<Category> call, Response<Category> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateCategory.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateCategory.this, ListCategory.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Category> call, Throwable t) {
                        Toast.makeText(UpdateCategory.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;
        }



    }
}
