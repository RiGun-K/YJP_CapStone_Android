package com.example.yjp_capstone.ui.teamplan;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    ArrayList<String> strings = new ArrayList<>();

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

        strings.add("영진전문대학");
        strings.add("정보통신");
        strings.add("고등학교");
        strings.add("직장인");
        strings.add("동아리1");
        strings.add("동아리2");
        strings.add("ABC");
        strings.add("국제");

        teamDomains.add(new TeamDomain("영진전문대학",true));
        teamDomains.add(new TeamDomain("정보통신",true));
        teamDomains.add(new TeamDomain("고등학교",true));
        teamDomains.add(new TeamDomain("직장인",true));
        teamDomains.add(new TeamDomain("동아리1",true));
        teamDomains.add(new TeamDomain("동아리2",true));
        teamDomains.add(new TeamDomain("ABC",false));
        teamDomains.add(new TeamDomain("국제",false));

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

                if(!teamDomains.get(pos).isStatus()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("초대 수락").setMessage("초대를 수락하시겠습니까?");
                    builder.setNegativeButton("거부합니다", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            teamAdapter.notifyItemRemoved(pos);
                            teamAdapter.notifyItemRangeRemoved(pos, pos);
                            teamDomains.remove(pos);
                        }
                    });
                    builder.setPositiveButton("수락합니다", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            teamDomains.set(pos, new TeamDomain(strings.get(pos), true));
                            teamAdapter.notifyItemChanged(pos);
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();
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