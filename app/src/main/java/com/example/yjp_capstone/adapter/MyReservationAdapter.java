package com.example.yjp_capstone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.domain.PlanDomain;
import com.example.yjp_capstone.domain.ReservationDomain;

import java.util.ArrayList;

public class MyReservationAdapter extends RecyclerView.Adapter<MyReservationAdapter.ViewHolder> {
    private ArrayList<ReservationDomain> reservationDomains = null;

    public MyReservationAdapter(ArrayList<ReservationDomain> reservationDomains) { this.reservationDomains = reservationDomains; }

    @NonNull
    @Override
    public MyReservationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_my_reservation_item, parent, false);
        return new MyReservationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyReservationAdapter.ViewHolder holder, int position) {
        holder.onBind(reservationDomains.get(position));
    }

    @Override
    public int getItemCount() {
        return reservationDomains.size();
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int pos);
    }

    private MyReservationAdapter.OnItemClickListener onItemClickListener = null;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.onItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView itemTitle;
        TextView itemDate;
        TextView itemPeople;
        TextView itemCharge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.reservationItemTitle);
            itemDate = (TextView) itemView.findViewById(R.id.reservationDate);
            itemPeople = (TextView) itemView.findViewById(R.id.reservationPeople);
            itemCharge = (TextView) itemView.findViewById(R.id.reservationCharge);

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

        void onBind(ReservationDomain reservationDomain){
            itemTitle.setText(reservationDomain.getTitle());
            itemDate.setText(reservationDomain.getDate());
            itemPeople.setText(reservationDomain.getPeople());
            itemCharge.setText(reservationDomain.getCharge());
        }
    }
}
