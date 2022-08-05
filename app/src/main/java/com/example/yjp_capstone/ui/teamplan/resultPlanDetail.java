package com.example.yjp_capstone.ui.teamplan;

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
import com.example.yjp_capstone.databinding.FragmentPlanDetailBinding;
import com.example.yjp_capstone.databinding.FragmentResultPlanDetailBinding;
import com.example.yjp_capstone.viewmodel.teamplan.PlanDetailViewModel;
import com.example.yjp_capstone.viewmodel.teamplan.ResultPlanDetailViewModel;

public class resultPlanDetail extends Fragment {

    private ResultPlanDetailViewModel mViewModel;
    private FragmentResultPlanDetailBinding binding;

    public static resultPlanDetail newInstance() {
        return new resultPlanDetail();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentResultPlanDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ResultPlanDetailViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_resultPlanDetail_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_resultPlanDetail_to_mainFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}