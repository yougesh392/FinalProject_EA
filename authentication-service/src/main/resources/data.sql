INSERT INTO roles(id, name) VALUES(1, 'ADMIN'), (2, 'USER');

INSERT  INTO users(id, firstname, lastname, email, password, active) VALUES (1, 'John', 'Doe', 'admin@admin.com', '$2a$10$gTzdyHNlPK9G/PDPK.JskudKYmB/HGEb0nTrWVDTIsUQyDUvEsYSe', true);

INSERT INTO users_roles(users_id, roles_id) VALUES (1,1), (1, 2) ;