package com.example.dictionaries_18521317_18520943.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaries_18521317_18520943.Models.Definitions;
import com.example.dictionaries_18521317_18520943.R;
import com.example.dictionaries_18521317_18520943.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class DefinitionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private final Context context;
    private final List<Definitions> definitionList;

    public DefinitionAdapter(Context context, List<Definitions> definitionList) {
        this.context = context;
        this.definitionList = definitionList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.definitions_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
        holder.textView_definition.setText("Definition:" + definitionList.get(position).getDefinition());
        holder.textView_example.setText("Example: " + definitionList.get(position).getExample());
        StringBuilder synonyms = new StringBuilder();
        StringBuilder antonyms = new StringBuilder();

        synonyms.append(definitionList.get(position).getSynomyms());
        antonyms.append(definitionList.get(position).getAntomyms());

        holder.textView_synonyms.setText(synonyms);
        holder.textView_antonynyms.setText(antonyms);

        holder.textView_synonyms.setSelected(true);
        holder.textView_antonynyms.setSelected(true);



    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
