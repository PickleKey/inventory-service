package com.picklekey.inventory.repository;

import com.picklekey.inventory.model.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Long> {

    List<Inventory> findAll();

    //List<Inventory> getInventoriesBy(String name);

}
