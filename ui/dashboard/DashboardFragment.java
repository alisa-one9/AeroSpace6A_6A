package com.example.aerospace6a_6a.ui.dashboard;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.aerospace6a_6a.R;
import com.example.aerospace6a_6a.room.Prefs;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import de.hdodenhof.circleimageview.CircleImageView;


public class DashboardFragment extends Fragment {

    public static String key = "key";
    private CircleImageView my_image;
    private Button btnPonedelnik, btnVtornik, btnSreda, btnChetverg, btnPytnica;
    private NavController navController;
    private FloatingActionButton back;

    private Prefs prefs;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        prefs =new Prefs(requireContext());
        return inflater.inflate(R.layout.fragment_dashboard, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        my_image = view.findViewById(R.id.my_image);
        btnPonedelnik = view.findViewById(R.id.btn_ponedelnik);
        btnVtornik = view.findViewById(R.id.btn_vtornik);
        btnSreda = view.findViewById(R.id.btn_sreda);
        btnChetverg = view.findViewById(R.id.btn_Chetverg);
        btnPytnica = view.findViewById(R.id.btn_Pytnica);

        back =view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController
                        .navigate(R.id.action_navigation_dashboard_to_navigation_home);
            }
        });

        btnPonedelnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController
                        .navigate(R.id.action_navigation_dashboard_to_ponedFragment);

            }
        });

        btnVtornik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController
                        .navigate(R.id.action_navigation_dashboard_to_vtornikFragment);

            }
        });
        btnSreda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController
                        .navigate(R.id.action_navigation_dashboard_to_sredaFragment);

            }
        });
        btnChetverg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController
                        .navigate(R.id.action_navigation_dashboard_to_chetvergFragment);

            }
        });
        btnPytnica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController
                        .navigate(R.id.action_navigation_dashboard_to_pytnicaFragment);

            }
        });


    }

}