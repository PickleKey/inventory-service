package com.picklekey.inventory.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="inventory")
public class Inventory implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private int id;

    @OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ingredient_name", referencedColumnName = "ingredient_name")
	private Ingredient ingredientName;
	
	@Column(name="inventory_amount")
	private double amount;
	
	@Column(name="inventory_unitcost")
	private double unitCost;
	
	@Column(name="inventory_unit")
	private String unit;

    @Column(name="supplied_by")
    private String suppliedBy;

	public Inventory() {}
	
	public Inventory(Ingredient name, double amount, double unitCost, String unit, String suppliedBy) {
		super();
		this.ingredientName = name;
		this.amount = amount;
		this.unitCost = unitCost;
		this.unit = unit;
		this.suppliedBy = suppliedBy;
	}

	// getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public Ingredient getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(Ingredient ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSuppliedBy() {
		return suppliedBy;
	}

	public void setSuppliedBy(String suppliedBy) {
		this.suppliedBy = suppliedBy;
	}
	

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", ingredientName=" + ingredientName +
                ", amount=" + amount +
                ", unitCost=" + unitCost +
                ", unit='" + unit + '\'' +
                ", suppliedBy='" + suppliedBy + '\'' +
                '}';
    }
}
