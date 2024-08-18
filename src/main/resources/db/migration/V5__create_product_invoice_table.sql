CREATE TABLE `product_invoice` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `invoice_id` bigint,
  `product_id` bigint,
  `quantity` int,
  `price_per_unit` int,
  `price` bigint,
  `created_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_on` TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `is_deleted` BOOLEAN
);