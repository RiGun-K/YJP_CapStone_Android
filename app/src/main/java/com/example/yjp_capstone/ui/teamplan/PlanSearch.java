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
import com.example.yjp_capstone.databinding.FragmentPlanSearchBinding;
import com.example.yjp_capstone.databinding.FragmentTeamMenuBinding;
import com.example.yjp_capstone.domain.PlanDomain;
import com.example.yjp_capstone.ui.tech.RecyclerDecoration;
import com.example.yjp_capstone.viewmodel.teamplan.PlanSearchViewModel;

import java.util.ArrayList;

public class PlanSearch extends Fragment {

    private PlanSearchViewModel mViewModel;
    private FragmentPlanSearchBinding binding;
    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;
    private PlanAdapter planAdapter = null;
    ArrayList<PlanDomain> planDomains;

    public static PlanSearch newInstance() {
        return new PlanSearch();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPlanSearchBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = binding.planSearchList;
        planDomains = new ArrayList<>();
        planAdapter = new PlanAdapter(planDomains);
        recyclerView.setAdapter(planAdapter);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        planDomains.add(new PlanDomain("오지투어", "2022-08-08 ~ 2022-08-09"));
        planDomains.add(new PlanDomain("부산탐방", "2022-01-02 ~ 2022-01-03"));
        planDomains.add(new PlanDomain("충주답사", "2022-09-05 ~ 2022-09-06"));
        planDomains.add(new PlanDomain("강가캠핑", "2022-09-25 ~ 2022-09-26"));
        planDomains.add(new PlanDomain("수학여행", "2022-10-10 ~ 2022-10-11"));
        planDomains.add(new PlanDomain("계곡을 찾아서", "2022-11-11 ~ 2022-11-13"));
        planDomains.add(new PlanDomain("산악투어", "2022-05-05 ~ 2022-05-06"));
        planDomains.add(new PlanDomain("지리산캠핑", "2022-12-25 ~ 2022-12-26"));
        planDomains.add(new PlanDomain("설악산장악", "2022-03-04 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("양산투어", "2022-04-04 ~ 2022-04-08"));
        planDomains.add(new PlanDomain("강원도 오지 캠핑", "2022-07-07 ~ 2022-07-08"));
        planDomains.add(new PlanDomain("몸만 가는 캠핑", "2022-01-30 ~ 2022-02-01"));

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(80);
        recyclerView.addItemDecoration(spaceDecoration);

        planAdapter.setOnItemClickListener(new PlanAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int pos) {
                if(pos == 0){
                    Navigation.findNavController(v).navigate(R.id.action_planSearch_to_resultPlanMenu);
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
            Navigation.findNavController(v).navigate(R.id.action_planSearch_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planSearch_to_mainFragment);
        });
        binding.planKeyWordSearchBtn.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_planSearch_to_resultSearch);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}