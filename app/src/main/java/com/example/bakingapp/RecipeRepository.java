package com.example.bakingapp;

import android.arch.lifecycle.MutableLiveData;


import com.example.bakingapp.api.RetrofitClientInstance;
import com.example.bakingapp.api.WebService;
import com.example.bakingapp.models.Recipe;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeRepository {

    private WebService webService;

    public RecipeRepository() {
        webService = RetrofitClientInstance.getRetrofitInstance().create(WebService.class);
    }

    public MutableLiveData<List<Recipe>> getRecipes() {
        final MutableLiveData<List<Recipe>> data = new MutableLiveData<>();
        Call<List<Recipe>> recipeCall = webService.getAllRecipes();

        recipeCall.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
