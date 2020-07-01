package net.storeapp.User;

import android.os.Bundle;
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

public class ListUser extends AppCompatActivity {

    private RecyclerView userRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private UserRecyclerAdapter adapter;
    private List<User> user ;
    private UserApiInterface apiInterface;
    int companyId,supervisorId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        Bundle i = getIntent().getExtras();


        userRecycler = (RecyclerView) findViewById(R.id.userListRecycler);
        layoutManager  = new LinearLayoutManager(this);
        userRecycler.setLayoutManager(layoutManager);
        userRecycler.setHasFixedSize(true);


        apiInterface = ApiClient.getApiClient().create(UserApiInterface.class);


        Call <List<User>> call = apiInterface.getUser();

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call <List<User>> call, Response <List<User>> response) {

                user = response.body();
                adapter = new UserRecyclerAdapter(user);
                userRecycler.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <List<User>> call, Throwable t) {
                Toast.makeText(ListUser.this,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
