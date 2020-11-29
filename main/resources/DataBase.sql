CREATE DATABASE IF NOT EXISTS my_lab444;
USE my_lab444;


DROP TABLE IF EXISTS bonus_account;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS good;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS packaging;
DROP TABLE IF EXISTS salon;


CREATE TABLE bonus_account (
                               id int NOT NULL AUTO_INCREMENT,
                               type varchar(20) NOT NULL,
                               promocode varchar(10) NOT NULL,
                               CONSTRAINT bonus_account_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
                      id int NOT NULL AUTO_INCREMENT,
                      name varchar(50) NOT NULL,
                      region_name varchar(50) NOT NULL,
                      CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: client
CREATE TABLE client (
                        id int NOT NULL AUTO_INCREMENT,
                        surname varchar(50) NOT NULL,
                        name varchar(50) NOT NULL,
                        birthday char(20) NULL,
                        gender varchar(10) NULL,
                        adresse varchar(50) NOT NULL,
                        native_language varchar(50) NULL,
                        zip_code varchar(6) NOT NULL,
                        phone char(12) NOT NULL,
                        email varchar(40) NOT NULL,
                        bonus_account_id int NOT NULL,
                        CONSTRAINT client_pk PRIMARY KEY (id)
);

-- Table: good
CREATE TABLE good (
                      id int NOT NULL AUTO_INCREMENT,
                      name varchar(100) NOT NULL,
                      firm varchar(50) NULL,
                      description varchar(200) NULL,
                      guarantee_in_months int NOT NULL,
                      response varchar(200) NULL,
                      in_stock bool NULL,
                      CONSTRAINT good_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE `order` (
                         id int NOT NULL AUTO_INCREMENT,
                         client_id int NOT NULL,
                         salon_id int NOT NULL,
                         packaging_id int NOT NULL,
                         delivery_in_days int NULL,
                         good_id int NOT NULL,
                         CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: packaging
CREATE TABLE packaging (
                           id int NOT NULL AUTO_INCREMENT,
                           name varchar(50) NOT NULL,
                           for_a_gift bool NOT NULL,
                           CONSTRAINT packaging_pk PRIMARY KEY (id)
);

-- Table: salon
CREATE TABLE salon (
                       id int NOT NULL AUTO_INCREMENT,
                       name varchar(50) NOT NULL,
                       phone char(12) NOT NULL,
                       salon_head varchar(100) NULL,
                       city_id int NOT NULL,
                       street_adress varchar(60) NOT NULL,
                       CONSTRAINT salon_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: client_bonus_account (table: client)
ALTER TABLE client ADD CONSTRAINT client_bonus_account FOREIGN KEY client_bonus_account (bonus_account_id)
    REFERENCES bonus_account (id);

-- Reference: order_client (table: order)
ALTER TABLE `order` ADD CONSTRAINT order_client FOREIGN KEY order_client (client_id)
    REFERENCES client (id);

-- Reference: order_good (table: order)
ALTER TABLE `order` ADD CONSTRAINT order_good FOREIGN KEY order_good (good_id)
    REFERENCES good (id);

-- Reference: order_packaging (table: order)
ALTER TABLE `order` ADD CONSTRAINT order_packaging FOREIGN KEY order_packaging (packaging_id)
    REFERENCES packaging (id);

-- Reference: order_salon (table: order)
ALTER TABLE `order` ADD CONSTRAINT order_salon FOREIGN KEY order_salon (salon_id)
    REFERENCES salon (id);

-- Reference: salon_city (table: salon)
ALTER TABLE salon ADD CONSTRAINT salon_city FOREIGN KEY salon_city (city_id)
    REFERENCES city (id);

INSERT INTO city (id, name, region_name) VALUES
(1,'Львів', 'Львівський'),
(2,'Запоріжжя' ,'Запорізький'),
(3,'Київ', 'Київський'),
(4,'Тернопіль', 'Тернопільський'),
(5,'Хмельницьк', 'Хмельницький'),
(6,'Чернігів', 'Чернігівський'),
(7,'Харків' ,'Харківський'),
(8,'Одесса' ,'Одеський'),
(9,'Херсон' ,'Херсонський'),
(10,'Рівне' ,'Рівненський');


INSERT INTO salon (id, name, phone, salon_head, city_id, street_adress) VALUES
(1, 'Нова пошта', '+38066849524', 'Василенко Дмитро', 1 ,'Наукова 98'),
(2, 'Укр пошта', '+38067846721', NULL , 2, 'Червоної калини 37а'),
(3, 'Експрес пошта', '+38066849531', 'Петро Дячук', 4, 'Сагайдачного 46'),
(4, 'Нова пошта', '+38076979541', NULL, 5, 'Бандери 98'),
(5, 'Нова пошта', '+38066849851', 'Марко Деонас', 7, 'Хрещатик 66'),
(6, 'Укр пошта', '+38066865399', NULL, 8, 'Червона 60'),
(7, 'Укр пошта', '+38067849567', NULL, 9, 'Шкільна 78'),
(8, 'Експрес пошта', '+38066841321', NULL, 10, 'Левандівська 33'),
(9, 'Нова пошта', '+3806686969', NULL, 3, 'Морська 98'),
(10, 'Нова пошта', '+38098849599', NULL, 4, 'Майданська 10');


INSERT INTO bonus_account (id, type, promocode) VALUES
(1, '15%sale',  '7678432'),
(2, '25%sale', '4657282'),
(3, '40%sale', '5897863'),
(4, 'Free product','Z456782' ),
(5, '2+1','Ytdg356fd'),
(6, 'Sale 10%','464trgf8'),
(7, '3+1','ashfe45'),
(8, '50%sale','dbhhdy45'),
(9, '2+2', '9746fgr' ),
(10, '60%Sale','feufef89');



INSERT INTO client (id, surname, name, birthday, gender, adresse,
                    native_language, zip_code, phone,  email, bonus_account_id) VALUES
(1, 'Степанчук', 'Петро', NULL, 'Чоловік',  'Зелена 60','Українська', '79067',
 '+38054789621', 'petryk.sss@gmail.com', 1),
(2, 'Орійчук ', 'Марко', NULL, 'Чоловік',   'Хрещатик 41','Українська', '79017',
 '+38054759645', 'orittt.mara@gmail.com', 3),
(3, 'Марина', 'Гданська', NULL, 'Жінка',   'Центральна 50','Українська', '79098',
 '+38054789345', 'danska.sass@gmail.com', 4),
(4, 'John', 'Markeloff', NULL, 'Чоловік',   'Жовта 33','English', '79167',
 '+38054784561', 'mark.lof98@gmail.com', 5),
(5, 'Олексій', 'Леднєв', NULL, 'Чоловік',   'Червона 70','Російська', '79067',
 '+380547800', 'ledniev.aa@gmail.com', 6),
(6, 'Пеньков', 'Олег', NULL, 'Чоловік',   'Наукова 90','Українська', '79047',
 '+38054722221', 'olko.tains@gmail.com', 7),
(7, 'Савич', 'Дмитро', NULL, 'Чоловік',   'Портова 10','Російська', '79099',
 '+38054789698', 'savycev.sss@gmail.com', 9),
(8, 'Демчук', 'Данило', NULL, 'Чоловік',   'Морська 98','Українська', '79087',
 '+38054789697', 'demchuk.sss@gmail.com', 3);


INSERT INTO packaging (id, name, for_a_gift) VALUES
(1, 'Пакет', 1),
(2, 'Бандероль', 1),
(3, 'Коробка' ,1),
(4, 'Конверт', 1),
(5, 'Конверт', 0),
(6, 'Коробка' ,0),
(7, 'Бандероль', 0),
(8, 'Пакет' ,0);


INSERT INTO good (id, name, firm,  description, guarantee_in_months, response,
                  in_stock) VALUES
(1, 'Олівець', 'Markus', NULL, 24, '10/10','1'),
(2, 'Геймпад для Xbox', 'Microsoft',   NULL, 36, '10/10','1'),
(3, 'Laptop', 'Asus',  NULL, 12, '8/10','1'),
(4, 'Статуетки гномів', NULL,  NULL, 48, '10/10','0'),
(5, 'Холодильник', 'Bosch',   NULL, 24, '8/10','1'),
(6, 'Фотоапарт', 'Нікон',   NULL, 24, '9/10','1'),
(7, 'Сорочка', 'Ла Коста',   NULL, 12, '7/10','1'),
(8, 'Мяч', 'Giabulani',   NULL, 24, '10/10','1');


INSERT INTO `order`(id, client_id, salon_id,  packaging_id, delivery_in_days,  good_id) VALUES
(1, 8, 10,  8, NULL, 1),
(2, 4, 9,  6, NULL,2),
(3, 3, 8,  4, NULL, 4),
(4, 4, 1,  2, NULL, 8),
(5, 5, 3,  1, NULL, 7),
(6, 6, 2,  3, NULL, 6),
(7, 7, 6,  5, NULL, 5),
(8, 1, 4,  7, NULL, 4);












