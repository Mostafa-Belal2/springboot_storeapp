package net.storeapp.Supplier;

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

public class UpdateSupplier extends AppCompatActivity implements View.OnClickListener  {

    EditText username;
    Button update,delete;
    SupplierApiInterface apiInterface;
    int id =0;
    String usernameStr;
    Supplier responseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_customer);


        username = findViewById(R.id.customerName);
        update = findViewById(R.id.updateBtb);
        delete = findViewById(R.id.deleteBtb);

        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        Bundle i =getIntent().getExtras();
        id =  i.getInt("id");
        Log.i("getIdData",id+"");
        apiInterface = ApiClient.getApiClient().create(SupplierApiInterface.class);

        Call<Supplier> call = apiInterface.getSupplierById(id);

        call.enqueue(new Callback<Supplier>() {
            @Override
            public void onResponse(Call <Supplier> call, Response<Supplier> response) {

                responseData = response.body();
                username.setText(responseData.getName());
            }

            @Override
            public void onFailure(Call <Supplier> call, Throwable t) {
                Toast.makeText(UpdateSupplier.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.updateBtb:
                usernameStr = username.getText().toString().trim();

                apiInterface = ApiClient.getApiClient().create(SupplierApiInterface.class);
                Supplier supplier = new Supplier(id,usernameStr);
                Call<Supplier> passengerCall = apiInterface.updateSupplier(supplier);
                passengerCall.enqueue(new Callback<Supplier>() {
                    @Override
                    public void onResponse(Call<Supplier> call, Response<Supplier> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateSupplier.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateSupplier.this, ListSupplier.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Supplier> call, Throwable t) {
                        Toast.makeText(UpdateSupplier.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;

            case R.id.deleteBtb:
                apiInterface = ApiClient.getApiClient().create(SupplierApiInterface.class);
                Call<Supplier> Call = apiInterface.deleteSupplier(id);
                Call.enqueue(new Callback<Supplier>() {
                    @Override
                    public void onResponse(Call<Supplier> call, Response<Supplier> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateSupplier.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateSupplier.this, ListSupplier.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Supplier> call, Throwable t) {
                        Toast.makeText(UpdateSupplier.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;
        }



    }
}
