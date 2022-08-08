package com.example.yjp_capstone.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.adapter.MyReservationAdapter;
import com.example.yjp_capstone.adapter.PlanAdapter;
import com.example.yjp_capstone.databinding.FragmentMyBoxBinding;
import com.example.yjp_capstone.databinding.FragmentMyReservationBinding;
import com.example.yjp_capstone.domain.PlanDomain;
import com.example.yjp_capstone.domain.ReservationDomain;
import com.example.yjp_capstone.ui.tech.RecyclerDecoration;
import com.example.yjp_capstone.viewmodel.MyReservationViewModel;

import java.util.ArrayList;

public class MyReservationFragment extends Fragment {

    private FragmentMyReservationBinding binding;
    private MyReservationViewModel mViewModel;
    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;
    private MyReservationAdapter myReservationAdapter = null;
    ArrayList<ReservationDomain> reservationDomains;

    public static MyReservationFragment newInstance() {
        return new MyReservationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMyReservationBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        recyclerView = binding.reservationList;
        reservationDomains = new ArrayList<>();
        myReservationAdapter = new MyReservationAdapter(reservationDomains);
        recyclerView.setAdapter(myReservationAdapter);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        reservationDomains.add(new ReservationDomain("대구 오토캠핑", "2022-08-05 ~ 2022-08-07", "4 명", "130,000 원"));

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(80);
        recyclerView.addItemDecoration(spaceDecoration);


        myReservationAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_myBoxFragment_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_myBoxFragment_to_mainFragment);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}