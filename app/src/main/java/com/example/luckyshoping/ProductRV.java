package com.example.luckyshoping;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luckyshoping.pojo.Product;

import java.util.List;

public class ProductRV extends RecyclerView.Adapter<ProductRV.ViewHolder> {

    final List<Product> mValues;

    public ProductRV(List<Product> mValues) {
        this.mValues = mValues;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String capacity = "Объем видеопамяти: " + mValues.get(position).getVideoCardCapacity();
        holder.tvCapacity.setText(capacity);

        String type = "Тип видеопамяти: " + mValues.get(position).getVideoMemoryType();
        holder.tvType.setText(type);

        String price = "Цена: " + mValues.get(position).getPrice();
        holder.tvPrice.setText(price);

        holder.tvTitle.setText(mValues.get(position).getVideoCardName());

        holder.im.setImageResource(R.mipmap.no_found);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvType;
        TextView tvCapacity;
        TextView tvPrice;
        TextView tvTitle;

        ImageView im;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            im = itemView.findViewById(R.id.imageView);
            tvCapacity = itemView.findViewById(R.id.tv_memory_capacity);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvType = itemView.findViewById(R.id.tv_type_video_memory);
            tvTitle = itemView.findViewById(R.id.tv_title);

        }
    }
}
