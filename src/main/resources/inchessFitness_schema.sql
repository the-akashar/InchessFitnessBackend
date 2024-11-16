use database inchessFitness;

CREATE TABLE IF NOT EXISTS `contact_msg`(
    `contact_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL,
    `mobile_num` varchar(10) NOT NULL,
    `goal` varchar(100) NOT NULL,
    `message` varchar(200) NOT NULL,
    `status` varchar(10) DEFAULT NULL,
    `created_at` TIMESTAMP DEFAULT NULL,
    `created_by` varchar(50) DEFAULT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL,
    `updated_by` varchar(50) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `trainers` (
  `trainer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `specialized_in` varchar(100) NOT NULL,
  `emolument` varchar(100) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `role_id` int DEFAULT NULL,
  `address_id` int NULL,
  `created_at` TIMESTAMP DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`trainer_id`),
   FOREIGN KEY (role_id) REFERENCES roles(role_id),
   FOREIGN KEY (address_id) REFERENCES address(address_id)
);

CREATE TABLE IF NOT EXISTS `roles` (
  `role_id` int  DEFAULT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`role_id`)
);

CREATE TABLE IF NOT EXISTS `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `address1` varchar(200) NOT NULL,
  `address2` varchar(200) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zip_code` int NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`address_id`)
);

CREATE TABLE IF NOT EXISTS `clients` (
  `clients_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mobile_number` varchar(20) NOT NULL,
  `goal` varchar(100) NOT NULL,
  `trainer` varchar(100) NOT NULL,
  `fees` varchar(100) NOT NULL,
  `created_at` TIMESTAMP DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL,
   PRIMARY KEY (`clients_id`)
);



