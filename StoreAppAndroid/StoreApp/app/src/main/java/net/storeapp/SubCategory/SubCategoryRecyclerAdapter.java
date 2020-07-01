package net.storeapp.SubCategory;


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


public class SubCategoryRecyclerAdapter extends RecyclerView.Adapter<SubCategoryRecyclerAdapter.MyViewHolder> {

    private List<SubCategory> subCategory;
    private String name,category;
    private Context context;
    String id;

    public SubCategoryRecyclerAdapter(List<SubCategory> subCategory)
    {
        this.subCategory = subCategory;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_sub_category_row, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.Name.setText(subCategory.get(position).getName());
        holder.Category.setText(subCategory.get(position).getCategory().getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), UpdateSubCategory.class);
                i.putExtra("id",subCategory.get(position).getId());
                v.getContext().startActivity(i);
            }
        });
        name =subCategory.get(position).getName();
    }

    @Override
    public int getItemCount() {
        return subCategory.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Name,Category;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.subCategoryRowName);
            Category = itemView.findViewById(R.id.subCategoryRowCategory);
        }
    }
}
