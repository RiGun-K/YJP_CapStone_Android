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
import com.example.yjp_capstone.databinding.FragmentPlanChecklistBinding;
import com.example.yjp_capstone.viewmodel.teamplan.PlanChecklistViewModel;

public class PlanChecklist extends Fragment {

    private PlanChecklistViewModel mViewModel;
    private FragmentPlanChecklistBinding binding;

    public static PlanChecklist newInstance() {
        return new PlanChecklist();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_plan_checklist, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_myPageFragment_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_myPageFragment_to_mainFragment);
        });
        binding.textView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_myPageFragment_to_myBoxFragment);
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlanChecklistViewModel.class);
        // TODO: Use the ViewModel
    }

}