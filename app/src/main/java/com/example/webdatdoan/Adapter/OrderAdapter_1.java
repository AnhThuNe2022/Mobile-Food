package com.example.webdatdoan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webdatdoan.Activity.ChiTietDonHang;
import com.example.webdatdoan.R;
import com.example.webdatdoan.model.HoaDon;

import java.util.ArrayList;

public class OrderAdapter_1 extends RecyclerView.Adapter<OrderAdapter_1.ViewHolder> {

    ArrayList<HoaDon> hoaDons;
    Context context;

    public OrderAdapter_1(ArrayList<HoaDon> hoaDons, Context context) {
        this.hoaDons = hoaDons;
        this.context = context;
    }

    public OrderAdapter_1(ArrayList<HoaDon> hoaDons ) {
        this.hoaDons = hoaDons;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);


        View orders = inflater.inflate(R.layout.customerlayout_order, parent, false);

        ViewHolder viewHolder = new ViewHolder(orders);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull OrderAdapter_1.ViewHolder holder, int position) {

        holder.maDH.setText(hoaDons.get(position).getMaHoaDon());
        holder.maKH.setText(hoaDons.get(position).getMaKH());
        holder.ngayDH.setText(hoaDons.get(position).getDate());
        holder.tongTien.setText(String.valueOf(hoaDons.get(position).getTongTien()));

    }

    @Override
    public int getItemCount() {
        return hoaDons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView maDH;
        TextView maKH;
        TextView ngayDH;
        TextView tongTien;
        LinearLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            maDH = itemView.findViewById(R.id.soDH);
            maKH = itemView.findViewById(R.id.maKH);
            ngayDH = itemView.findViewById(R.id.ngayDat);
            tongTien = itemView.findViewById(R.id.tongTien);
            mainLayout = itemView.findViewById(R.id.customerlayout_order);

            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), ChiTietDonHang.class);
                    intent.putExtra("tt",2);
                    intent.putExtra("maDH",maDH.getText());
                    view.getContext().startActivity(intent);

                }
            });
        }


    }
}
