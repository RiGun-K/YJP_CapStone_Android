package com.example.yjp_capstone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yjp_capstone.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyReservaionAdapter extends RecyclerView.Adapter<MyReservaionAdapter.ViewHolder> {

    ArrayList<String> mData = null;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1 ;

        ViewHolder(View itemView) {
            super(itemView) ;

            // 뷰 객체에 대한 참조. (hold strong reference)
            textView1 = itemView.findViewById(R.id.text1) ;
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    MyReservaionAdapter(ArrayList<String> list) {
        mData = list ;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext() ;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

        View view = inflater.inflate(R.layout.fragment_my_reservation_item, parent, false) ;
        MyReservaionAdapter.ViewHolder vh = new MyReservaionAdapter.ViewHolder(view) ;

        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String text = mData.get(position) ;
        holder.textView1.setText(text) ;
    }

    @Override
    public int getItemCount() {
        return mData.size() ;
    }

}
