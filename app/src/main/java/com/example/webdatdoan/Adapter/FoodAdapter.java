package com.example.webdatdoan.Adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.webdatdoan.Activity.AddFood;
import com.example.webdatdoan.Activity.RUD_Food;
import com.example.webdatdoan.Activity.UpdateFood;
import com.example.webdatdoan.R;
import com.example.webdatdoan.model.MonAn;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodAdapter  extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{
    ArrayList<MonAn> monAns;
    Context context;

    public FoodAdapter(ArrayList<MonAn> monAns, Context context) {
        this.monAns = monAns;
        this.context = context;
    }


    @NonNull
    @Override
    public FoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View FoodView = inflater.inflate(R.layout.listfood_manage, parent, false);


        ViewHolder viewHolder = new ViewHolder(FoodView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.ViewHolder holder, int position) {

        holder.maMonAn = monAns.get(position).getMaMonAn();
        holder.donGia.setText(String.valueOf(monAns.get(position).getDonGia()));
        holder.anhMonAn.setImageResource(Integer.parseInt(monAns.get(position).getAnh()));
        holder.donViTinh.setText(monAns.get(position).getDonViTinh());
        holder.slTonKho.setText(String.valueOf(monAns.get(position).getSoLuongTonKho()));
        holder.loaiMonAn.setText(monAns.get(position).getLoaiMonAn());
        holder.tenMonAn.setText(monAns.get(position).getTenMonAn());
        holder.moTa.setText(monAns.get(position).getMoTa());

    }

    @Override
    public int getItemCount() {
        return  monAns.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        String maMonAn;
        TextView tenMonAn;
        TextView loaiMonAn;
        TextView moTa;
        TextView slTonKho;
        TextView donGia;
        TextView donViTinh;
        ImageView anhMonAn;
        LinearLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tenMonAn = itemView.findViewById(R.id.RUD_tenMonAn);
            loaiMonAn = itemView.findViewById(R.id.RUD_LoaiDoAn);
            moTa = itemView.findViewById(R.id.RUD_MoTa);
            slTonKho = itemView.findViewById(R.id.RUD_SLTonKho);
            donGia = itemView.findViewById(R.id.RUD_DonGia);
            donViTinh = itemView.findViewById(R.id.RUD_DonViTinh);
            anhMonAn = itemView.findViewById(R.id.RUD_pic);
            mainLayout = itemView.findViewById(R.id.listFood);

            mainLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(view.getContext(), UpdateFood.class);
                    intent.putExtra("MaMonAn",maMonAn);
                    view.getContext().startActivity(intent);

                }
            });

        }
    }

}
