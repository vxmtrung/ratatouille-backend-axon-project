CREATE SCHEMA restaurant_schema;

USE restaurant_schema;

create table if not exists Assets(
    id int auto_increment primary key,
    quantity int not null,
    material char(30) not null,
    price_per_unit int not null DEFAULT -1,
    description char(255) not null,
    name char(100) not null,
    image char(100)
) auto_increment 1000000;

create table if not exists Ingredients(
    id int auto_increment primary key,
    price_per_unit int not null DEFAULT -1,
    description char(255) not null,
    quantity int not null,
    name char(100) not null,
    import_date date not null,
    expired_date date not null,
    image char(100)
) auto_increment 2000000;

INSERT INTO Assets (name, description, material, quantity, price_per_unit) VALUES
('Tables', 'Wooden dining tables', 'Wood', 20, 150),
('Chairs', 'Metal framed chairs with cushioned seats', 'Metal', 50, 80),
('Plates', 'White ceramic dinner plates', 'Ceramic', 200, 10),
('Cutlery Set', 'Stainless steel fork, knife, and spoon set', 'Stainless Steel', 100, 30),
('Cooking Pots', 'Aluminum cooking pots with lids', 'Aluminum', 30, 50),
('Glassware', 'Clear glass drinking glasses', 'Glass', 150, 5),
('Kitchen Utensils', 'Assorted kitchen utensils (spatulas, ladles, etc.)', 'Stainless Steel', 50, 20),
('Refrigerator', 'Commercial-grade refrigerator', 'Metal', 5, 2000),
('Freezer', 'Commercial-grade freezer', 'Metal', 3, 2500),
('Oven', 'Commercial-grade gas oven', 'Metal', 2, 3000),
('Dining Chairs', 'Wooden dining chairs with cushioned seats', 'Wood', 50, 100),
('Tablecloths', 'White linen tablecloths', 'Linen', 30, 20),
('Dinnerware Set', 'Porcelain dinnerware set (plates, bowls, cups)', 'Porcelain', 100, 50),
('Silverware Set', 'Stainless steel silverware set (forks, knives, spoons)', 'Stainless Steel', 100, 30),
('Glassware Set', 'Crystal glassware set (wine glasses, water glasses)', 'Crystal', 50, 80),
('Kitchen Knives', 'Professional chef knives set', 'Stainless Steel', 20, 150),
('Food Processor', 'Commercial-grade food processor', 'Metal', 5, 300),
('Blender', 'High-speed blender', 'Plastic', 10, 200),
('Coffee Machine', 'Espresso coffee machine', 'Metal', 3, 500),
('Cash Register', 'Point-of-sale cash register system', 'Plastic', 2, 1000);

INSERT INTO Ingredients (name, description, quantity, price_per_unit, import_date, expired_date) VALUES
('Tomatoes', 'Fresh red tomatoes', 100, 2, '2024-04-01', '2024-04-15'),
('Lettuce', 'Crisp green lettuce leaves', 50, 1, '2024-04-02', '2024-04-10'),
('Chicken Breast', 'Skinless chicken breast fillets', 30, 5, '2024-03-28', '2024-04-10'),
('Beef', 'Lean beef cuts', 40, 7, '2024-03-30', '2024-04-14'),
('Onions', 'Fresh onions', 80, 1, '2024-04-01', '2024-04-12'),
('Pasta', 'Durum wheat pasta', 20, 3, '2024-03-25', '2024-04-25'),
('Rice', 'Long-grain white rice', 60, 2, '2024-03-29', '2024-05-01'),
('Cheese', 'Cheddar cheese blocks', 50, 4, '2024-03-27', '2024-04-20'),
('Eggs', 'Fresh brown eggs', 100, 0.5, '2024-04-01', '2024-04-10'),
('Flour', 'All-purpose wheat flour', 40, 2, '2024-03-30', '2024-04-30'),
('Salmon Fillet', 'Fresh salmon fillets', 20, 10, '2024-04-03', '2024-04-12'),
('Shrimp', 'Large shrimp, peeled and deveined', 30, 12, '2024-04-01', '2024-04-10'),
('Bell Peppers', 'Assorted bell peppers (red, yellow, green)', 50, 1.5, '2024-04-02', '2024-04-09'),
('Mushrooms', 'Fresh button mushrooms', 40, 3, '2024-03-31', '2024-04-11'),
('Spinach', 'Fresh baby spinach leaves', 60, 2.5, '2024-04-01', '2024-04-08'),
('Garlic', 'Fresh garlic cloves', 70, 0.5, '2024-04-01', '2024-04-10'),
('Bread', 'Artisan bread loaf', 25, 4, '2024-03-29', '2024-04-05'),
('Olive Oil', 'Extra virgin olive oil', 100, 8, '2024-03-30', '2024-05-01'),
('Vinegar', 'Balsamic vinegar', 50, 6, '2024-03-28', '2024-04-25'),
('Sugar', 'Granulated white sugar', 80, 1.5, '2024-04-02', '2024-05-01');