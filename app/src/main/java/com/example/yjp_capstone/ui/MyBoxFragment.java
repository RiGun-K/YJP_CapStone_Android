package com.example.yjp_capstone.ui;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.adapter.MyBoxAdapter;
import com.example.yjp_capstone.databinding.FragmentMyBoxBinding;
import com.example.yjp_capstone.domain.UseBoxDAO;
import com.example.yjp_capstone.viewmodel.MyBoxViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyBoxFragment extends Fragment {
    FragmentMyBoxBinding binding;
    MyBoxViewModel mViewModel;
    List<UseBoxDAO> useBoxList = new ArrayList<>();

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

        MyBoxViewModel model = new MyBoxViewModel();
        List<UseBoxDAO> useBoxDAOList = model.getUseBox();
        useBoxList = useBoxDAOList;

        MyBoxAdapter adapter = new MyBoxAdapter(useBoxDAOList);
//        RecyclerView recyclerView = binding.useboxlist;
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(adapter);
        Log.d("ccc", "s"+String.valueOf(useBoxList.size()));

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();

        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_myBoxFragment_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_myBoxFragment_to_mainFragment);
        });

        binding.S1.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_myBoxFragment_to_myBoxMenuFragment);
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}