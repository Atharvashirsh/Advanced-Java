package com.recipe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recipe.entity.Recipe;

public interface Repository extends JpaRepository<Recipe, Long> {

}
