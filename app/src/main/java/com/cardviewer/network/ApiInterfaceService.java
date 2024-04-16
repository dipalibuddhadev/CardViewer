package com.cardviewer.network;

import com.cardviewer.model.CardListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterfaceService {
    @GET("credit_cards")
    Call<List<CardListResponse>> getCards(@Query("size") int size);


}
