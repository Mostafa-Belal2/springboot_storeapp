package net.storeapp.Customer;


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


public class CustomerRecyclerAdapter extends RecyclerView.Adapter<CustomerRecyclerAdapter.MyViewHolder> {

    private List<Customer> cusotmer;
    private String name;
    private Context context;
    String id;

    public CustomerRecyclerAdapter(List<Customer> cusotmer)
    {
        this.cusotmer = cusotmer;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_customer_row, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.Name.setText(cusotmer.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), UpdateCustomer.class);
                i.putExtra("id",cusotmer.get(position).getId());
                v.getContext().startActivity(i);
            }
        });
        name =cusotmer.get(position).getName();
    }

    @Override
    public int getItemCount() {
        return cusotmer.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Password,Role;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.customerRowName);
        }
    }
}
