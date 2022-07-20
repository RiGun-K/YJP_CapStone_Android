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
import com.example.yjp_capstone.databinding.FragmentPlanAddSelectBinding;
import com.example.yjp_capstone.viewmodel.teamplan.PlanAddSelectViewModel;

public class PlanAddSelect extends Fragment {

    private PlanAddSelectViewModel mViewModel;
    private FragmentPlanAddSelectBinding binding;

    public static PlanAddSelect newInstance() {
        return new PlanAddSelect();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_plan_add_select, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planAddSelect_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planAddSelect_to_mainFragment);
        });
        binding.planSearchBtn.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_planAddSelect_to_planSearch);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlanAddSelectViewModel.class);
        // TODO: Use the ViewModel
    }

}