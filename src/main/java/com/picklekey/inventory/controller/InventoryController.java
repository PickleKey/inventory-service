package com.picklekey.inventory.controller;

import com.picklekey.inventory.model.Dish;
import com.picklekey.inventory.model.Ingredient;
import com.picklekey.inventory.model.Inventory;
import com.picklekey.inventory.repository.DishRepository;
import com.picklekey.inventory.repository.IngredientRepository;
import com.picklekey.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/inventory")
public class InventoryController {


	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
    private DishRepository dishRepository;

	@Autowired
	private IngredientRepository ingredientRepository;

	
	@GetMapping("/list")
	public List<Inventory> getAllInventories() {
		
		// get inventory from service
		System.out.println("controller getting inventoryList");
		List<Inventory> inventoryList = inventoryRepository.findAll();

		return inventoryList;
	}

    @GetMapping("/dishes")
    public List<Dish> getAllDishes() {

        // get inventory from service
        System.out.println("controller getting dishList");
        List<Dish> dishList = dishRepository.findAll();
        return dishList;
    }

    @PostMapping("/addToInventory")
    public String addToInventory(@RequestParam("ingredient_name") String ingredientName, @RequestParam("inventory_amount") double inventoryAmount,
                                 @RequestParam("inventory_unitcost") double inventoryUnitCost, @RequestParam("inventory_unit") String inventoryUnit,
                                 @RequestParam("suppliedBy") String suppliedBy) {
        System.out.println("Getting data from request");

        Ingredient ingredient = new Ingredient();
        ingredient.setIngredientName(ingredientName);
        Inventory inventory = new Inventory();
        inventory.setUnitCost(inventoryUnitCost);
        inventory.setUnit(inventoryUnit);
        inventory.setAmount(inventoryAmount);
        inventory.setSuppliedBy(suppliedBy);
        inventory.setIngredientName(ingredient);
        inventory.setCreatedOn(LocalDateTime.now());
        inventory.setUpdatedOn(LocalDateTime.now());

        Set<Inventory> inventories = new HashSet<>();
        inventories.add(inventory);

        ingredient.setInventories(inventories);

        ingredientRepository.save(ingredient);

        return "Saved to Inventory Table";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("inventory_id") int id) {
	    Inventory inventory = inventoryRepository.findAllById(id);
	    if(inventory != null) {
            inventoryRepository.delete(inventory);
            return "deleted row successfully";
        }

        return "Invalid id passed";
    }
	

	
	
	private List<String> getUnitList() {
		
		List<String> unitList = new LinkedList();
		unitList.add("ea");
		unitList.add("ct");
		unitList.add("dz");
		unitList.add("lb");
		unitList.add("oz");
	
		return unitList;
	}
	
}
