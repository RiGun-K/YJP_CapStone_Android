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
import com.example.yjp_capstone.databinding.FragmentPlanBinding;
import com.example.yjp_capstone.databinding.FragmentTeamMenuBinding;
import com.example.yjp_capstone.viewmodel.teamplan.PlanViewModel;

public class PlanFragment extends Fragment {

    private PlanViewModel mViewModel;
    private FragmentPlanBinding binding;

    public static PlanFragment newInstance() {
        return new PlanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPlanBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planFragment_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planFragment_to_mainFragment);
        });
        binding.planAddBtn.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_planFragment_to_planAddSelect);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}