package com.example.aerospace6a_6a.ui.notifications;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.aerospace6a_6a.App;
import com.example.aerospace6a_6a.databinding.ItemZapisiBinding;
import com.example.aerospace6a_6a.room.AppDataBase;
import com.example.aerospace6a_6a.room.Note;
import com.example.aerospace6a_6a.room.NoteDao;
import com.example.aerospace6a_6a.room.OnItemClickListener;
import com.example.aerospace6a_6a.R;

import java.util.ArrayList;
import java.util.List;

public class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.ViewHolder> {

   private List<Note> notes = new ArrayList<>();
    private NoteDao noteDao;

    public void setList(List<Note>notes){
        this.notes = notes;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemZapisiBinding itemZapisiBinding = ItemZapisiBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ViewHolder viewHolder = new ViewHolder(itemZapisiBinding);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        noteDao = Room.databaseBuilder(
                holder.binding.getRoot().getContext(),
                AppDataBase.class, "database")
                .allowMainThreadQueries().build().noteDao();
        Note note = notes.get(position);
        holder.binding.temaZametka.setText(note.getT_name());


        holder.binding.item.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(holder.binding.getRoot().getContext()).create();
                alertDialog.setTitle( "Вы хотите удалить запись ?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "ДА",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                noteDao.delete(note);
                                notes.remove(holder.getAdapterPosition());
                                notifyDataSetChanged();
                                dialog.dismiss();
                            }
                        });

                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "НЕТ",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return notes.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemZapisiBinding binding;


        public ViewHolder(@NonNull ItemZapisiBinding itemView) {
            super(itemView.getRoot());
            this.binding =itemView;

        }

    }
}
