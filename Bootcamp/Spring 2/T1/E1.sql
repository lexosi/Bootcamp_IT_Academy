CREATE TABLE `client`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(75) NOT NULL,
    `phone` INT NOT NULL,
    `postal_code` SMALLINT NOT NULL AUTO_INCREMENT,
    `registration_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `reference` BIGINT NULL
);
ALTER TABLE
    `client` ADD INDEX `client_reference_index`(`reference`);
CREATE TABLE `sale`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `product` BIGINT NOT NULL,
    `seller` BIGINT NOT NULL,
    `client` BIGINT NOT NULL
);
ALTER TABLE
    `sale` ADD INDEX `sale_product_index`(`product`);
ALTER TABLE
    `sale` ADD INDEX `sale_seller_index`(`seller`);
ALTER TABLE
    `sale` ADD INDEX `sale_client_index`(`client`);
CREATE TABLE `brand_policy`(
    `brand` VARCHAR(50) NOT NULL,
    `supplier_nif` VARCHAR(9) NOT NULL
);
ALTER TABLE
    `brand_policy` ADD PRIMARY KEY(`brand`);
ALTER TABLE
    `brand_policy` ADD INDEX `brand_policy_supplier_nif_index`(`supplier_nif`);
CREATE TABLE `seller`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);
CREATE TABLE `supplier`(
    `nif` VARCHAR(9) NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `phone` INT NOT NULL,
    `fax` INT NULL,
    `direction` VARCHAR(200) NOT NULL
);
ALTER TABLE
    `supplier` ADD PRIMARY KEY(`nif`);
CREATE TABLE `glasses_model`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `brand` VARCHAR(50) NOT NULL,
    `right_lens_graduation` DOUBLE(8, 2) NOT NULL,
    `left_lens_graduation` DOUBLE(8, 2) NOT NULL,
    `frame_type` ENUM('') NOT NULL COMMENT '(\'metalic\',\'plastic\',\'floating\')',
    `frame_colour` VARCHAR(50) NULL,
    `right_lens_colour` VARCHAR(50) NULL,
    `left_lens_colour` VARCHAR(50) NULL,
    `price` DOUBLE(8, 2) NOT NULL,
    `stock` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `glasses_model` ADD INDEX `glasses_model_brand_index`(`brand`);
ALTER TABLE
    `brand_policy` ADD CONSTRAINT `brand_policy_supplier_nif_foreign` FOREIGN KEY(`supplier_nif`) REFERENCES `supplier`(`nif`);
ALTER TABLE
    `sale` ADD CONSTRAINT `sale_product_foreign` FOREIGN KEY(`product`) REFERENCES `glasses_model`(`id`);
ALTER TABLE
    `glasses_model` ADD CONSTRAINT `glasses_model_brand_foreign` FOREIGN KEY(`brand`) REFERENCES `brand_policy`(`brand`);
ALTER TABLE
    `sale` ADD CONSTRAINT `sale_client_foreign` FOREIGN KEY(`client`) REFERENCES `client`(`id`);
ALTER TABLE
    `sale` ADD CONSTRAINT `sale_seller_foreign` FOREIGN KEY(`seller`) REFERENCES `seller`(`id`);
ALTER TABLE
    `client` ADD CONSTRAINT `client_reference_foreign` FOREIGN KEY(`reference`) REFERENCES `client`(`id`);