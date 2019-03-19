package com.example.bakingapp.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.bakingapp.RecipeRepository;
import com.example.bakingapp.models.Recipe;

import java.util.List;

public class RecipesViewModel extends ViewModel {

    private RecipeRepository repository;
    private LiveData<List<Recipe>> mAllRecipes;

    public RecipesViewModel() {
        repository = new RecipeRepository();
    }

    public LiveData<List<Recipe>> getmAllRecipes() {
        if (mAllRecipes == null) {
            mAllRecipes = repository.getRecipes();
        }
        return mAllRecipes;
    }

}
