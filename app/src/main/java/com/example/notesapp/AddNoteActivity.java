package com.example.notesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {
    private EditText title_edit_text;
    private EditText description_editText;
    private Spinner spinner_days_of_week;
    private RadioGroup radio_group_priority;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        initAndBuoldViews();
    }

    private void initAndBuoldViews() {
        title_edit_text = findViewById(R.id.title_edit_text);
        description_editText = findViewById(R.id.description_editText);
        spinner_days_of_week = findViewById(R.id.spinner_days_of_week);
        radio_group_priority = findViewById(R.id.radio_group_priority);


    }

    public void onClickAddNoteSave(View view) {
        String title = title_edit_text.getText().toString().trim();
        String description = description_editText.getText().toString().trim();
        int dayOfWeek = spinner_days_of_week.getSelectedItemPosition();
        int radioButtinId = radio_group_priority.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtinId);
        int priority = Integer.parseInt(radioButton.getText().toString());
        if (isField(title,description)){
             Note note = new Note(title,description,dayOfWeek,priority);
             mainViewModel.insertNote(note);
             Intent intent = new Intent(this,MainActivity.class);
             startActivity(intent);
             finish();
        }else {
            Toast.makeText(this, R.string.warning_fill_fields, Toast.LENGTH_SHORT).show();
        }
    }
    private boolean isField(String title,String description){
        return !title.isEmpty() && !description.isEmpty();
    }
}
