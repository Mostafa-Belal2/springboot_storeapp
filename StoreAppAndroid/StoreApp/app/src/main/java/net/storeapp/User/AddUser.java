package net.storeapp.User;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import net.storeapp.R;
import net.storeapp.Common.ApiClient;

public class AddUser extends AppCompatActivity implements AdapterView.OnItemSelectedListener , View.OnClickListener {

    EditText username,password;
    Spinner role;
    Button login;
    UserApiInterface apiInterface;

    String usernameStr,passwordStr,roleStr;
    User responseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerRole);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.role_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        username = findViewById(R.id.usernameLogin);
        password = findViewById(R.id.passowrdLogin);
        role = findViewById(R.id.spinnerRole);
        login = findViewById(R.id.loginBtb);

        role.setOnItemSelectedListener(this);
        login.setOnClickListener(this);

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

        usernameStr = username.getText().toString().trim();
        passwordStr = password.getText().toString();

        apiInterface = ApiClient.getApiClient().create(UserApiInterface.class);
        User user = new User(usernameStr,passwordStr,roleStr);
        Call<User> passengerCall = apiInterface.addUser(user);
        passengerCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                responseData = response.body();
                Toast.makeText(AddUser.this, responseData.getAction(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddUser.this, ListUser.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(AddUser.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });



    }
}
