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
import com.example.yjp_capstone.databinding.FragmentPlanMenuBinding;
import com.example.yjp_capstone.databinding.FragmentResultPlanMenuBinding;
import com.example.yjp_capstone.viewmodel.teamplan.ResultPlanMenuViewModel;

public class resultPlanMenu extends Fragment {

    private ResultPlanMenuViewModel mViewModel;
    private FragmentResultPlanMenuBinding binding;

    public static resultPlanMenu newInstance() {
        return new resultPlanMenu();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentResultPlanMenuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_resultPlanMenu_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_resultPlanMenu_to_mainFragment);
        });
        binding.PlanDetail.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_resultPlanMenu_to_resultPlanDetail);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ResultPlanMenuViewModel.class);
        // TODO: Use the ViewModel
    }

}