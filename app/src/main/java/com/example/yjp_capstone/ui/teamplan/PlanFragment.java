package com.example.yjp_capstone.ui.teamplan;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.adapter.PlanAdapter;
import com.example.yjp_capstone.databinding.FragmentPlanBinding;
import com.example.yjp_capstone.databinding.FragmentTeamMenuBinding;
import com.example.yjp_capstone.domain.PlanDomain;
import com.example.yjp_capstone.ui.tech.RecyclerDecoration;
import com.example.yjp_capstone.viewmodel.teamplan.PlanViewModel;

import java.util.ArrayList;

public class PlanFragment extends Fragment {

    private PlanViewModel mViewModel;
    private FragmentPlanBinding binding;
    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;
    private PlanAdapter planAdapter = null;
    ArrayList<PlanDomain> planDomains;


    public static PlanFragment newInstance() {
        return new PlanFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPlanBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = binding.planList;
        planDomains = new ArrayList<>();
        planAdapter = new PlanAdapter(planDomains);
        recyclerView.setAdapter(planAdapter);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        planDomains.add(new PlanDomain("15호 계획", "2022-08-25 ~ 2022-08-26"));
        planDomains.add(new PlanDomain("캠핑의 기본", "2021-12-31 ~ 2022-01-01"));
        planDomains.add(new PlanDomain("제주도 탐방", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("서울 투어", "2022-11-15 ~ 2022-11-16"));
        planDomains.add(new PlanDomain("16호 계획", "2022-06-18 ~ 2022-06-19"));
        planDomains.add(new PlanDomain("아자아자", "2022-05-22 ~ 2022-05-23"));
        planDomains.add(new PlanDomain("강원도는 어디가지", "2022-12-25 ~ 2022-12-26"));
        planDomains.add(new PlanDomain("부산가자", "2022-07-14 ~ 2022-07-15"));
        planDomains.add(new PlanDomain("광주가는 날", "2022-06-08 ~ 2022-06-12"));
        planDomains.add(new PlanDomain("19호 계획", "2022-02-01 ~ 2022-02-05"));

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(80);
        recyclerView.addItemDecoration(spaceDecoration);

        planAdapter.setOnItemClickListener(new PlanAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int pos) {
                if(pos == 0){
                    Navigation.findNavController(v).navigate(R.id.action_planFragment_to_planMenu);
                }
                if(pos == 1){

                }
                if(pos == 2){

                }
                if(pos == 6){

                }
            }
        });
        planAdapter.notifyDataSetChanged();
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