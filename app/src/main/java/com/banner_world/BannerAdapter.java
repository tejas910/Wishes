package com.banner_world;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.BannerHolder> {

//    private ArrayList<String> list;
//    private Context context;

//    int arr[];
    int arr[];
    public Context context;


//    public BannerAdapter(ArrayList<String> list, Context context) {
//        this.list = list;
//        this.context = context;
//    }

    public BannerAdapter(int[] arr, Context context) {
        this.arr = arr;
        this.context = context;
    }

    @NonNull
    @Override
    public BannerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_image_layout,parent,false);
        return new BannerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerHolder holder, @SuppressLint("RecyclerView") int position) {
//        Glide.with(context).load(list.get(position)).into(holder.imageView);
//        holder.imageView.setImageResource(arr[position]);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,Fullimage.class);
//                intent.putExtra("image",list.get(position));
//                context.startActivity(intent);
//            }
//        });
        holder.imageView.setImageResource(arr[position]);
//        Glide.with(context).load(list.get(position)).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Fullimage.class);
                intent.putExtra("image",arr[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class BannerHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public BannerHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }

}
