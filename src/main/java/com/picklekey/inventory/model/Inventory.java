package com.picklekey.inventory.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="inventory")
public class Inventory implements Serializable {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private int id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="ingredient_name", referencedColumnName = "ingredient_name")
    @JsonManagedReference
	private Ingredient ingredientName;
	
	@Column(name="inventory_amount")
	private double amount;
	
	@Column(name="inventory_unitcost")
	private double unitCost;
	
	@Column(name="inventory_unit")
	private String unit;

    @Column(name="supplied_by")
    private String suppliedBy;

    @Column(name="created_on")
    private LocalDateTime createdOn;

    @Column(name="updated_on")
    private LocalDateTime updatedOn;

	public Inventory() {
	    super();
    }

    public Inventory(Ingredient ingredientName, double amount, double unitCost, String unit, String suppliedBy, LocalDateTime createdOn, LocalDateTime updatedOn) {
        super();
	    this.ingredientName = ingredientName;
        this.amount = amount;
        this.unitCost = unitCost;
        this.unit = unit;
        this.suppliedBy = suppliedBy;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", ingredientName=" + ingredientName +
                ", amount=" + amount +
                ", unitCost=" + unitCost +
                ", unit='" + unit + '\'' +
                ", createdOn='" + createdOn + '\'' +
                ", updatedOn='" + updatedOn + '\'' +
                ", suppliedBy='" + suppliedBy + '\'' +
                '}';
    }
}
