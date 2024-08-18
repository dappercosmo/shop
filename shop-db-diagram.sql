CREATE TABLE `customer` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `first_name` varchar(20) NOT NULL,
  `last_name` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` text NOT NULL,
  `created_on` timestampz,
  `updated_on` timestampz,
  `is_deleted` bool
);

CREATE TABLE `product` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` text NOT NULL,
  `description` text,
  `price` bigint NOT NULL,
  `created_on` timestampz,
  `updated_on` timestampz,
  `is_deleted` bool
);

CREATE TABLE `category` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` text NOT NULL,
  `created_on` timestampz,
  `updated_on` timestampz,
  `is_deleted` bool,
  `product_id` bigint
);

CREATE TABLE `invoice` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `customer_id` bigint,
  `total_amount` bigint,
  `created_on` timestampz,
  `updated_on` timestampz,
  `is_deleted` bool
);

CREATE TABLE `product_invoice` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `invoice_id` bigint,
  `product_id` bigint,
  `quantity` int,
  `price_per_unit` int,
  `price` bigint,
  `created_on` timestampz,
  `updated_on` timestampz,
  `is_deleted` bool
);

ALTER TABLE `category` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

ALTER TABLE `invoice` ADD FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

ALTER TABLE `product_invoice` ADD FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`);

ALTER TABLE `product_invoice` ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);
