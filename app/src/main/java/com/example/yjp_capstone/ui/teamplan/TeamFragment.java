package com.example.yjp_capstone.ui.teamplan;

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
import com.example.yjp_capstone.adapter.TeamAdapter;
import com.example.yjp_capstone.databinding.FragmentTeamBinding;
import com.example.yjp_capstone.domain.TeamDomain;
import com.example.yjp_capstone.ui.tech.RecyclerDecoration;
import com.example.yjp_capstone.viewmodel.teamplan.TeamViewModel;

import java.util.ArrayList;

public class TeamFragment extends Fragment {

    private TeamViewModel mViewModel;
    private FragmentTeamBinding binding;
    private RecyclerView recyclerView = null;
    private TeamAdapter teamAdapter = null;
    private RecyclerView.LayoutManager layoutManager = null;
    ArrayList<TeamDomain> teamDomains;

    public static TeamFragment newInstance() {
        return new TeamFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentTeamBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = binding.teamItemList;
        teamDomains = new ArrayList<>();
        teamAdapter = new TeamAdapter(teamDomains);
        recyclerView.setAdapter(teamAdapter);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        teamDomains.add(new TeamDomain("칭구칭구",true));
        teamDomains.add(new TeamDomain("올바른 생활",false));
        teamDomains.add(new TeamDomain("너는 누구냐",false));
        teamDomains.add(new TeamDomain("명량",true));
        teamDomains.add(new TeamDomain("영화",true));
        teamDomains.add(new TeamDomain("영화",true));
        teamDomains.add(new TeamDomain("영화",true));
        teamDomains.add(new TeamDomain("영화",true));

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(80);
        recyclerView.addItemDecoration(spaceDecoration);
        teamAdapter.setOnItemClickListener(new TeamAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                if(pos == 0){
                    Navigation.findNavController(v).navigate(R.id.action_teamFragment_to_teamMenu);
                }
                if(pos == 1){

                }
                if(pos == 2){

                }
                if(pos == 6){

                }
            }
        });

        teamAdapter.notifyDataSetChanged();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_teamFragment_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_teamFragment_to_mainFragment);
        });
        binding.teamItemList.setOnClickListener(v->{
            Navigation.findNavController(v).navigate(R.id.action_teamFragment_to_teamMenu);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}