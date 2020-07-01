package net.storeapp.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.storeapp.R;
import net.storeapp.Common.ApiClient;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateCustomer extends AppCompatActivity implements View.OnClickListener  {

    EditText username;
    Button update,delete;
    CustomerApiInterface apiInterface;
    int id =0;
    String usernameStr;
    Customer responseData;
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
        apiInterface = ApiClient.getApiClient().create(CustomerApiInterface.class);

        Call<Customer> call = apiInterface.getCustomerById(id);

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call <Customer> call, Response<Customer> response) {

                responseData = response.body();
                username.setText(responseData.getName());
            }

            @Override
            public void onFailure(Call <Customer> call, Throwable t) {
                Toast.makeText(UpdateCustomer.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.updateBtb:
                usernameStr = username.getText().toString().trim();

                apiInterface = ApiClient.getApiClient().create(CustomerApiInterface.class);
                Customer customer = new Customer(id,usernameStr);
                Call<Customer> passengerCall = apiInterface.updateCustomer(customer);
                passengerCall.enqueue(new Callback<Customer>() {
                    @Override
                    public void onResponse(Call<Customer> call, Response<Customer> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateCustomer.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateCustomer.this, ListCusotmer.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Customer> call, Throwable t) {
                        Toast.makeText(UpdateCustomer.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;

            case R.id.deleteBtb:
                apiInterface = ApiClient.getApiClient().create(CustomerApiInterface.class);
                Call<Customer> Call = apiInterface.deleteCustomer(id);
                Call.enqueue(new Callback<Customer>() {
                    @Override
                    public void onResponse(Call<Customer> call, Response<Customer> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateCustomer.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateCustomer.this, ListCusotmer.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Customer> call, Throwable t) {
                        Toast.makeText(UpdateCustomer.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;
        }



    }
}
