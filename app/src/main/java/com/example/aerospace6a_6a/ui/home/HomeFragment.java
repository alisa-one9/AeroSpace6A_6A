package com.example.aerospace6a_6a.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.navigation.Navigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.example.aerospace6a_6a.R;
import com.example.aerospace6a_6a.databinding.FragmentHomeBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment {

    private EditText ramka_1;
    private Button btn_1;
    private Button btn_2;
    private Button raspisanie;
    private NavController navController;



    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        clickStart();   }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ramka_1 = view.findViewById(R.id.ramka_1);
        btn_1 = view.findViewById(R.id.btn_1);
        btn_2 = view.findViewById(R.id.btn_2);
        raspisanie = view.findViewById(R.id.raspisanie);

        return view;
    }


    private void clickStart() {
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_1.setVisibility(View.INVISIBLE);
                ramka_1.setVisibility(View.VISIBLE);
                ramka_1.setCursorVisible(true);
                btn_2.setVisibility(View.VISIBLE);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });

        raspisanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toFragment();
            }
        });

    }
    @SuppressLint("IntentReset")
    protected void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Пожелания от ученика школы Intellect перед полетом");
        emailIntent.putExtra(Intent.EXTRA_TEXT, ramka_1.getText().toString());
        Log.e("TAG", "!! Function sendEmail run");
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));

            Log.i("Finish", "!! LetterApps   open for send email");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(requireActivity(), "There is no email client installed.",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void toFragment() {
        navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment_activity_main);
        navController
                .navigate(R.id.action_navigation_home_to_navigation_dashboard);


    }
}
