package com.recipe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.dto.RecipeDTO;
import com.recipe.dto.ResponseDTO;
import com.recipe.services.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	private RecipeService rService;
	
	@PostMapping
	public ResponseEntity<ResponseDTO<RecipeDTO>> createNewRecipe(@RequestBody RecipeDTO dto)
	{
		RecipeDTO response = rService.createNewRecipe(dto);
		return new ResponseEntity<>(new ResponseDTO<>("success","Recipe created successfully", response), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateRecipe(@PathVariable("id") Long id ,@RequestBody RecipeDTO dto)
	{
		dto.setId(id);
		RecipeDTO response = rService.updateRecipe(dto);
		return new ResponseEntity<String>("Recipe updated successfully " + response, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RecipeDTO> getRecipeByID(@PathVariable("id") Long id )
	{
		RecipeDTO response = rService.getRecipeByID(id);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	@GetMapping
	public ResponseEntity<List<RecipeDTO>> getAll()
	{
		List<RecipeDTO> response = rService.getAllRecipe();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRecipeByID(@PathVariable("id") Long id )
	{
		boolean response = rService.deleteRecipeByID(id);
		if(response)
		{
			return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);			
		}
		return new ResponseEntity<>("Error while deleting", HttpStatus.NOT_FOUND);			
		
	}
	
}
