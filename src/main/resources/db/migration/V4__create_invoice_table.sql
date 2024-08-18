CREATE TABLE `invoice` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `customer_id` bigint,
  `total_amount` bigint,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` BOOLEAN
);