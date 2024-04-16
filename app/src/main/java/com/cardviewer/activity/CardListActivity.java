package com.cardviewer.activity;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cardviewer.BaseActivity;
import com.cardviewer.R;
import com.cardviewer.adapter.CardAdapter;
import com.cardviewer.databinding.ActivityCardListBinding;
import com.cardviewer.model.CardListResponse;
import com.cardviewer.network.ApiClient;
import com.cardviewer.network.ApiInterfaceService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CardListActivity extends BaseActivity {
    ActivityCardListBinding binding;
    RecyclerView mRvCards;
    CardAdapter cardAdapter;
    List<CardListResponse> cardListModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCardListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.card_list));
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mRvCards = binding.rvCards;

        // added data from arraylist to adapter class.
        cardAdapter = new CardAdapter(cardListModels, this);

        // at last set adapter to recycler view.
        mRvCards.setLayoutManager(new LinearLayoutManager(this));
        mRvCards.setAdapter(cardAdapter);
        getCards();
    }

    //To get cards list from API
    private void getCards() {
        if (binding.prgLoader.flLoader != null)
            binding.prgLoader.flLoader.setVisibility(View.VISIBLE);
        ApiInterfaceService mApiService = ApiClient.getClient().create(ApiInterfaceService.class);
        Call<List<CardListResponse>> call = mApiService.getCards(100);
        call.enqueue(new Callback<List<CardListResponse>>() {
            @Override
            public void onResponse(Call<List<CardListResponse>> call, Response<List<CardListResponse>> response) {
                try {
                    if (response.isSuccessful()) {

                        if (binding.prgLoader.flLoader != null)
                            binding.prgLoader.flLoader.setVisibility(View.GONE);
                        if (response.body() != null){
                            cardListModels.addAll(response.body());
                            cardAdapter.notifyDataSetChanged();
                        }
                    } else {
                        if (binding.prgLoader.flLoader != null)
                            binding.prgLoader.flLoader.setVisibility(View.GONE);
                        showErrorDialog(getString(R.string.error),  getResources().getString(R.string.some_thing_went_wrong));
                    }

                } catch (NullPointerException e) {
                    e.printStackTrace();
                    binding.prgLoader.flLoader.setVisibility(View.GONE);
                    showErrorDialog(getString(R.string.error), getResources().getString(R.string.some_thing_went_wrong));
                }
            }

            @Override
            public void onFailure(Call<List<CardListResponse>> call, Throwable t) {
                if (binding.prgLoader.flLoader != null)
                    binding.prgLoader.flLoader.setVisibility(View.GONE);
                showErrorDialog(getString(R.string.error), getResources().getString(R.string.some_thing_went_wrong));
            }
        });
    }
}