package net.storeapp.User;

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

import net.storeapp.R;
import net.storeapp.Common.ApiClient;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener ,View.OnClickListener  {

    EditText username,password;
    Spinner role;
    int roleIndex;
    Button update,delete;
    UserApiInterface apiInterface;
    int id =0;
    String usernameStr,passwordStr,roleStr;
    User responseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerRole);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passowrdLogin);
        role = findViewById(R.id.spinnerRole);
        update = findViewById(R.id.updateBtb);
        delete = findViewById(R.id.deleteBtb);

        role.setOnItemSelectedListener(this);
        update.setOnClickListener(this);
        delete.setOnClickListener(this);

        Bundle i =getIntent().getExtras();
        id =  i.getInt("id");
        Log.i("getIdData",id+"");
        apiInterface = ApiClient.getApiClient().create(UserApiInterface.class);

        Call<User> call = apiInterface.getUserById(id);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call <User> call, Response<User> response) {

                responseData = response.body();
                username.setText(responseData.getName());
                password.setText(responseData.getPassword());
                if(responseData.getRole().equalsIgnoreCase("Admin"))
                {
                    roleIndex = 0;
                }
                else{
                    roleIndex = 1;
                }
                role.setSelection(roleIndex);

            }

            @Override
            public void onFailure(Call <User> call, Throwable t) {
                Toast.makeText(UpdateUser.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            roleStr = role.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        roleStr = "User";
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.updateBtb:
                usernameStr = username.getText().toString().trim();
                passwordStr = password.getText().toString();

                apiInterface = ApiClient.getApiClient().create(UserApiInterface.class);
                User user = new User(id,usernameStr,passwordStr,roleStr);
                Call<User> passengerCall = apiInterface.updateUser(user);
                passengerCall.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateUser.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateUser.this, ListUser.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(UpdateUser.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;

            case R.id.deleteBtb:
                apiInterface = ApiClient.getApiClient().create(UserApiInterface.class);
                Call<User> Call = apiInterface.deleteUser(id);
                Call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        responseData = response.body();
                        Toast.makeText(UpdateUser.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateUser.this, ListUser.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(UpdateUser.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                });
                break;
        }



    }
}
