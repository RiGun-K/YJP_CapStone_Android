package com.example.yjp_capstone.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.adapter.MyReservaionAdapter;
import com.example.yjp_capstone.viewmodel.MyReservationItemViewModel;

import java.util.ArrayList;

public class MyReservationItemFragment extends Fragment {

    private MyReservationItemViewModel mViewModel;

    public static MyReservationItemFragment newInstance() {
        return new MyReservationItemFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_reservation_item, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MyReservationItemViewModel.class);
        // TODO: Use the ViewModel
    }

}