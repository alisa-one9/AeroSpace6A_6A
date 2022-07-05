package com.example.aerospace6a_6a;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aerospace6a_6a.databinding.FragmentChetvergBinding;
import com.example.aerospace6a_6a.databinding.FragmentPonedBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;



public class ChetvergFragment extends Fragment {
    NavController navController;
    private RecyclerView rv;
    private ChetvergAdapter adapter;
    private ArrayList<Model> list = new ArrayList<>();
    private FloatingActionButton back;


    public ChetvergFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ChetvergAdapter(ChetvergFragment.this);
        createList();
        adapter.setList(list);

    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chetverg, container, false);
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.rv_plan);
        rv.setAdapter(adapter);
        back =view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController
                        .navigate(R.id.action_chetvergFragment_to_navigation_dashboard);
            }
        });


    }









    private void createList() {
        list.add(new Model(" Русский язык ", R.drawable.russian));

        list.add(new Model(" Кыргыз адабият ", R.drawable.adabiat));

        list.add(new Model(" Английский язык ", R.drawable.english));

        list.add(new Model(" География  ", R.drawable.geography));

        list.add(new Model(" Информатика ", R.drawable.informatika));

        list.add(new Model(" История ", R.drawable.history));

        list.add(new Model(" Биология ", R.drawable.biology));

        list.add(new Model(" Турецкий язык ", R.drawable.turkce));

        list.add(new Model(" Литература  ", R.drawable.literatura));

        list.add(new Model(" Кыргыз тили ", R.drawable.kirgiz_tili));

        list.add(new Model(" Человек и общество ", R.drawable.chio));

        list.add(new Model(" Математика ", R.drawable.matem));
    }
}