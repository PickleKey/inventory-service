package com.picklekey.inventory.repository;

import com.picklekey.inventory.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    List<Ingredient> findIngredientByIngredientName(String ingredientName);
}
