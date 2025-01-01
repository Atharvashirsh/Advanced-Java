package com.recipe.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.dto.RecipeDTO;
import com.recipe.entity.Recipe;
import com.recipe.repository.Repository;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	Repository repo;

	@Override
	public RecipeDTO createNewRecipe(RecipeDTO dto) {
		Recipe recipe = new Recipe();
		BeanUtils.copyProperties(dto, recipe);
		Recipe newData = repo.save(recipe);
		BeanUtils.copyProperties(newData, dto);
		return dto;
	}

	@Override
	public RecipeDTO updateRecipe(RecipeDTO dto) {
		Recipe recipe = repo.findById(dto.getId()).orElse(null);
		BeanUtils.copyProperties(dto, recipe);
		Recipe newData = repo.save(recipe);
		BeanUtils.copyProperties(newData, dto);
		return dto;
	}

	@Override
	public List<RecipeDTO> getAllRecipe() {
		Iterator<Recipe> iterator = repo.findAll().iterator();
		List<RecipeDTO> recipesList = new ArrayList<RecipeDTO>();
		
		while(iterator.hasNext())
		{
			RecipeDTO dto = new RecipeDTO();
			Recipe recipe = iterator.next();
			BeanUtils.copyProperties(recipe, dto);
			recipesList.add(dto);
		}
		
		return recipesList;
	}

	@Override
	public RecipeDTO getRecipeByID(Long id) {
		Recipe recipe = repo.findById(id).orElse(null);
		RecipeDTO dto = new RecipeDTO();
		BeanUtils.copyProperties(recipe, dto);
		return dto;
	}

	@Override
	public boolean deleteRecipeByID(Long id) {
		repo.deleteById(id);
		return true;
	}

}
