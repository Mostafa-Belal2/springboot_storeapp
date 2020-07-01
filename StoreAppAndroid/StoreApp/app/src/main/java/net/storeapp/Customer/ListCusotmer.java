package net.storeapp.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.storeapp.R;
import net.storeapp.Common.ApiClient;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCusotmer extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView cusotmerRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private CustomerRecyclerAdapter adapter;
    private List<Customer> cusotmer ;
    private Customer addCustomer ;
    private CustomerApiInterface apiInterface;
    EditText customerName;
    String customerNameStr;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_customer);

        Bundle i = getIntent().getExtras();


        cusotmerRecycler = (RecyclerView) findViewById(R.id.customerListRecycler);
        layoutManager  = new LinearLayoutManager(this);
        cusotmerRecycler.setLayoutManager(layoutManager);
        cusotmerRecycler.setHasFixedSize(true);


        apiInterface = ApiClient.getApiClient().create(CustomerApiInterface.class);


        Call <List<Customer>> call = apiInterface.getCustomer();

        call.enqueue(new Callback<List<Customer>>() {
            @Override
            public void onResponse(Call <List<Customer>> call, Response <List<Customer>> response) {

                cusotmer = response.body();
                adapter = new CustomerRecyclerAdapter(cusotmer);
                cusotmerRecycler.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <List<Customer>> call, Throwable t) {
                Toast.makeText(ListCusotmer.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        customerName = findViewById(R.id.customerName);
        addBtn = findViewById(R.id.addCustomer);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        customerNameStr = customerName.getText().toString();

        Customer customer = new Customer(customerNameStr);
        Call <Customer> call = apiInterface.addCustomer(customer);

        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call <Customer> call, Response <Customer> response) {

                addCustomer = response.body();

                Toast.makeText(ListCusotmer.this, addCustomer.getAction(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListCusotmer.this, ListCusotmer.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call <Customer> call, Throwable t) {
                Toast.makeText(ListCusotmer.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
