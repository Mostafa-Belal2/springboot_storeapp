package net.storeapp.User;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import net.storeapp.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.MyViewHolder> {

    private List<User> user;
    private String name,password,role;
    private Context context;
    String id;

    public UserRecyclerAdapter(List<User> user)
    {
        this.user = user;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user_row, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.Name.setText(user.get(position).getName());
        holder.Password.setText(user.get(position).getPassword());
        holder.Role.setText(user.get(position).getRole());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), UpdateUser.class);
                i.putExtra("id",user.get(position).getId());
                v.getContext().startActivity(i);
            }
        });
        name =user.get(position).getName();
        password =user.get(position).getPassword();
        role =user.get(position).getRole();
    }

    @Override
    public int getItemCount() {
        return user.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Password,Role;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.userName);
            Password = itemView.findViewById(R.id.userPassword);
            Role = itemView.findViewById(R.id.userRole);
        }
    }
}
