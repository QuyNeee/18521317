package com.example.dictionaries_18521317_18520943.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaries_18521317_18520943.Models.Phonetics;
import com.example.dictionaries_18521317_18520943.R;

public class PhoneticViewHolder extends RecyclerView.ViewHolder {
    public TextView textView_phonetic;
    public ImageButton imageButton_audio;


    public PhoneticViewHolder(@NonNull View itemView){
        super(itemView);
        textView_phonetic = itemView.findViewById(R.id.textView_phonetic);
        imageButton_audio = itemView.findViewById(R.id.imageButton_audio);
    }
}
