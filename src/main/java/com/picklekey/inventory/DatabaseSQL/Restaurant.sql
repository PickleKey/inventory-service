/*=== Create Ingredient Table ===*/
CREATE TABLE ingredient(
  ingredient_id serial PRIMARY KEY,
  ingredient_name VARCHAR (50) UNIQUE NOT NULL
);

/*===== CREATE Inventory table ======*/
CREATE TABLE inventory(
  inventory_id serial PRIMARY KEY,
  ingredient_name VARCHAR (50) NOT NULL,
  inventory_amount DECIMAL NOT NULL,
  inventory_unitcost DECIMAL NOT NULL,
  inventory_unit VARCHAR (3) NOT NULL,
  supplied_by VARCHAR(50) NULL,
  CONSTRAINT inventory_ingredient_name_fkey FOREIGN KEY (ingredient_name)
  REFERENCES ingredient (ingredient_name) MATCH SIMPLE
  ON UPDATE NO ACTION ON DELETE NO ACTION
);


/*===== CREATE Dish Table ===========*/
CREATE TABLE dish(
  dish_id serial PRIMARY KEY,
  dish_name VARCHAR (50) NOT NULL,
  dish_type VARCHAR (20) NOT NULL,
  dish_category VARCHAR (20) NOT NULL,
  dish_cost VARCHAR (10) NOT NULL
);