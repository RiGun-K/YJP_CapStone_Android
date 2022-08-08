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
import com.example.yjp_capstone.databinding.FragmentTeamMenuBinding;
import com.example.yjp_capstone.viewmodel.teamplan.PlanMenuViewModel;

public class PlanMenu extends Fragment {

    private PlanMenuViewModel mViewModel;
    private FragmentPlanMenuBinding binding;

    public static PlanMenu newInstance() {
        return new PlanMenu();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPlanMenuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planMenu_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planMenu_to_mainFragment);
        });
        binding.PlanDetail.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_planMenu_to_planDetail);
        });
        binding.PlanCheckList.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_planMenu_to_planChecklist);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}