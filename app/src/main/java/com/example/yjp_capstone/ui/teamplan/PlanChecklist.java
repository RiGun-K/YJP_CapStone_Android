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
    ArrayList<String> strings = new ArrayList<>();

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

        strings.add("텐트");
        strings.add("조리도구");
        strings.add("모기약");
        strings.add("먹을거");
        strings.add("마실거");
        strings.add("캠핑의자");
        strings.add("장작");
        strings.add("캠프파이어키트");


        listDomains.add(new CheckListDomain("텐트", true));
        listDomains.add(new CheckListDomain("조리도구", true));
        listDomains.add(new CheckListDomain("모기약", true));
        listDomains.add(new CheckListDomain("먹을거", true));
        listDomains.add(new CheckListDomain("마실거", false));
        listDomains.add(new CheckListDomain("캠핑의자", true));
        listDomains.add(new CheckListDomain("장작", true));
        listDomains.add(new CheckListDomain("캠프파이어키트", true));

        RecyclerDecoration spaceDecoration = new RecyclerDecoration(80);
        recyclerView.addItemDecoration(spaceDecoration);
        listAdpater.setOnItemClickListener(new CheckListAdpater.OnItemClickListener(){
            @Override
            public void onItemClick(View v, int pos) {
                if (listDomains.get(pos).isStatus()){
                    listDomains.set(pos, new CheckListDomain(strings.get(pos), false));
                }else{
                    listDomains.set(pos, new CheckListDomain(strings.get(pos), true));
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