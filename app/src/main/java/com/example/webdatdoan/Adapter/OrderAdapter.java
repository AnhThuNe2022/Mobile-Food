package com.example.webdatdoan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webdatdoan.Domain.Orderdetail;
import com.example.webdatdoan.R;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    ArrayList<Orderdetail> orderdetail;
    Context context;

    public OrderAdapter(ArrayList<Orderdetail> orderDomains, Context context) {
        this.orderdetail = orderDomains;
        this.context = context;
    }

    public OrderAdapter(ArrayList<Orderdetail> orderdetail ) {
        this.orderdetail = orderdetail;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View OrderView = inflater.inflate(R.layout.viewholder_order, parent, false);

        ViewHolder viewHolder = new ViewHolder(OrderView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
    holder.FoodName.setText(orderdetail.get(position).getTenMonAn());
    holder.price.setText( String.valueOf(orderdetail.get(position).getDonGia()));
    holder.sl.setText(String.valueOf(orderdetail.get(position).getSoLuong()));
    holder.image.setImageResource(orderdetail.get(position).getAnh());

    }

    @Override
    public int getItemCount() {
        return orderdetail.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView FoodName;
        TextView price;
        TextView sl;
        ImageView image;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            FoodName = itemView.findViewById(R.id.FoodName);
            price = itemView.findViewById(R.id.FoodPrice);
            mainLayout = itemView.findViewById(R.id.LinearLayout);
            sl = itemView.findViewById(R.id.soLuong);
            image = itemView.findViewById(R.id.Image);


        }

    }
}
