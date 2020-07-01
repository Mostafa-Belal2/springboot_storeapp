package net.storeapp.User;

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
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText userNameLogin,passwordLogin;
    Button loginBtn;
    String username,password;
    boolean matched = false;
    int index = 0;
    UserApiInterface apiInterface;
    List<User> login;
    int supervisorIndex=0,passengerIndex=0,relativeIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameLogin = findViewById(R.id.usernameLogin);
        passwordLogin = findViewById(R.id.passowrdLogin);
        loginBtn = findViewById(R.id.loginBtb);

        loginBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        username = userNameLogin.getText().toString().trim();
        password = passwordLogin.getText().toString();

        apiInterface = ApiClient.getApiClient().create(UserApiInterface.class);

        Call<List<User>> passengerCall = apiInterface.getUser();
        passengerCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

                login = response.body();
                for (int i = 0; i < login.size(); i++) {
                        if (username.equalsIgnoreCase(login.get(i).getName())) {
                                if (password.equals(login.get(i).getPassword())) {
                                    matched = true;
                                    index = i;
                                    break;
                                }

                            }
                    }
                if (matched){
                    Intent intent = new Intent(Login.this, ListUser.class);
                    intent.putExtra("userName", login.get(index).getName());
                    intent.putExtra("password", login.get(index).getPassword());
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                Toast.makeText(Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    protected void onRestart() {
        super.onRestart();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
