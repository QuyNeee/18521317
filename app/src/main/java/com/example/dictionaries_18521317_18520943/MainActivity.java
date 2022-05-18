package com.example.dictionaries_18521317_18520943;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionaries_18521317_18520943.Adapters.MeaningAdapter;
import com.example.dictionaries_18521317_18520943.Adapters.PhoneticsAdapter;
import com.example.dictionaries_18521317_18520943.Models.APIResponse;

import java.security.acl.Group;

public class MainActivity extends AppCompatActivity {
    SearchView search_view;
    TextView textView_word;
    RecyclerView recycler_phonetics, recycler_meanings;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        recycler_phonetics = findViewById(R.id.recycler_phonetic);
        recycler_meanings = findViewById(R.id.recycler_meanings);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading ..." );
        progressDialog.show();
        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getWordMeaning(listener, "hello");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response for" + query);
                progressDialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getWordMeaning(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
    private final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            {
                progressDialog.dismiss();
                if (apiResponse == null) {
                    Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                    return;
                }
                showData(apiResponse);
            }
        }

        private void showData(APIResponse apiResponse) {
            textView_word.setText("Word:" + apiResponse.getWord());
            recycler_phonetics.setHasFixedSize(true);
            recycler_phonetics.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
            phoneticsAdapter = new PhoneticsAdapter(this, apiResponse.getPhonetics());
            recycler_phonetics.setAdapter(phoneticsAdapter);

            recycler_meanings.setHasFixedSize(true);
            recycler_meanings.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));

            meaningAdapter = new MeaningAdapter(this, apiResponse.getMeanings());
            recycler_meanings.setAdapter(meaningAdapter);

        }

        @Override
        public void onError(String message) {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

        }
    };
}