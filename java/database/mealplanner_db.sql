rollback;
BEGIN TRANSACTION;

/* Little Bobby Tables */
DROP TABLE IF EXISTS users, meal_plan, meal, meal_recipe, recipe, recipe_ingredient, ingredient, user_pantry, user_recipe, user_meal, user_meal_plan, meal_plan_meal;
DROP SEQUENCE IF EXISTS mp_user_id, mp_meal_plan_id, mp_meal_id, mp_recipe_id, mp_ingredient_id;

/*----------------------------------------
Users Table
user_id                 PK
username                User's name
password                User's PW
-----------------------------------------*/

CREATE SEQUENCE mp_user_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE users (
    user_id int NOT NULL DEFAULT nextval('mp_user_id'),
    username varchar(50) NOT NULL,
    password varchar(200) NOT NULL,
    CONSTRAINT PK_users PRIMARY KEY (user_id)
);

/*----------------------------------------
meal_plan table
meal_plan_id            PK
user_id                 FK to users table
-----------------------------------------*/

CREATE SEQUENCE mp_meal_plan_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE meal_plan (
    meal_plan_id int NOT NULL DEFAULT nextval('mp_meal_plan_id'),
    meal_plan_name varchar(50) NOT NULL,
    user_id int NOT NULL,
    CONSTRAINT PK_meal_plan PRIMARY KEY (meal_plan_id),
    CONSTRAINT FK_meal_plan_users FOREIGN KEY (user_id) REFERENCES users (user_id)
);


/*----------------------------------------
meal table
meal_id                 PK
recipe_id               FK to recipe table
-----------------------------------------*/

CREATE SEQUENCE mp_meal_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE meal (
    meal_id int NOT NULL DEFAULT nextval('mp_meal_id'),
    meal_name varchar(50) NOT NULL ,
    CONSTRAINT PK_meal PRIMARY KEY (meal_id)
    /*CONSTRAINT FK_meal_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),*/
);

/*----------------------------------------
recipe table
reciple_id              PK
recipe_name             Recipe's name
recipe_instructions     Recipe's Instructions
category                Recipe's Category
-----------------------------------------*/

CREATE SEQUENCE mp_recipe_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE recipe (
    recipe_id int NOT NULL DEFAULT nextval('mp_recipe_id'),
    recipe_name varchar(50) NOT NULL,
    recipe_instructions varchar(5000) NOT NULL,
    category varchar(50) NOT NULL,
    CONSTRAINT PK_recipe PRIMARY KEY (recipe_id)
);

/*This is here because I couldn't set a foreign key in meal for recipe before recipe exists!*/
/*ALTER TABLE meal
     ADD CONSTRAINT FK_meal_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id);*/

/*----------------------------------------
ingredient table
ingredient_id           PK
ingredient_name         Ingredient's name
category                Ingredient's category
-----------------------------------------*/

CREATE SEQUENCE mp_ingredient_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE ingredient (
    ingredient_id int NOT NULL DEFAULT nextval('mp_ingredient_id'),
    ingredient_name varchar(50) NOT NULL,
    category varchar(50) NOT NULL,
    CONSTRAINT PK_ingredient PRIMARY KEY (ingredient_id)
);

/*----------------------------------------
meal_recipe table  (JOIN TABLE)
meal_recipe_id			PK
recipe_id               FK to recipe table
meal_id                 FK to meal table
-----------------------------------------*/

CREATE SEQUENCE mp_meal_recipe_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE meal_recipe (
	meal_recipe_id int NOT NULL DEFAULT nextval('mp_meal_recipe_id'),
    recipe_id int NOT NULL,
    meal_id int NOT NULL,
	CONSTRAINT PK_meal_recipe PRIMARY KEY (meal_recipe_id),
    CONSTRAINT FK_meal_recipe_reipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),
    CONSTRAINT FK_meal_recipe_meal FOREIGN KEY (meal_id) REFERENCES meal (meal_id)
);

/*----------------------------------------
recipe_ingredient table (JOIN TABLE)
recipe_ingredient_id	PK
ingredient_id           FK to ingredient table
recipe_id               FK to recipe table
-----------------------------------------*/

CREATE SEQUENCE mp_recipe_ingredient_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE recipe_ingredient (
	recipe_ingredient_id int NOT NULL DEFAULT nextval('mp_recipe_ingredient_id'),
    ingredient_id int NOT NULL,
    recipe_id int NOT NULL,
    count varchar(100) NOT NULL,
	CONSTRAINT PK_recipe_ingredient PRIMARY KEY (recipe_ingredient_id),
    CONSTRAINT FK_recipe_ingredient_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id),
    CONSTRAINT FK_recipe_ingredient_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id)
);

/*----------------------------------------
user_pantry table  (JOIN TABLE)
user_pantry_id			PK
user_id                 FK to user table (formerly pantry table)
ingredient_id           FK to ingredient table
-----------------------------------------*/

CREATE SEQUENCE mp_user_pantry_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE user_pantry (
	user_pantry_id int NOT NULL DEFAULT nextval('mp_user_pantry_id'),
    user_id int NOT NULL,
    ingredient_id int NOT NULL,
	CONSTRAINT PK_user_pantry PRIMARY KEY (user_pantry_id),
    CONSTRAINT FK_user_pantry_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_user_pantry_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id)
);

/*----------------------------------------
user_recipe table (JOIN TABLE)
user_recipe_id			PK
user_id                 FK to user table
recipe_id           	FK to recipe table
-----------------------------------------*/

CREATE SEQUENCE mp_user_recipe_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE user_recipe (
	user_recipe_id int NOT NULL DEFAULT nextval('mp_user_recipe_id'),
    user_id int NOT NULL,
    recipe_id int NOT NULL,
	CONSTRAINT PK_user_recipe PRIMARY KEY (user_recipe_id),
    CONSTRAINT FK_user_recipe_user FOREIGN KEY (user_id) REFERENCES users (user_id),
    CONSTRAINT FK_user_recipe_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id)
);

/*----------------------------------------
user_meal table (JOIN TABLE)
user_meal_id			PK
user_id                 FK to user table
meal_id           		FK to meal table
-----------------------------------------*/

CREATE SEQUENCE mp_user_meal_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE user_meal (
	user_meal_id int NOT NULL DEFAULT nextval('mp_user_meal_id'),
	user_id int NOT NULL,
	meal_id int NOT NULL,
	CONSTRAINT PK_user_meal PRIMARY KEY (user_meal_id),
	CONSTRAINT FK_user_meal_user FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_user_meal_meal FOREIGN KEY (meal_id) REFERENCES meal (meal_id)
);

/*----------------------------------------
meal_plan_meal table (JOIN TABLE)
meal_plan_meal_id		PK
user_id                 FK to user table
meal_id           		FK to meal table
-----------------------------------------*/

CREATE SEQUENCE mp_meal_plan_meal_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE meal_plan_meal (
	meal_plan_meal_id int NOT NULL DEFAULT nextval('mp_meal_plan_meal_id'),
	meal_id int NOT NULL,
	meal_plan_id int NOT NULL,
	CONSTRAINT PK_meal_plan_meal_id PRIMARY KEY (meal_plan_meal_id),
	CONSTRAINT FK_user_meal_plan_meal FOREIGN KEY (meal_id) REFERENCES meal (meal_id),
	CONSTRAINT FK_user_meal_plan_meal_plan FOREIGN KEY (meal_plan_id) REFERENCES meal_plan (meal_plan_id)
);

/*----------------------------------------
user_meal_plan table (JOIN TABLE)
user_meal_plan_id		PK
user_id                 FK to user table
meal_plan_id           FK to meal table
-----------------------------------------*/

CREATE SEQUENCE mp_user_meal_plan_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE user_meal_plan (
	user_meal_plan_id int NOT NULL DEFAULT nextval('mp_meal_plan_meal_id'),
	user_id int NOT NULL,
	meal_plan_id int NOT NULL,
	CONSTRAINT PK_user_meal_plan_id PRIMARY KEY (user_meal_plan_id),
	CONSTRAINT FK_user_meal_plan_user FOREIGN KEY (user_id) REFERENCES users (user_id),
	CONSTRAINT FK_user_meal_plan_meal_plan FOREIGN KEY (meal_plan_id) REFERENCES meal_plan (meal_plan_id)
);




/* DEMO USERS 
IDs 1 - 3 */ 
INSERT INTO users (username, password)
VALUES ('George', 'password'), ('Lizzie','password'), ('Ralph', 'password'); 

/*Demo Ingredients 
ID 1-6 */
INSERT INTO ingredient (ingredient_name, category)
VALUES ('Milk', 'Dairy'),('Cheese','Dairy'),('Hot Pockets', 'Frozen'),('Instant Ramen', 'Salt'),('Macaroni', 'Pasta'),('Love','Care');


/* Demo USER Ingredient  
Everybody has everything for now*/
INSERT INTO user_pantry (user_pantry_id, user_id, ingredient_id)
VALUES (1,1,1), (2,1,2), (3,1,3), (4,1,4), (5,1,5), (6,1,6), (7,2,1), (8,2,2), (9,2,3), (10,2,4), (11,2,5), (12,2,6), (13,3,1), (14,3,2), (15,3,3), (16,3,4), (17,3,5), (18,3,6);

/*Demo Recipes
DO NOT TRY THIS AT HOME*/
INSERT INTO recipe (recipe_name, category, recipe_instructions)
VALUES ('Macaroni and Cheese Dinner', 'Pasta', 'Boil two cups of water. Add Pasta. When Pasta is cooked to desired firmness, drain pasta and mix in one cup of milk and one cup of cheese'),
('Hot Pockets du Jour', 'frozen', 'Microwave one hot pocket for 2 minutes, or two for 3:30.'),
('Ramen Noodles', 'salt', 'Boil two cups of water, add ramen to the water, stir for three minutes, remove from heat and add flavor packet'),
('Glass of Milk', 'Dairy', 'Pour 8oz of cold milk into a glass.'),
('Cheese Cubes', 'Dairy', 'Cut cheese into small cubes' );

/*Demo User Recipes
Everybody gets everything again for now*/
INSERT INTO user_recipe (user_recipe_id, user_id, recipe_id)
VALUES (1,1,1), (2,1,2), (3,1,3), (4,1,4), (5,1,5), (6,2,1), (7,2,2), (8,2,3), (9,2,4), (10,2,5), (11,3,1), (12,3,2), (13,3,3), (14,3,4), (15,3,5);


/*Recipe Ingredients*/
INSERT INTO recipe_ingredient (recipe_ingredient_id,recipe_id, ingredient_id, count)
VALUES (1,1, 5, 'One Box'), (2,1,1,'One Cup'), (3,1,2,'One Cup'),
(4,2,3,'One or Two Hot Pockets'),
(5,3,4,'One Packet'),
(6,4,1,'8 oz'),
(7,5,2,'12 oz');

/* meals */
INSERT INTO meal (meal_name)
VALUES ('Family Dinner'), ('Quick Lunch'), ('Healthy Breakfast'), ('Family Lunch');

/*Meal Recipe */
INSERT INTO meal_recipe (meal_recipe_id,recipe_id, meal_id)
VALUES (1,1,1), (2,1,2), (3,1,3), (4,2,3), (5,3,4), (6,4,3), (7,4,4), (8,4,1); 

/*USER MEAL */
INSERT INTO user_meal (user_meal_id, user_id, meal_id)
VALUES (1,1,1), (2,1,2), (3,1,3), (4,1,4), (5,2,1), (6,2,2), (7,2,3), (8,2,4), (9,3,1), (10,3,2), (11,3,3), (12,3,4);

/* A Join that will list EVERYTHING inserted so far, as associated, EXCEPIT user_recipe
select (CURRENTLY DEPRECATED* 
from users
join user_pantry on user_pantry.user_id = users.user_id
join ingredient on ingredient.ingredient_id = user_pantry.ingredient_id
join recipe_ingredient on recipe_ingredient.ingredient_id = ingredient.ingredient_id
join recipe on recipe.recipe_id = recipe_ingredient.recipe_id
join recipe on meal_recipe.recipe_id = recipe.recipe_id 
join meal on meal.meal_id = meal_recipe.meal_id;
*/


COMMIT;









