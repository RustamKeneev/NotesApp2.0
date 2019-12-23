package com.example.notesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder>{

    private List<Note> notes;
    private OnNoteClickListener onNoteClickListener;

    public NotesAdapter(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    public NotesAdapter(ArrayList<Note> noteArrayList) {
        this.notes = noteArrayList;
    }


    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,parent,false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.title_text_view.setText(note.getTitle());
        holder.description_text_view.setText(note.getDescription());
        holder.day_of_week_text_view.setText(Note.getDayAsString(note.getDayOfWeek() +1));
        int colorId;
        int priority = note.getPriority();
        switch (priority){
            case  1:
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_red_light);
                break;
            case  2:
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_orange_light);
                break;
            default:
                colorId = holder.itemView.getResources().getColor(android.R.color.holo_green_light);
                break;
        }
        holder.title_text_view.setBackgroundColor(colorId);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setOnNoteClickListener(OnNoteClickListener onNoteClickListener) {
        this.onNoteClickListener = onNoteClickListener;
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{
        TextView title_text_view;
        TextView description_text_view;
        TextView day_of_week_text_view;
        TextView priority_text_view;
        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            title_text_view = itemView.findViewById(R.id.title_text_view);
            description_text_view = itemView.findViewById(R.id.description_text_view);
            day_of_week_text_view = itemView.findViewById(R.id.day_of_week_text_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onNoteClickListener !=null){
                        onNoteClickListener.onNoteClick(getAdapterPosition());
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    onNoteClickListener.onLongNoteClick(getAdapterPosition());
                    return true;
                }
            });

        }
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    public List<Note> getNotes() {
        return notes;
    }
}
