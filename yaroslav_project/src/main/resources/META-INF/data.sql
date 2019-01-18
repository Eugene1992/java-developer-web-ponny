INSERT INTO eshop_roles(id, version, name) VALUES (nextval('eshop_roles_id_seq'), 0, 'User');
INSERT INTO eshop_roles(id, version, name) VALUES (nextval('eshop_roles_id_seq'), 0, 'Admin');
INSERT INTO eshop_roles(id, version, name) VALUES (nextval('eshop_roles_id_seq'), 0, 'Moderator');


INSERT INTO eshop_user_details(id, version, email, first_name, last_name, phone) VALUES (nextval('eshop_user_details_id_seq'), 0, 'yaserzhan@gmail.com', 'Yaroslav', 'Serzhan', '0666141830');
INSERT INTO eshop_users(id, version, password, username, role_id, user_details_id) VALUES (nextval('eshop_users_id_seq'), 0, 'q', 'yaros', 1, 1);

INSERT INTO eshop_user_details(id, version, email, first_name, last_name, phone) VALUES (nextval('eshop_user_details_id_seq'), 0, 'qwerty@gmail.com', 'Petr', 'Petrov', '09987654');
INSERT INTO eshop_users(id, version, password, username, role_id, user_details_id) VALUES (nextval('eshop_users_id_seq'), 0, 'q', 'qwerty', 2, 2);

INSERT INTO eshop_user_details(id, version, email, first_name, last_name, phone) VALUES (nextval('eshop_user_details_id_seq'), 0, 'fedor@gmail.com', 'Fedor', 'Fedorov', '98765435');
INSERT INTO eshop_users(id, version, password, username, role_id, user_details_id) VALUES (nextval('eshop_users_id_seq'), 0, 'q', 'fedor', 3, 3);