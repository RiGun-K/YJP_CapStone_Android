package com.example.yjp_capstone.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.databinding.FragmentMyBoxBinding;
import com.example.yjp_capstone.viewmodel.MyBoxViewModel;

public class MyBoxFragment extends Fragment {
    private FragmentMyBoxBinding binding;
    private MyBoxViewModel mViewModel;
    String a = "2";
//    private
    public static MyBoxFragment newInstance() {
        return new MyBoxFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMyBoxBinding.inflate(inflater,container,false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        binding.useboxlist.
        MyBoxViewModel model = new MyBoxViewModel();
        model.getUseBox();

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