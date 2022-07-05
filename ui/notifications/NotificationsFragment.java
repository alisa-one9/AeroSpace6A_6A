package com.example.aerospace6a_6a.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.aerospace6a_6a.App;
import com.example.aerospace6a_6a.R;
import com.example.aerospace6a_6a.databinding.FragmentNotificationsBinding;
import com.example.aerospace6a_6a.room.AppDataBase;
import com.example.aerospace6a_6a.room.Note;
import com.example.aerospace6a_6a.room.NoteDao;
import com.example.aerospace6a_6a.room.OnItemClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class NotificationsFragment extends Fragment  {
    private FragmentNotificationsBinding binding;
    private AppDataBase appDataBase;
    private NoteDao noteDao;
    private NavController navController;
      private FloatingActionButton back;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       binding = FragmentNotificationsBinding.inflate(inflater,container,false);
       View root = binding.getRoot();

       RecyclerView recyclerView = binding.rvZapisi;
       recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext()));
       recyclerView.setHasFixedSize(true);
       NotifAdapter notifAdapter = new NotifAdapter();
       recyclerView.setAdapter(notifAdapter);
       appDataBase = Room.databaseBuilder(binding.getRoot().getContext()
               ,AppDataBase.class,"database")
               .fallbackToDestructiveMigration()
               .allowMainThreadQueries().build();
       noteDao = appDataBase.noteDao();
       notifAdapter.setList(noteDao.getAll());
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
                navController
                        .navigate(R.id.action_navigation_notifications_to_blankFragment);
            }
        });
    }
}