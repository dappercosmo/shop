CREATE TABLE `product` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` text NOT NULL,
  `description` text,
  `price` bigint NOT NULL,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` BOOLEAN
);