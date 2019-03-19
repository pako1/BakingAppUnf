package com.example.bakingapp;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.bakingapp.models.Recipe;
import com.example.bakingapp.viewmodels.RecipesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecipesViewModel recipesViewModel;
    private RecipeAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        adapter = new RecipeAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        recipesViewModel = ViewModelProviders.of(MainActivity.this).get(RecipesViewModel.class);
        LiveData<List<Recipe>> recipes = recipesViewModel.getmAllRecipes();
        recipes.observe(MainActivity.this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(@Nullable List<Recipe> recipes) {
                if (recipes != null && recipes.size() > 0) {

                    adapter.setRecipes(recipes);
                }
            }
        });    }

}
