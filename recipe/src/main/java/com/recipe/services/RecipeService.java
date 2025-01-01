package com.recipe.services;

import java.util.List;

import com.recipe.dto.RecipeDTO;

public interface RecipeService {

	public RecipeDTO createNewRecipe(RecipeDTO dto);
	
	public RecipeDTO updateRecipe(RecipeDTO dto);
	
	public List<RecipeDTO> getAllRecipe();
	
	public RecipeDTO getRecipeByID(Long id);
	
	public boolean deleteRecipeByID(Long id);
}
