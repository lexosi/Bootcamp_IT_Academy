CREATE TABLE `follow_registry`(
    `user_id` BIGINT UNSIGNED NOT NULL,
    `artist` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `follow_registry` ADD INDEX `follow_registry_user_id_index`(`user_id`);
ALTER TABLE
    `follow_registry` ADD INDEX `follow_registry_artist_index`(`artist`);
CREATE TABLE `subscription`(
    `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `subscription_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `renovation_date` TIMESTAMP NULL,
    `payment_method` BIGINT UNSIGNED NOT NULL
);
CREATE TABLE `shared_playlist_user`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `playlist_id` BIGINT UNSIGNED NOT NULL,
    `shared_user` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `shared_playlist_user` ADD INDEX `shared_playlist_user_playlist_id_index`(`playlist_id`);
ALTER TABLE
    `shared_playlist_user` ADD INDEX `shared_playlist_user_shared_user_index`(`shared_user`);
CREATE TABLE `playlist_action`(
    `shared_playlist_user` BIGINT UNSIGNED NOT NULL,
    `playlist_song` BIGINT UNSIGNED NOT NULL,
    `added` TINYINT(1) NOT NULL,
    `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE
    `playlist_action` ADD INDEX `playlist_action_shared_playlist_user_index`(`shared_playlist_user`);
ALTER TABLE
    `playlist_action` ADD INDEX `playlist_action_playlist_song_index`(`playlist_song`);
CREATE TABLE `album`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `artist` BIGINT UNSIGNED NOT NULL,
    `title` TINYTEXT NOT NULL,
    `publish_year` YEAR NOT NULL
);
ALTER TABLE
    `album` ADD INDEX `album_artist_index`(`artist`);
CREATE TABLE `payment`(
    `order_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id` BIGINT UNSIGNED NOT NULL,
    `date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `price` DOUBLE(8, 2) NOT NULL,
    `payment_method` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `payment` ADD INDEX `payment_user_id_index`(`user_id`);
ALTER TABLE
    `payment` ADD INDEX `payment_payment_method_index`(`payment_method`);
CREATE TABLE `artist`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` TINYTEXT NULL,
    `profile_image` TINYTEXT NULL
);
CREATE TABLE `playlist`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `owner` BIGINT UNSIGNED NOT NULL,
    `deleted` TINYINT(1) NOT NULL DEFAULT '0',
    `title` TINYTEXT NOT NULL,
    `creation_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `delete_date` TIMESTAMP NULL
);
ALTER TABLE
    `playlist` ADD INDEX `playlist_owner_index`(`owner`);
CREATE TABLE `artist_relation`(
    `artist` BIGINT UNSIGNED NOT NULL,
    `other_artist` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `artist_relation` ADD INDEX `artist_relation_artist_index`(`artist`);
ALTER TABLE
    `artist_relation` ADD INDEX `artist_relation_other_artist_index`(`other_artist`);
CREATE TABLE `playlist_song`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `playlist_id` BIGINT UNSIGNED NOT NULL,
    `song_id` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `playlist_song` ADD INDEX `playlist_song_playlist_id_index`(`playlist_id`);
ALTER TABLE
    `playlist_song` ADD INDEX `playlist_song_song_id_index`(`song_id`);
CREATE TABLE `song`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `album` BIGINT UNSIGNED NULL,
    `title` TINYTEXT NOT NULL,
    `duration` TIME NOT NULL,
    `reproductions` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `song` ADD INDEX `song_album_index`(`album`);
CREATE TABLE `user`(
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `subscription` TINYINT(1) NOT NULL DEFAULT '0',
    `mail` TINYTEXT NOT NULL,
    `password` TINYTEXT NOT NULL,
    `username` TINYTEXT NOT NULL,
    `birthday` TIMESTAMP NOT NULL,
    `gender` ENUM('') NOT NULL COMMENT '(\'male\', \'female\', \'undefined\')',
    `country` ENUM('') NOT NULL,
    `postal_code` TINYTEXT NOT NULL
);
ALTER TABLE
    `user` ADD UNIQUE `user_mail_unique`(`mail`);
CREATE TABLE `payment_method`(
    `payment_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);
CREATE TABLE `paypal_account`(
    `user` TINYTEXT NOT NULL,
    `payment_id` BIGINT UNSIGNED NOT NULL
);
ALTER TABLE
    `paypal_account` ADD PRIMARY KEY(`user`);
ALTER TABLE
    `paypal_account` ADD UNIQUE `paypal_account_payment_id_unique`(`payment_id`);
CREATE TABLE `credit_card`(
    `number` INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `payment_id` BIGINT UNSIGNED NOT NULL,
    `secret_pin` MEDIUMINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `expiration_date` DATE NOT NULL
);
ALTER TABLE
    `credit_card` ADD UNIQUE `credit_card_payment_id_unique`(`payment_id`);
ALTER TABLE
    `user` ADD CONSTRAINT `user_id_foreign` FOREIGN KEY(`id`) REFERENCES `artist`(`id`);
ALTER TABLE
    `artist_relation` ADD CONSTRAINT `artist_relation_artist_foreign` FOREIGN KEY(`artist`) REFERENCES `artist`(`id`);
ALTER TABLE
    `follow_registry` ADD CONSTRAINT `follow_registry_artist_foreign` FOREIGN KEY(`artist`) REFERENCES `artist`(`id`);
ALTER TABLE
    `paypal_account` ADD CONSTRAINT `paypal_account_payment_id_foreign` FOREIGN KEY(`payment_id`) REFERENCES `payment_method`(`payment_id`);
ALTER TABLE
    `payment` ADD CONSTRAINT `payment_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `subscription`(`user_id`);
ALTER TABLE
    `shared_playlist_user` ADD CONSTRAINT `shared_playlist_user_playlist_id_foreign` FOREIGN KEY(`playlist_id`) REFERENCES `playlist`(`id`);
ALTER TABLE
    `shared_playlist_user` ADD CONSTRAINT `shared_playlist_user_shared_user_foreign` FOREIGN KEY(`shared_user`) REFERENCES `user`(`id`);
ALTER TABLE
    `playlist_song` ADD CONSTRAINT `playlist_song_playlist_id_foreign` FOREIGN KEY(`playlist_id`) REFERENCES `playlist`(`id`);
ALTER TABLE
    `follow_registry` ADD CONSTRAINT `follow_registry_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `user`(`id`);
ALTER TABLE
    `playlist_action` ADD CONSTRAINT `playlist_action_playlist_song_foreign` FOREIGN KEY(`playlist_song`) REFERENCES `playlist_song`(`id`);
ALTER TABLE
    `artist_relation` ADD CONSTRAINT `artist_relation_other_artist_foreign` FOREIGN KEY(`other_artist`) REFERENCES `artist`(`id`);
ALTER TABLE
    `playlist_action` ADD CONSTRAINT `playlist_action_shared_playlist_user_foreign` FOREIGN KEY(`shared_playlist_user`) REFERENCES `shared_playlist_user`(`id`);
ALTER TABLE
    `subscription` ADD CONSTRAINT `subscription_user_id_foreign` FOREIGN KEY(`user_id`) REFERENCES `user`(`id`);
ALTER TABLE
    `playlist_song` ADD CONSTRAINT `playlist_song_song_id_foreign` FOREIGN KEY(`song_id`) REFERENCES `song`(`id`);
ALTER TABLE
    `playlist` ADD CONSTRAINT `playlist_owner_foreign` FOREIGN KEY(`owner`) REFERENCES `user`(`id`);
ALTER TABLE
    `song` ADD CONSTRAINT `song_album_foreign` FOREIGN KEY(`album`) REFERENCES `album`(`id`);
ALTER TABLE
    `subscription` ADD CONSTRAINT `subscription_payment_method_foreign` FOREIGN KEY(`payment_method`) REFERENCES `payment_method`(`payment_id`);
ALTER TABLE
    `payment` ADD CONSTRAINT `payment_payment_method_foreign` FOREIGN KEY(`payment_method`) REFERENCES `payment_method`(`payment_id`);
ALTER TABLE
    `album` ADD CONSTRAINT `album_artist_foreign` FOREIGN KEY(`artist`) REFERENCES `artist`(`id`);
ALTER TABLE
    `credit_card` ADD CONSTRAINT `credit_card_payment_id_foreign` FOREIGN KEY(`payment_id`) REFERENCES `payment_method`(`payment_id`);