package com.example.dictionaries_18521317_18520943;

import com.example.dictionaries_18521317_18520943.Models.APIResponse;

public interface OnFetchDataListener {
    void onFetchData(APIResponse apiResponse, String message);
    void onError(String message);
}
