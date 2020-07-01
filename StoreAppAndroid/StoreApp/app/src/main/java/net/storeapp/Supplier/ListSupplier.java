package net.storeapp.Supplier;

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

public class ListSupplier extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView supplierRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private SupplierRecyclerAdapter adapter;
    private List<Supplier> supplier ;
    private Supplier addSupplier ;
    private SupplierApiInterface apiInterface;
    EditText supplierName;
    String supplierNameStr;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_supplier);

        Bundle i = getIntent().getExtras();


        supplierRecycler = (RecyclerView) findViewById(R.id.supplierListRecycler);
        layoutManager  = new LinearLayoutManager(this);
        supplierRecycler.setLayoutManager(layoutManager);
        supplierRecycler.setHasFixedSize(true);


        apiInterface = ApiClient.getApiClient().create(SupplierApiInterface.class);


        Call <List<Supplier>> call = apiInterface.getSupplier();

        call.enqueue(new Callback<List<Supplier>>() {
            @Override
            public void onResponse(Call <List<Supplier>> call, Response <List<Supplier>> response) {

                supplier = response.body();
                adapter = new SupplierRecyclerAdapter(supplier);
                supplierRecycler.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <List<Supplier>> call, Throwable t) {
                Toast.makeText(ListSupplier.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        supplierName = findViewById(R.id.supplierName);
        addBtn = findViewById(R.id.addSupplier);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        supplierNameStr = supplierName.getText().toString();
        Supplier supplier = new Supplier(supplierNameStr);
        Call <Supplier> call = apiInterface.addSupplier(supplier);

        call.enqueue(new Callback<Supplier>() {
            @Override
            public void onResponse(Call <Supplier> call, Response <Supplier> response) {

                addSupplier = response.body();

                Toast.makeText(ListSupplier.this, addSupplier.getAction(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListSupplier.this, ListSupplier.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call <Supplier> call, Throwable t) {
                Toast.makeText(ListSupplier.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
