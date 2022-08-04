package com.example.yjp_capstone.ui.teamplan;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yjp_capstone.R;
import com.example.yjp_capstone.adapter.CheckListAdpater;
import com.example.yjp_capstone.databinding.FragmentPlanChecklistBinding;
import com.example.yjp_capstone.domain.CheckListDomain;
import com.example.yjp_capstone.ui.tech.RecyclerDecoration;
import com.example.yjp_capstone.viewmodel.teamplan.PlanChecklistViewModel;

import java.util.ArrayList;

public class PlanChecklist extends Fragment {

    private PlanChecklistViewModel mViewModel;
    private FragmentPlanChecklistBinding binding;
    private RecyclerView recyclerView = null;
    private RecyclerView.LayoutManager layoutManager = null;
    private CheckListAdpater listAdpater = null;
    ArrayList<CheckListDomain> listDomains;

    public static PlanChecklist newInstance() {
        return new PlanChecklist();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentPlanChecklistBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        recyclerView = binding.checkListList;
        listDomains = new ArrayList<>();
        listAdpater = new CheckListAdpater(listDomains);
        layoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setAdapter(listAdpater);
        recyclerView.setLayoutManager(layoutManager);

        listDomains.add(new CheckListDomain("리스트1", true));
        listDomains.add(new CheckListDomain("리스트2", true));
        listDomains.add(new CheckListDomain("리스트3", true));
        listDomains.add(new CheckListDomain("리스트4", true));
        listDomains.add(new CheckListDomain("리스트5", false));
        listDomains.add(new CheckListDomain("리스트6", true));
        listDomains.add(new CheckListDomain("리스트7", true));
        listDomains.add(new CheckListDomain("리스트8", true));
        listDomains.add(new CheckListDomain("리스트9", true));

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(80);
        recyclerView.addItemDecoration(spaceDecoration);
        listAdpater.setOnItemClickListener(new CheckListAdpater.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int pos) {
                if (listDomains.get(pos).isStatus()){
                    listDomains.set(pos, new CheckListDomain("리스트"+(pos+1), false));
                }else{
                    listDomains.set(pos, new CheckListDomain("리스트"+(pos+1), true));
                }
                listAdpater.notifyItemChanged(pos);
            }
        });
        listAdpater.notifyDataSetChanged();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.sideBar.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planChecklist_to_sideMenuFragment);
        });
        binding.imageView2.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_planChecklist_to_mainFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}