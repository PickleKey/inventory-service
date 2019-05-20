package com.picklekey.inventory.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="inventory")
public class Inventory {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="inventory_id")
	private int id;
	
	@Column(name="inventory_name")
	private String name;
	
	@Column(name="inventory_amount")
	private double amount;
	
	@Column(name="inventory_unitcost")
	private double unitCost;
	
	@Column(name="inventory_unit")
	private String unit;
	
	/*@OneToMany(mappedBy = "pk.inventory",
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<SuppliedBy> suppliedBy;*/
    @Column(name="supplied_by")
    private String suppliedBy;

	
	/*@OneToMany(mappedBy = "pk.inventory",
			cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<UsedIn> usedIn;*/
	// constructor
	public Inventory() {}

	public Inventory(String name, double amount, double unitCost, String unit) {
		super();
		this.name = name;
		this.amount = amount;
		this.unitCost = unitCost;
		this.unit = unit;
	}
	
	public Inventory(String name, double amount, double unitCost, String unit, String suppliedBy) {
		super();
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
//	public List<UsedIn> getUsedIn() {
//		return usedIn;
//	}
//
//	public void setUsedIn(List<UsedIn> usedIn) {
//		this.usedIn = usedIn;
//	}
	
	// to string
	@Override
	public String toString() {
		return "Inventory [id=" + id + ", name=" + name + ", amount=" + amount + ", unitCost=" + unitCost + ", unit="
				+ unit + "]";
	}







}
