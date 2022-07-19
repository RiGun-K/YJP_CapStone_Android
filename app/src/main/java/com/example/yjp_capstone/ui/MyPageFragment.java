package com.example.yjp_capstone.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.databinding.FragmentMyPageBinding;
import com.example.yjp_capstone.viewmodel.MyPageViewModel;

public class MyPageFragment extends Fragment {
    private FragmentMyPageBinding binding;
    private MyPageViewModel mViewModel;

    public static MyPageFragment newInstance() {
        return new MyPageFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMyPageBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.closeButton
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}