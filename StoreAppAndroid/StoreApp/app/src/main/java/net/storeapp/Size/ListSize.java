package net.storeapp.Size;

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

public class ListSize extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView sizeRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private SizeRecyclerAdapter adapter;
    private List<Size> size ;
    private Size addSize ;
    private SizeApiInterface apiInterface;
    EditText sizeName;
    String sizeNameStr;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_size);

        Bundle i = getIntent().getExtras();


        sizeRecycler = (RecyclerView) findViewById(R.id.sizeListRecycler);
        layoutManager  = new LinearLayoutManager(this);
        sizeRecycler.setLayoutManager(layoutManager);
        sizeRecycler.setHasFixedSize(true);


        apiInterface = ApiClient.getApiClient().create(SizeApiInterface.class);


        Call <List<Size>> call = apiInterface.getSize();

        call.enqueue(new Callback<List<Size>>() {
            @Override
            public void onResponse(Call <List<Size>> call, Response <List<Size>> response) {

                size = response.body();
                adapter = new SizeRecyclerAdapter(size);
                sizeRecycler.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <List<Size>> call, Throwable t) {
                Toast.makeText(ListSize.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        sizeName = findViewById(R.id.sizeName);
        addBtn = findViewById(R.id.addSize);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        sizeNameStr = sizeName.getText().toString();
        Size size = new Size(sizeNameStr);
        Call <Size> call = apiInterface.addSize(size);

        call.enqueue(new Callback<Size>() {
            @Override
            public void onResponse(Call <Size> call, Response <Size> response) {

                addSize = response.body();

                Toast.makeText(ListSize.this, addSize.getAction(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListSize.this, ListSize.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call <Size> call, Throwable t) {
                Toast.makeText(ListSize.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
