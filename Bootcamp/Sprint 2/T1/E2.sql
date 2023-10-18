CREATE TABLE `product`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `description` VARCHAR(500) NULL,
    `image` BLOB NULL,
    `price` DOUBLE(8, 2) NOT NULL,
    `type` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `product` ADD INDEX `product_type_index`(`type`);
CREATE TABLE `order_product`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `product` BIGINT UNSIGNED NOT NULL,
    `quantity` SMALLINT UNSIGNED NOT NULL,
    `order` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `order_product` ADD INDEX `order_product_product_index`(`product`);
ALTER TABLE
    `order_product` ADD INDEX `order_product_order_index`(`order`);
CREATE TABLE `order`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `client` BIGINT UNSIGNED NOT NULL,
    `time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `price` DOUBLE(8, 2) NOT NULL,
    `delivery_type` ENUM('') NOT NULL COMMENT '(\'store\', \'delivery\')',
    `store` BIGINT UNSIGNED NOT NULL,
    `worker` VARCHAR(9) NULL,
    `delivery_time` TIMESTAMP NULL COMMENT 'ON UPDATE CURRENT_TIMESTAMP'
);
ALTER TABLE
    `order` ADD INDEX `order_client_index`(`client`);
ALTER TABLE
    `order` ADD INDEX `order_store_index`(`store`);
ALTER TABLE
    `order` ADD INDEX `order_worker_index`(`worker`);
CREATE TABLE `store`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `postal_code` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT INDEX,
    `city` BIGINT UNSIGNED NOT NULL,
    `province` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `store` ADD INDEX `store_city_index`(`city`);
ALTER TABLE
    `store` ADD INDEX `store_province_index`(`province`);
CREATE TABLE `product_type`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);
CREATE TABLE `client`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(100) NOT NULL,
    `postal_code` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT INDEX,
    `city` BIGINT UNSIGNED NOT NULL,
    `province` BIGINT UNSIGNED NOT NULL,
    `phone` INT NOT NULL
);
ALTER TABLE
    `client` ADD INDEX `client_city_index`(`city`);
ALTER TABLE
    `client` ADD INDEX `client_province_index`(`province`);
CREATE TABLE `province`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL
);
CREATE TABLE `city`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `province` BIGINT UNSIGNED NOT NULL,
    `postal_code` SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT
);
ALTER TABLE
    `city` ADD INDEX `city_province_index`(`province`);
CREATE TABLE `worker`(
    `nif` VARCHAR(9) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `last_name` VARCHAR(50) NOT NULL,
    `phone` INT NOT NULL,
    `rol` ENUM('') NOT NULL COMMENT '(\'chef\', \'deliveryman\')',
    `store` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `worker` ADD PRIMARY KEY(`nif`);
ALTER TABLE
    `worker` ADD INDEX `worker_store_index`(`store`);
ALTER TABLE
    `order_product` ADD CONSTRAINT `order_product_order_foreign` FOREIGN KEY(`order`) REFERENCES `order`(`id`);
ALTER TABLE
    `product` ADD CONSTRAINT `product_type_foreign` FOREIGN KEY(`type`) REFERENCES `product_type`(`id`);
ALTER TABLE
    `client` ADD CONSTRAINT `client_province_foreign` FOREIGN KEY(`province`) REFERENCES `province`(`id`);
ALTER TABLE
    `worker` ADD CONSTRAINT `worker_store_foreign` FOREIGN KEY(`store`) REFERENCES `store`(`id`);
ALTER TABLE
    `client` ADD CONSTRAINT `client_postal_code_foreign` FOREIGN KEY(`postal_code`) REFERENCES `city`(`postal_code`);
ALTER TABLE
    `order_product` ADD CONSTRAINT `order_product_product_foreign` FOREIGN KEY(`product`) REFERENCES `product`(`id`);
ALTER TABLE
    `order` ADD CONSTRAINT `order_worker_foreign` FOREIGN KEY(`worker`) REFERENCES `worker`(`nif`);
ALTER TABLE
    `client` ADD CONSTRAINT `client_city_foreign` FOREIGN KEY(`city`) REFERENCES `city`(`id`);
ALTER TABLE
    `order` ADD CONSTRAINT `order_client_foreign` FOREIGN KEY(`client`) REFERENCES `client`(`id`);
ALTER TABLE
    `city` ADD CONSTRAINT `city_province_foreign` FOREIGN KEY(`province`) REFERENCES `province`(`id`);
ALTER TABLE
    `store` ADD CONSTRAINT `store_postal_code_foreign` FOREIGN KEY(`postal_code`) REFERENCES `city`(`postal_code`);
ALTER TABLE
    `store` ADD CONSTRAINT `store_city_foreign` FOREIGN KEY(`city`) REFERENCES `city`(`id`);
ALTER TABLE
    `order` ADD CONSTRAINT `order_store_foreign` FOREIGN KEY(`store`) REFERENCES `store`(`id`);
ALTER TABLE
    `store` ADD CONSTRAINT `store_province_foreign` FOREIGN KEY(`province`) REFERENCES `province`(`id`);