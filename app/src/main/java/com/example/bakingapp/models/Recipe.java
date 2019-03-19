package com.example.bakingapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recipe {
    @SerializedName("name")
    private String name;
    @SerializedName("ingredients")
    private List<Ingredients> ingredients;
    @SerializedName("steps")
    private List<Steps> steps;
    @SerializedName("servings")
    private String servings;

    public Recipe(String name, List<Ingredients> ingredients, List<Steps> steps, String servings) {
        this.name = name;
        this.ingredients = ingredients;
        this.steps = steps;
        this.servings = servings;
    }

    public String getName() {
        return name;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    public List<Steps> getSteps() {
        return steps;
    }

    public String getServings() {
        return servings;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSteps(List<Steps> steps) {
        this.steps = steps;
    }

    public void setServings(String servings) {
        this.servings = servings;
    }
}
