ALTER TABLE `product_invoice`
ADD FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
ADD FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);