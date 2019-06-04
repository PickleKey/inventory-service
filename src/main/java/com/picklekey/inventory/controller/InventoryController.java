package com.picklekey.inventory.controller;

import com.picklekey.inventory.model.Dish;
import com.picklekey.inventory.model.Ingredient;
import com.picklekey.inventory.model.Inventory;
import com.picklekey.inventory.repository.DishRepository;
import com.picklekey.inventory.repository.IngredientRepository;
import com.picklekey.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

        Set<Inventory> inventories = new HashSet<>();
        inventories.add(inventory);

        ingredient.setInventories(inventories);

        ingredientRepository.save(ingredient);

        return "Saved to Inventory Table";
    }
	
	/*@GetMapping("/suppliedBy")
	public String suppliedBy(@RequestParam("inventoryId") int id, @RequestParam("inventoryUnit") String unit,
                             @RequestParam("inventoryName") String name, Model theModel) {
		// add name and unit
		theModel.addAttribute("unit", unit);
		theModel.addAttribute("name", name);
		theModel.addAttribute("id", id);

		// get inventory list
		List[] content = vendorRepository.getVendors(id);
		if(content[0] == null || content[0].size() == 0) {
			System.out.println("supplied list by is empty at controller");
		}
		if(content[1] == null || content[1].size() == 0) {
			System.out.println("vendors list by is empty  at controller");
		}
		
		VendorList vendorList = new VendorList();
		vendorList.setVendors(content[1]);;
		
		theModel.addAttribute("supplyList", content[0]);
		theModel.addAttribute("vendorList", vendorList);
		return "supplied-by";
	}*/
	
	@GetMapping("/showFormForAdd")
	public String addInventory(Model theModel) {
		
		Inventory inventory = new Inventory();
		theModel.addAttribute("inventory", inventory);
		
		List<String> unitList = getUnitList();
		theModel.addAttribute("unitList", unitList);
		return "inventory-form";
	}
	
	/*@PostMapping("/saveInventory")
	public String saveInventory(@ModelAttribute("inventory") Inventory theInventory) {
		
		inventoryVendorS.saveInventory(theInventory);

		return "redirect:/inventory/list";
	}*/
	
	/*@GetMapping("/showFormForUpdate")
	public String updateInventory(@RequestParam("inventoryId") int inventoryId, Model theModel) {
		
		Inventory inventory = new Inventory();
		inventory = inventoryVendorS.getInventory(inventoryId);
		theModel.addAttribute("inventory",inventory);
		
		List<String> unitList = getUnitList();
		theModel.addAttribute("unitList", unitList);
		
		return "inventory-form";
		
	}*/
	
	/*@GetMapping("/delete")
	public String deleteInventory(@RequestParam("inventoryId") int inventoryId) {
		
		inventoryVendorS.deleteInventory(inventoryId);
		
		return "redirect:/inventory/list";
	}*/
	
	/*@PostMapping("/addVendor")
	public String addVendor(@RequestParam("inventoryId") int id,
                            @RequestParam("inventoryName") String name, @RequestParam("inventoryUnit") String unit,
                            @ModelAttribute("vendorList") VendorList vendorList, Model theModel) {
		
		// add name and id
		theModel.addAttribute("inventoryId", id);
		theModel.addAttribute("name", name);
		theModel.addAttribute("inventoryUnit", unit);
		
		// get other vendor's id list
		List<Vendor> oldVendor = vendorList.getVendors();
		int size = oldVendor.size();
		List<Integer> vendorsId = new LinkedList();
		for (int i = 0; i < size; i++) {
			vendorsId.add(oldVendor.get(i).getId());
			System.out.println(vendorsId.get(i));
		}
		
		// retrieve other vendors
		List<Vendor> newVendorList = inventoryVendorS.getOtherVendors(vendorsId);
		
		// add to model
		theModel.addAttribute("vendorList", newVendorList);
		
		// new Supplied By object
		SuppliedBy suppliedBy = new SuppliedBy();
		theModel.addAttribute("suppliedBy", suppliedBy);
		
		return "inventory-add-vendor";
	}
	
	@PostMapping("/saveVendor")
	public String saveVendor(@RequestParam("vendorId") int vId, @RequestParam("inventoryId") int iId,
                             @ModelAttribute("suppliedBy") SuppliedBy suppliedBy, Model theModel) {
		System.out.println("inside save Vendor");
		*//*
		int vendorId = Integer.parseInt(vId);
		int inventoryId = Integer.parseInt(iId);
		*//*
		int vendorId = vId;
		int inventoryId = iId;
		inventoryVendorS.saveSuppliedBy(inventoryId, vendorId, suppliedBy);
		return "redirect:/inventory/list";
	}*/
	
	
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
