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

        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획1", "2022-03-08 ~ 2022-03-09"));
        planDomains.add(new PlanDomain("계획2", "2022-03-08 ~ 2022-03-09"));

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