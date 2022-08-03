package com.example.yjp_capstone.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.databinding.FragmentSideMenuBinding;
import com.example.yjp_capstone.viewmodel.SideMenuViewModel;

public class SideMenuFragment extends Fragment {
    private FragmentSideMenuBinding binding;
    private SideMenuViewModel mViewModel;


    public static SideMenuFragment newInstance() {
        return new SideMenuFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentSideMenuBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.closeButton.setOnClickListener(v->{
            Navigation.findNavController(v).navigateUp();
        });
        binding.myPage.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_sideMenuFragment_to_myPageFragment);
        });
        binding.plan.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_sideMenuFragment_to_teamFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}