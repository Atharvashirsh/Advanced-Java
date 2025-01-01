package com.recipe.dto;

import java.util.List;

public class RecipeDTO {
	Long id;

	String name;

	String author;

	List<String> ingredients;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "RecipeDTO [id=" + id + ", name=" + name + ", author=" + author + ", ingredients=" + ingredients + "]";
	}

	
}
