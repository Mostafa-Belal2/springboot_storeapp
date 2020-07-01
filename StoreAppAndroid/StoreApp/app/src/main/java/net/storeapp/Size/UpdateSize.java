package net.storeapp.Size;

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

public class UpdateSize extends AppCompatActivity implements View.OnClickListener  {

    EditText username;
    Button update,delete;
    SizeApiInterface apiInterface;
    int id =0;
    String usernameStr;
    Size responseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_size);


        username = findViewById(R.id.sizeName);
        update = findViewById(R.id.updateBtb);
        delete = findViewById(R.id.deleteBtb);

        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        Bundle i =getIntent().getExtras();
        id =  i.getInt("id");
        Log.i("getIdData",id+"");
        apiInterface = ApiClient.getApiClient().create(SizeApiInterface.class);

        Call<Size> call = apiInterface.getSizeById(id);

        call.enqueue(new Callback<Size>() {
            @Override
            public void onResponse(Call <Size> call, Response<Size> response) {

                responseData = response.body();
                username.setText(responseData.getName());
            }

            @Override
            public void onFailure(Call <Size> call, Throwable t) {
                Toast.makeText(UpdateSize.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.updateBtb:
                usernameStr = username.getText().toString().trim();

                apiInterface = ApiClient.getApiClient().create(SizeApiInterface.class);
                Size size = new Size(id,usernameStr);
                Call<Size> passengerCall = apiInterface.updateSize(size);
                passengerCall.enqueue(new Callback<Size>() {
                    @Override
                    public void onResponse(Call<Size> call, Response<Size> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateSize.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateSize.this, ListSize.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Size> call, Throwable t) {
                        Toast.makeText(UpdateSize.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;

            case R.id.deleteBtb:
                apiInterface = ApiClient.getApiClient().create(SizeApiInterface.class);
                Call<Size> Call = apiInterface.deleteSize(id);
                Call.enqueue(new Callback<Size>() {
                    @Override
                    public void onResponse(Call<Size> call, Response<Size> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateSize.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateSize.this, ListSize.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<Size> call, Throwable t) {
                        Toast.makeText(UpdateSize.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;
        }



    }
}
