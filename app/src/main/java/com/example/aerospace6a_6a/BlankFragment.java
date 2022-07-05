package com.example.aerospace6a_6a;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.aerospace6a_6a.databinding.FragmentBlankBinding;
import com.example.aerospace6a_6a.room.AppDataBase;
import com.example.aerospace6a_6a.room.Note;
import com.example.aerospace6a_6a.room.NoteDao;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class BlankFragment extends Fragment {
    private FragmentBlankBinding binding;
    private AppDataBase appDataBase;
    private NoteDao noteDao;
    private Button save;
    NavController navController;
    private EditText editText;
    private FloatingActionButton back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        // отрисовка страницы

        this.appDataBase = Room.databaseBuilder(
                binding.getRoot().getContext(),
                AppDataBase.class, "database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        noteDao = appDataBase.noteDao();

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();
                note.setT_name(binding.editText.getText().toString());

                if(!(note.getT_name().isEmpty())){
                    noteDao.insert(note);
                    NavController navController = Navigation.findNavController(requireActivity(),
                            R.id.nav_host_fragment_activity_main);
                    navController.navigateUp();
                    navController.navigate(R.id.navigation_notifications);
                } else{
                    AlertDialog alertDialog = new AlertDialog.Builder(binding.getRoot().getContext()).create();
                    alertDialog.setTitle("Ошибка");
                    alertDialog.setMessage("Поле записи не может быть пустым");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Ok",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment_activity_main);
                navController.navigate(R.id.action_blankFragment_to_navigation_dashboard);
            }
        });
    }
}