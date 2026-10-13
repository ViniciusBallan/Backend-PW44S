--import.sql
insert into tb_category (name) values ('Informática');
insert into tb_category (name) values ('UD');
insert into tb_category (name) values ('Cozinha');
insert into tb_category (name) values ('Móveis');
insert into tb_category (name) values ('Eletrônico');

insert into tb_product (name, description, price, category_id, image_url) values ('Refrigerador 429L','Refrigerador 429L Branco, duplex....',1990.0,2,'https://picsum.photos/seed/notebook/400/400');
insert into tb_product (name, description, price, category_id, image_url) values ('Notebook Arus 15.6','Notebook Arus 15.6 Core I7, 16Gb Ram...',2449.0,1,'https://picsum.photos/seed/notebook/400/400');
insert into tb_product (name, description, price, category_id, image_url) values ('Monitor 27pol','Monitor Gamer 27pol 144Hz, 1ms',1129.99,1,'https://picsum.photos/seed/notebook/400/400');
insert into tb_product (name, description, price, category_id, image_url) values ('Kit Teclado e Mouse','Kit com teclado ABNT e mouse com 5 botões',199.0,1,'https://picsum.photos/seed/notebook/400/400');
insert into tb_product (name, description, price, category_id, image_url) values ('Smartphone XYZ','Smatphone com tela de 9pol, 12GB....',9999.0,5,'https://picsum.photos/seed/notebook/400/400');
insert into tb_product (name, description, price, category_id, image_url) values ('TV LCD 75pol','TV LCD 75pol, 5 HDMI...',7555.0,5,'https://picsum.photos/seed/notebook/400/400');
insert into tb_product (name, description, price, category_id, image_url) values ('Fogão 6 Bocas','Fogão 6 Bocas em aço inox, ...', 799.99,3,'https://picsum.photos/seed/notebook/400/400');
insert into tb_product (name, description, price, category_id, image_url) values ('Roteador Wi-Fi 5.4GhZ','Roteador Wi-Fi 5.4GhZ, 6 antenas...',1299.0,1,'https://picsum.photos/seed/notebook/400/400');

INSERT INTO tb_user(display_name, username, password) VALUES ('Administrador', 'admin','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');
INSERT INTO tb_user(display_name, username, password) VALUES ('Teste', 'test','$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem');

-- Endereços: o admin (user 1) tem um, o test (user 2) tem dois
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, cep, city, state) VALUES (1, 'Rua das Flores', '100', NULL, 'Centro', '85501000', 'Pato Branco', 'PR');
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, cep, city, state) VALUES (2, 'Avenida Tupi', '250', 'Apto 12', 'Vila Isabel', '85503030', 'Pato Branco', 'PR');
INSERT INTO tb_address (user_id, street, number, complement, neighborhood, cep, city, state) VALUES (2, 'Rua Pernambuco', '55', NULL, 'Trevo', '85504060', 'Pato Branco', 'PR');

-- Pedido do test (user 2), entregue no endereço 2
INSERT INTO tb_order (user_id, address_id, order_date) VALUES (2, 2, '2026-10-10 14:30:00');

-- Itens do pedido 1: Notebook (produto 2) e Kit Teclado e Mouse (produto 4)
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 2, 1, 2449.0);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 4, 3, 199.0);