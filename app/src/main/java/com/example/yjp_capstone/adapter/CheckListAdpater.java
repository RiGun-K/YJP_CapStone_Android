package com.example.yjp_capstone.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.domain.CheckListDomain;
import com.example.yjp_capstone.domain.PlanDomain;

import java.util.ArrayList;

public class CheckListAdpater extends RecyclerView.Adapter<CheckListAdpater.ViewHolder> {
    private ArrayList<CheckListDomain> listDomains = null;

    public CheckListAdpater(ArrayList<CheckListDomain> listDomains) {
        this.listDomains = listDomains;
    }

    @NonNull
    @Override
    public CheckListAdpater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_check_list_item, parent, false);
        return new CheckListAdpater.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckListAdpater.ViewHolder holder, int position) {
        holder.onBind(listDomains.get(position));
        holder.chColor(listDomains.get(position));
    }

    @Override
    public int getItemCount() {
        return listDomains.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }

    private OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.listLayoutText);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){
                        if(onItemClickListener != null){
                            onItemClickListener.onItemClick(view, pos);
                        }
                    }
                }
            });
        }

        void onBind(CheckListDomain list){
            itemTitle.setText(list.getItemName());
        }
        void chColor(CheckListDomain list){
            if(!list.isStatus()){
                itemTitle.setTextColor(0xFFFFFFFF);
                itemTitle.setBackgroundColor(0xFFFF0000);
            }
            else{
                itemTitle.setTextColor(0xFF000000);
                itemTitle.setBackgroundColor(0xFF66B2FF);
            }
    }
    }
}
