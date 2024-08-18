CREATE TABLE `category` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` text NOT NULL,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` BOOLEAN,
  `product_id` bigint
);