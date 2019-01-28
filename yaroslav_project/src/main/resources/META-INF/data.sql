INSERT INTO shop_roles(id, version, name) VALUES (nextval('shop_roles_id_seq'), 0, 'User');
INSERT INTO shop_roles(id, version, name) VALUES (nextval('shop_roles_id_seq'), 0, 'Admin');
INSERT INTO shop_roles(id, version, name) VALUES (nextval('shop_roles_id_seq'), 0, 'Moderator');


INSERT INTO shop_user_details(id, version, email, first_name, last_name, phone) VALUES (nextval('shop_user_details_id_seq'), 0, 'yaserzhan@gmail.com', 'Yaroslav', 'Serzhan', '0666141830');
INSERT INTO shop_users(id, version, password, username, role_id, user_details_id) VALUES (nextval('shop_users_id_seq'), 0, 'q', 'yaros', 1, 1);

INSERT INTO shop_user_details(id, version, email, first_name, last_name, phone) VALUES (nextval('shop_user_details_id_seq'), 0, 'qwerty@gmail.com', 'Petr', 'Petrov', '09987654');
INSERT INTO shop_users(id, version, password, username, role_id, user_details_id) VALUES (nextval('shop_users_id_seq'), 0, 'q', 'qwerty', 2, 2);

INSERT INTO shop_user_details(id, version, email, first_name, last_name, phone) VALUES (nextval('shop_user_details_id_seq'), 0, 'fedor@gmail.com', 'Fedor', 'Fedorov', '98765435');
INSERT INTO shop_users(id, version, password, username, role_id, user_details_id) VALUES (nextval('shop_users_id_seq'), 0, 'q', 'fedor', 3, 3);


INSERT INTO shop_discounts(id, version, amount, name) VALUES (nextval('shop_discounts_id_seq'), 0, 42.0, 'Extra Discount');
INSERT INTO shop_discounts(id, version, amount, name) VALUES (nextval('shop_discounts_id_seq'), 0, 11.0, 'Birth Discount');


INSERT INTO shop_products(id, version,img_url, category, description, price, title) VALUES (nextval('shop_products_id_seq'), 0, 'https://clipart.info/images/ccovers/1505918647iphone-x-png.png', 'Phones', 'Super super super phone', 10000, 'IPhone10');
INSERT INTO shop_products(id, version, img_url, category, description, price, title) VALUES (nextval('shop_products_id_seq'), 0, 'https://pisces.bbystatic.com/image2/BestBuy_US/images/products/6201/6201041_sd.jpg;maxHeight=640;maxWidth=550', 'Laptops', 'The best laptop in the world!!!', 22000, 'SomeLaptop');


INSERT INTO shop_categories(id, version, description, name) VALUES (nextval('shop_categories_id_seq'), 0, 'for phones', 'Phones');
INSERT INTO shop_categories(id, version, description, name) VALUES (nextval('shop_categories_id_seq'), 0, 'for laptops', 'Laptops');
INSERT INTO shop_categories(id, version, description, name) VALUES (nextval('shop_categories_id_seq'), 0, 'for apple devices', 'Apple');
INSERT INTO shop_categories(id, version, description, name) VALUES (nextval('shop_categories_id_seq'), 0, 'for samsung devices', 'Samsung');


INSERT INTO shop_products_categories(product_id, category_id) VALUES (1, 1);
INSERT INTO shop_products_categories(product_id, category_id) VALUES (1, 3);
INSERT INTO shop_products_categories(product_id, category_id) VALUES (2, 2);
INSERT INTO shop_products_categories(product_id, category_id) VALUES (2, 4);