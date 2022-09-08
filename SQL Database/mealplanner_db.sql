BEGIN TRANSACTION;

/* Little Bobby Tables */
DROP TABLE IF EXISTS users, meal_plan, meal, meal_recipe, recipe, recipe_ingredient, ingredient, ingredient_pantry, pantry;
DROP SEQUENCE IF EXISTS mp_user_id, mp_meal_plan_id, mp_meal_id, mp_recipe_id, mp_ingredient_id, mp_pantry_id;

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
    recipe_id int NOT NULL,
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
ALTER TABLE meal 
     ADD CONSTRAINT FK_meal_recipe_id FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id);

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
Pantry table
pantry_id               PK 
user_id                 FK to users table
-----------------------------------------*/

CREATE SEQUENCE mp_pantry_id
  INCREMENT BY 1
  START WITH 1
  NO MAXVALUE;

CREATE TABLE pantry (
    pantry_id int NOT NULL DEFAULT nextval('mp_pantry_id'),
    user_id int NOT NULL,
    CONSTRAINT PK_pantry PRIMARY KEY (pantry_id),
    CONSTRAINT FK_pantry_users FOREIGN KEY (user_id) REFERENCES users (user_id) 
);

/*---------------------------------------- 
meal_recipe table  (JOIN TABLE)
recipe_id               FK to recipe table
meal_id                 FK to meal table
-----------------------------------------*/

CREATE TABLE meal_recipe (
    recipe_id int NOT NULL,
    meal_id int NOT NULL,
    CONSTRAINT FK_meal_recipe_reipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id),
    CONSTRAINT FK_meal_recipe_meal FOREIGN KEY (meal_id) REFERENCES meal (meal_id)
);

/*---------------------------------------- 
recipe_ingredient table (JOIN TABLE)
ingredient_id           FK to ingredient table
recipe_id               FK to recipe table
-----------------------------------------*/

CREATE TABLE recipe_ingredient (
    ingredient_id int NOT NULL,
    recipe_id int NOT NULL,
    count varchar(100) NOT NULL,
    CONSTRAINT FK_recipe_ingredient_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id),
    CONSTRAINT FK_recipe_ingredient_recipe FOREIGN KEY (recipe_id) REFERENCES recipe (recipe_id)
);

/*---------------------------------------- 
ingredient_pantry table  (JOIN TABLE)
pantry_id               FK to pantry table
ingredient_id           FK to ingredient table
-----------------------------------------*/

CREATE TABLE ingredient_pantry (
    pantry_id int NOT NULL,
    ingredient_id int NOT NULL,
    CONSTRAINT FK_ingredient_pantry_pantry FOREIGN KEY (pantry_id) REFERENCES pantry (pantry_id),
    CONSTRAINT FK_ingredient_pantry_ingredient FOREIGN KEY (ingredient_id) REFERENCES ingredient (ingredient_id) 
);


/* DEMO USERS 
IDs 1 - 3 */ 
INSERT INTO users (username, password)
VALUES ('George', 'password'), ('Lizzie','password'), ('Ralph', 'password'); 

/*Demo Ingredients 
ID 1-6 */
INSERT INTO ingredient (ingredient_name, category)
VALUES ('Milk', 'Dairy'),('Cheese','Dairy'),('Hot Pockets', 'Frozen'),('Instant Ramen', 'Salt'),('Macaroni', 'Pasta'),('Love','Care');

/* Demo Pantry 
User and Pantry ID the same for simplicity*/
INSERT INTO pantry (pantry_id, user_id)
VALUES (1,1), (2,2), (3,3);

/* Demo Pantry Ingredient  
Everybody has everything for now*/
INSERT INTO ingredient_pantry (pantry_id, ingredient_id)
VALUES (1,1), (1,2), (1,3), (1,4), (1,5), (1,6), (2,1), (2,2), (2,3), (2,4), (2,5), (2,6), (3,1), (3,2), (3,3), (3,4), (3,5), (3,6);

/*Demo Recipes
DO NOT TRY THIS AT HOME*/
INSERT INTO recipe (recipe_name, category, recipe_instructions)
VALUES ('Macaroni and Cheese Dinner', 'Pasta', 'Boil two cups of water. Add Pasta. When Pasta is cooked to desired firmness, drain pasta and mix in one cup of milk and one cup of cheese'),
('Hot Pockets du Jour', 'frozen', 'Microwave one hot pocket for 2 minutes, or two for 3:30.'),
('Ramen Noodles', 'salt', 'Boil two cups of water, add ramen to the water, stir for three minutes, remove from heat and add flavor packet'),
('Glass of Milk', 'Dairy', 'Pour 8oz of cold milk into a glass.'),
('Cheese Cubes', 'Dairy', 'Cut cheese into small cubes' );


/*Recipe Ingredients*/
INSERT INTO recipe_ingredient (recipe_id, ingredient_id, count)
VALUES (1, 5, 'One Box'), (1,1,'One Cup'), (1,2,'One Cup'),
(2,3,'One or Two Hot Pockets'),
(3,4,'One Packet'),
(4,1,'8 oz'),
(5,2,'12 oz');

/* A Join that will list EVERYTHING inserted so far, as associated
select * 
from users
join pantry on pantry.user_id = users.user_id
join ingredient_pantry on ingredient_pantry.pantry_id = pantry.pantry_id
join ingredient on ingredient.ingredient_id = ingredient_pantry.ingredient_id
join recipe_ingredient on recipe_ingredient.ingredient_id = ingredient.ingredient_id
join recipe on recipe.recipe_id = recipe_ingredient.recipe_id;
*/


COMMIT;
