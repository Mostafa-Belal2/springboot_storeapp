package net.storeapp.Supplier;


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


public class SupplierRecyclerAdapter extends RecyclerView.Adapter<SupplierRecyclerAdapter.MyViewHolder> {

    private List<Supplier> cusotmer;
    private String name;
    private Context context;
    String id;

    public SupplierRecyclerAdapter(List<Supplier> cusotmer)
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
                Intent i = new Intent(v.getContext(), UpdateSupplier.class);
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
