package com.example.yjp_capstone.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.domain.UseBoxDAO;
import com.example.yjp_capstone.domain.UseStorageBox;

import java.util.ArrayList;
import java.util.List;


public class MyBoxAdapter extends RecyclerView.Adapter<MyBoxAdapter.ViewHolder> {
    private List<UseBoxDAO> UseBoxList;

    public MyBoxAdapter(List<UseBoxDAO> useBox) {
        this.UseBoxList = useBox;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyBoxAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_box_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBoxAdapter.ViewHolder holder, int position) {
        holder.onBind(UseBoxList.get(position));
    }


    @Override
    public int getItemCount() {
        return UseBoxList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView info;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.boxName);
            info = (TextView) itemView.findViewById(R.id.boxinfo);
            Log.d("bbb",name+","+info);
        }

        void onBind(UseBoxDAO item){
            name.setText(item.getBoxName());
            info.setText(item.getUseState());
            Log.d("bbb",name+","+info);
        }
    }
}
