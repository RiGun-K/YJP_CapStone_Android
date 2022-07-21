package com.example.yjp_capstone.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.databinding.FragmentMyBoxMenuBinding;
import com.example.yjp_capstone.viewmodel.MyBoxMenuViewModel;

public class MyBoxMenuFragment extends Fragment {
    private FragmentMyBoxMenuBinding binding;
    private MyBoxMenuViewModel mViewModel;

    public static MyBoxMenuFragment newInstance() {
        return new MyBoxMenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMyBoxMenuBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
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
        binding.ubItem.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_myBoxMenuFragment_to_myBoxItemFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}