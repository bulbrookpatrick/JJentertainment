DROP SCHEMA IF EXISTS `jjentertainmentdb`;
-- -----------------------------------------------------
-- Schema jjentertainmentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jjentertainmentdb` DEFAULT CHARACTER SET latin1;
USE `jjentertainmentdb` ;

-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`ROLE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`ROLE` (
  `role_id` INT AUTO_INCREMENT,
  `role_rolename` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE (`role_rolename`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`CLIENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`USER` (
  `user_id` INT AUTO_INCREMENT,
  `user_username` VARCHAR(255) NOT NULL,
  `user_email` VARCHAR(255) NOT NULL,
  `user_password` VARCHAR(16) NOT NULL,
  `user_first_name` VARCHAR(45) NOT NULL,
  `user_last_name` VARCHAR(45) NOT NULL,
  `user_phone_number` VARCHAR(255) NOT NULL,
  `user_preferred_contact` TINYINT(0),
  `USER_user_role_id` INT NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE (`user_username`),
  UNIQUE (`user_email`),
  CONSTRAINT `fk_USER_ROLE1`
    FOREIGN KEY (`USER_user_role_id`)
    REFERENCES `jjentertainmentdb`.`ROLE` (`role_id`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`PERFORMER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`PERFORMER` (
  `performer_id` INT AUTO_INCREMENT,
  `performer_username` VARCHAR(255) NOT NULL,
  `performer_email` VARCHAR(255) NOT NULL,
  `performer_password` VARCHAR(16) NOT NULL,
  `performer_first_name` VARCHAR(45) NOT NULL,
  `performer_last_name` VARCHAR(45) NOT NULL,
  `performer_phone_number` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`performer_id`),
  UNIQUE (`performer_email`), UNIQUE (`performer_username`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`CATEGORY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`CATEGORY` (
  `category_id` INT AUTO_INCREMENT,
  `category_name` VARCHAR(45) NOT NULL,
  `category_description` VARCHAR(255) NOT NULL,
  `category_rate` DOUBLE NOT NULL,
  `min_number_of_participants` INT NOT NULL,
  `min_number_of_performers` INT NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE (`category_name`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`EVENT`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`EVENT` (
  `event_id` INT AUTO_INCREMENT,
  `event_start_date` DATE NOT NULL,
  `event_end_date` DATE NOT NULL,
  `event_location` VARCHAR(255) NOT NULL,
  `event_status` TINYINT(0) NOT NULL DEFAULT 0,
  `event_interest` DOUBLE NOT NULL,
  `event_reservation_cost` DOUBLE NOT NULL,
  `USER_user_username` VARCHAR(255) NOT NULL,
  `event_price` DOUBLE NOT NULL,
  `event_total` DOUBLE NOT NULL,
  PRIMARY KEY (`event_id`),
  CONSTRAINT `fk_EVENT_USER1`
    FOREIGN KEY (`USER_user_username`)
    REFERENCES `jjentertainmentdb`.`USER` (`user_username`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`SERIVCE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`SERVICE` (
  `service_id` INT AUTO_INCREMENT,
  `service_start_date` DATETIME NOT NULL,
  `service_end_date` DATETIME NOT NULL,
  `service_duration` INT NULL,
  `service_price` DOUBLE NULL,
  `number_of_participants` INT NOT NULL,
  `number_of_performers_to_be_assigned` INT,
  `CATEGORY_category_id` INT NOT NULL,
  `EVENT_event_id` INT NOT NULL,
  PRIMARY KEY (`service_id`),
  CONSTRAINT `fk_SERVICE_EVENT1`
    FOREIGN KEY (`EVENT_event_id`)
    REFERENCES `jjentertainmentdb`.`EVENT` (`event_id`),
  CONSTRAINT `fk_SERVICE_CATEGORY1`
    FOREIGN KEY (`CATEGORY_category_id`)
    REFERENCES `jjentertainmentdb`.`CATEGORY` (`category_id`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`SERVICE_ASSIGN`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`SERVICE_ASSIGN` (
  `PERFORMER_performer_id` INT NOT NULL,
  `SERVICE_service_id` INT NOT NULL,
  CONSTRAINT `fk_SERVICE_ASSIGN_PERFORMER1`
    FOREIGN KEY (`PERFORMER_performer_id`)
    REFERENCES `jjentertainmentdb`.`PERFORMER` (`performer_id`),
  CONSTRAINT `fk_SERVICE_ASSIGN_SERVICE1`
    FOREIGN KEY (`SERVICE_service_id`)
    REFERENCES `jjentertainmentdb`.`SERVICE` (`service_id`));


-- -----------------------------------------------------
-- Table `jjentertainmentdb`.`PERFORMER_SPECIALTY`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jjentertainmentdb`.`PERFORMER_SPECIALTY` (
  `CATEGORY_category_id` INT NOT NULL,
  `PERFORMER_performer_id` INT NOT NULL,
  `CATEGORY_category_name` VARCHAR(45) NOT NULL,
  CONSTRAINT `fk_PERFORMER_SPECIALTY_CATEGORY1`
    FOREIGN KEY (`CATEGORY_category_id`)
    REFERENCES `jjentertainmentdb`.`CATEGORY` (`category_id`),
  CONSTRAINT `fk_PERFORMER_SPECIALTY_PERFORMER1`
    FOREIGN KEY (`PERFORMER_performer_id`)
    REFERENCES `jjentertainmentdb`.`PERFORMER` (`performer_id`),
  CONSTRAINT `fk_PERFORMER_SPECIALTY_CATEGORY2`
    FOREIGN KEY (`CATEGORY_category_name`)
    REFERENCES `jjentertainmentdb`.`CATEGORY` (`category_name`));
