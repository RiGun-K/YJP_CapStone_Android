package com.example.yjp_capstone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.domain.UseStorageBox;

import java.util.ArrayList;


public class MyBoxAdapter extends RecyclerView.Adapter<MyBoxAdapter.ViewHolder> {
    private ArrayList<UseStorageBox> useStorageBoxList;

    @NonNull
    @Override
    public MyBoxAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_box_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyBoxAdapter.ViewHolder holder, int position) {
        holder.onBind(useStorageBoxList.get(position));
    }

    public void setFriendList(ArrayList<UseStorageBox> list){
        this.useStorageBoxList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return useStorageBoxList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView info;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.boxName);
            info = (TextView) itemView.findViewById(R.id.boxinfo);
        }

        void onBind(UseStorageBox item){
            name.setText(item.getBoxName());
            info.setText(item.getBoxState());
        }
    }
}
