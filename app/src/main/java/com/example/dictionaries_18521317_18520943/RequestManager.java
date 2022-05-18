package com.example.dictionaries_18521317_18520943;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.dictionaries_18521317_18520943.Models.APIResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class RequestManager {

    Context context;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.dictionaryapi.dev/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getWordMeaning(OnFetchDataListener Listener, String word){
        CallDictionary callDictionary = retrofit.create(CallDictionary.class);
        Call<List<APIResponse>> call = callDictionary.callMeanings(word);

        try{
            call.enqueue(new Callback<List<APIResponse>>() {
                @Override
                public void onResponse(@NonNull Call<List<APIResponse>> call, @NonNull Response<List<APIResponse>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(context, "Error!!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    assert response.body() != null;
                    Listener.onFetchData(response.body().get(0), response.message());
                }

                @Override
                public void onFailure(@NonNull Call<List<APIResponse>> call, @NonNull Throwable t) {
                    Listener.onError("Request Failed!");

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context,"An Error Occurred", Toast.LENGTH_SHORT).show();
        }
    }

    public interface CallDictionary {
        @GET("entries/en/{word}")
        Call<List<APIResponse>> callMeanings(
                @Path("word") String word
        );

    }
}
